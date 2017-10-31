package services.rnn;

import models.TrainingData;
import org.tensorflow.Graph;
import org.tensorflow.Session;
import org.tensorflow.Tensor;
import org.tensorflow.TensorFlow;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.fasterxml.jackson.databind.ObjectWriter;
import services.DatabaseAccess;
import services.wsclient.WebSocket;

import models.Hand;

import java.util.List;
import java.util.UUID;

/**
 * Created by Lars Badde
 */
public class TensorFlowMessenger {

    public static class Message {
        public String type;
        public Long userID;
        public Hand hand;
    }

    public static FilterProvider filters = new SimpleFilterProvider();

    public static ObjectMapper mapper = new ObjectMapper();

    /**
     * Pass the filter
     */
    public static ObjectWriter writer = mapper.writer(filters);

    public static void pingTF () throws Exception {

        Message msg = new Message();
        msg.type="ping";
        msg.userID=(long)1;

        String jsonString = writer.writeValueAsString(msg);
        WebSocket.sendString(jsonString);

    }

    public static void sendHandFrame (Hand hand) throws Exception {


        Message msg = new Message();
        msg.type="HandFrame";
        msg.userID=(long)1;
        msg.hand = hand;
        String jsonString = writer.writeValueAsString(msg);

        WebSocket.sendString(jsonString);
    }

    public static void testSequence(UUID uuid) throws Exception {
        List<TrainingData> trainingDataList =DatabaseAccess.getTrainingDataForSession(uuid);
        for (TrainingData td : trainingDataList) {
            Hand hand = TD2Hand.TD2Hand(td);
            sendHandFrame(hand);
        }
    }

}
