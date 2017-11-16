package controllers;

import akka.actor.*;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jdk.nashorn.internal.runtime.ECMAException;
import models.Hand;
import services.DatabaseAccess;
import services.ExtractHandData;

/**
 * Created by Lars Badde
 */
public class ExternalWebSocketActor extends UntypedAbstractActor {

    @Inject
    private DatabaseAccess databaseAccess;

    ObjectMapper mapper = new ObjectMapper();


    /**
     * classes for Frame receiving
     */

    public static class DataMessage {
        public String type;
        public String origin;
        public Long timestamp;
        public Frame40 data;
    }

    public static class Finger40 {
        public Integer id;
        public String type;
        public List<Float> direction = new ArrayList<Float>();   // Always compared to Bone: TYPE_DISTAL....
        public List<Float> center = new ArrayList<Float>();      // Always compared to Bone: TYPE_DISTAL....
    }

    public static class Hand40 {
        public Integer id;
        public Boolean isLeft;
        public Boolean isRight;
        public List<Float> HandPosition = new ArrayList<Float>();
        public List<Float> PalmNormal = new ArrayList<Float>();
        public List<Float> Direction = new ArrayList<Float>();
        public Float grabAngle;
        public Float pinchDistance;
        public List<Finger40> Fingers = new ArrayList<Finger40>();
    }

    public static class Frame40 {
        public Long id;
        public Long timestamp;
        public String DeviceID;
        public Integer NrOfHands;
        public Integer NrOfFingers;
        public List<Hand40> Hands = new ArrayList<Hand40>();
    }

    /**
     *
     */




    /**
     *
     * WebSocket:
     */
    public static Props props(ActorRef out) {
        return Props.create(ExternalWebSocketActor.class, out);
    }

    private final ActorRef out;
    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);


    public ExternalWebSocketActor(ActorRef out) {
        this.out = out;
    }

    public void onReceive(Object message) throws Exception {
        //if (message instanceof Json) {
        JsonNode json = mapper.readTree(message.toString());
        //System.out.println("Message received: "+message.toString());
        try {
            handleJson(json);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void postStop() throws Exception {
        System.out.println("Websocket is closed!");
    }

    /**
     *
     * Message-handling:
     *
     */

    public void handleJson(JsonNode msg) throws IOException {
        String type = msg.get("type").asText();
        switch (type) {
            case "trackingData":
                DataMessage dataMessage = mapper.treeToValue(msg, DataMessage.class);
                Frame40 frame = new Frame40();
                frame = dataMessage.data;

                try {
                    ExtractHandData.Frame2Hand(frame);
                } catch (Exception e) {
                    e.printStackTrace();
                }


                break;
            case "Initialize":
                System.out.println("new Device detected.");
                break;

            case "keepAlive":
                System.out.println("Keeping Connection alive .... ");
                break;
            default:
                System.out.println("Message received with unhandled type: " + type);
                break;
        }

    }


}


