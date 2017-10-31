package controllers;

import akka.NotUsed;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Status;
import akka.japi.Pair;
import akka.stream.Materializer;
import akka.stream.OverflowStrategy;
import akka.stream.javadsl.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.scene.chart.XYChart;
import models.*;
import org.reactivestreams.Publisher;
import org.slf4j.Logger;
import play.libs.F;
import play.libs.F.Either;
import play.mvc.*;
import scala.compat.java8.FutureConverters;
import services.DataListener;
import services.DatabaseAccess;
import services.ExtractHandData;
import services.ExportTrainingData;
import stats.SessionModell;
import views.html.*;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.ArrayList;

import static akka.pattern.Patterns.ask;

import akka.stream.javadsl.*;
import play.libs.streams.ActorFlow;
import play.mvc.*;
import akka.actor.*;
import akka.stream.*;

import javax.inject.Inject;

import play.data.Form;
import play.data.FormFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Lars Badde
 */
@Singleton
public class TrainingController extends Controller implements DataListener.TrainingDataListener {


    @Inject
    private FormFactory formFactory;

    ObjectMapper mapper = new ObjectMapper();

    public static class TrainingSessionData {
        public Long user_id;
        public UUID SessionID;
        public Long gesture_id;
        public Long device_id;
    }


    private TrainingSessionData actualTrainingSessionData;
    private Boolean actualTrainingSessionData_RightHanded;
    private User actualUser;
    private Gesture actualGesture;
    public static Device actualDevice;

    /**
     * Handling Requests regarding to Training
     */
    public Result Training() {

        List<String> myList = new ArrayList<String>();
        return ok(training.render(UUID.randomUUID().toString(), DatabaseAccess.getGestures(), DatabaseAccess.getUsers(), DatabaseAccess.getDevices(), myList, null, null));
    }

    public Result Trained(List<String> infoList, UUID lastUUID) {
        List<Long> lastSession = new ArrayList<Long>();
        lastSession.add(actualGesture.id-1);
        lastSession.add(actualDevice.id-1);
        return ok(training.render(UUID.randomUUID().toString(), DatabaseAccess.getGestures(), DatabaseAccess.getUsers(), DatabaseAccess.getDevices(), infoList, lastUUID.toString(), lastSession));
    }

    public Result startTraining() throws IOException {

        JsonNode json = request().body().asJson();
        System.out.println("Received request " + json.toString());
        if (json == null) {
            return badRequest("Expecting Json data");
        } else {
            TrainingSessionData tsd = mapper.readValue(json.toString(), TrainingSessionData.class);
            actualTrainingSessionData = tsd;

            actualUser = DatabaseAccess.getUser(tsd.user_id);
            actualGesture = DatabaseAccess.getGesture(tsd.gesture_id);
            actualDevice = DatabaseAccess.getDevice(tsd.device_id);
            actualTrainingSessionData_RightHanded = actualUser.right_handed;
            ExtractHandData.setTrainingDataListener(this);

            if (tsd.SessionID == null) {
                return badRequest("Missing parameter");
            } else {
                return ok("Hello " + tsd.SessionID);
            }
        }
    }

    public Result stopTraining() {


        UUID SessionID = actualTrainingSessionData.SessionID;
        ExtractHandData.stopTrainingDataListener();

        List<String> list = new ArrayList<String>();
        try {
            DatabaseAccess.Statistic statistic = DatabaseAccess.getStatisticsForTrainingSession(SessionID);
            list.add(statistic.frames + " Einzelbewegungen");
            list.add(" in " + (double) statistic.duration / (double) 1000000 + " Sekunden");
            list.add(" mit durchschnittlich " + ((float) statistic.frames / ((float) statistic.duration / 1000000)) + " Frames pro Sekunde");
        } catch (Exception e) {
            list.add(" --> Überprüfen Sie ob Ihre Hand im Trackingbereich des Sensors ist.");
            list.add(" --> Überprüfen Sie dass der Sensor funktioniert.");
            list.add(" --> Überprüfen Sie die WebSocket-Verbindung zwischen Client und Server.");
            list.add(" Error! Cause: " + e.toString());
        }

        return Trained(list, SessionID);
    }

    public Result deleteTrainingData(UUID SessionID) {

        Integer deleted = DatabaseAccess.deleteTrainingData(SessionID);

        List<String> list = new ArrayList<String>();
        list.add(deleted + " Items gelöscht");
        return Trained(list, SessionID);
    }

    public void onReceiveFrame(Hand hand) {

        DatabaseAccess.addTrainingData(actualTrainingSessionData, actualTrainingSessionData_RightHanded, actualUser, actualGesture, actualDevice, hand);
    }


    /**
     * Showing Training Data
     */



    public Result ShowUserAggregateTrainingData() {
        DatabaseAccess.getAllUserStatistics();
        return ok(wip.render());
    }

    public Result ShowGestureAggregateTrainingData(Long UserID) {
        return ok(wip.render());
    }

    public Result ShowSessionAggregateTrainingData(String SessionID) {

        return ok(showSession.render(DatabaseAccess.getSessionData(UUID.fromString(SessionID)), DatabaseAccess.getTrainingDataForSession(UUID.fromString(SessionID))));
    }

    public Result ShowSingleTrainingFrame(Long id) {

        return ok(showHandFrame.render(DatabaseAccess.getTrainingData(id)));
    }


    /**
     * Export
     */

    public Result ExportOptions() {

        return ok(exportOptions.render(DatabaseAccess.getUsers()));
    }

    public Result ExportAllTrainingData() {

        try {
            String path = ExportTrainingData.ExportAllTD();
            if (path.contains("Fehler: ")) {
                return ok(exportFeedback.render(false, path));
            } else {
                return ok(exportFeedback.render(true, path));
            }
        } catch (Exception e) {
            return ok(e.getMessage());
        }
    }

    public Result ExportTrainingDataForUser(Long id) {
        try {
            String path = ExportTrainingData.ExportTDForUser(id);
            if (path.contains("Fehler")) {
                return ok(exportFeedback.render(false, path));
            } else {
                return ok(exportFeedback.render(true, path));
            }
        } catch (Exception e) {
            return ok(e.toString());
        }
    }


}
