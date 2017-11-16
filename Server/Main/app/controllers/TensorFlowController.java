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
import services.wsclient.WebSocket;
import stats.SessionModell;
import services.rnn.*;
import views.html.*;

import java.io.*;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import java.io.IOException;
import java.text.Normalizer;
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
import play.data.DynamicForm;

/**
 * Created by Lars Badde
 */
public class TensorFlowController extends Controller {



    @Inject
    private FormFactory formFactory;

    public Result TensorFlowMain() throws Exception {

        TensorFlowMessenger.pingTF();
        return ok(tensorFlowMain.render());

    }

    public Result startTraining() throws IOException {

        String s = null;
        Process p = Runtime.
                getRuntime().
                exec("cmd /c start \"\" "+TensorFlowGlobalValues.CLASSIFICATION_DIR+"run_Train.bat");
        //Process p = Runtime.getRuntime().exec("D:/NUI4.0/ML/run_Train.bat");

        return ok(tensorFlowMain.render());

    }

    public Result startTracking() throws IOException {
        Runtime.
                getRuntime().
                exec("cmd /c start \"\" "+TensorFlowGlobalValues.CLASSIFICATION_DIR+"run_Server.bat");
        return ok(tensorFlowMain.render());

    }

    public Result TensorFlowPreferences() throws Exception {

        TensorFlowGlobalValues.Preferences preferences = TensorFlowGlobalValues.getPreferencesFromXML();

        return ok(showPreferences.render(preferences));

    }


    public static Boolean FormString2Bool(String s) {
        Boolean ret = false;
        if (s.equals("true")) {
            ret = true;
        } else if (s.equals("false")) {
            ret = false;
        }
        return ret;
    }


    public Result TensorFlowPreferencesPOST() throws Exception {


        DynamicForm dynamicForm = formFactory.form().bindFromRequest();
        System.out.println(dynamicForm.toString());

        TensorFlowGlobalValues.Preferences preferences = new TensorFlowGlobalValues.Preferences();

        preferences.NR_OF_EPOCHS = Integer.valueOf(dynamicForm.get("NR_OF_EPOCHS"));
        preferences.NR_OF_STEPS = Integer.valueOf(dynamicForm.get("NR_OF_STEPS"));
        preferences.NR_OF_LAYERS = Integer.valueOf(dynamicForm.get("NR_OF_LAYERS"));
        preferences.NR_OF_NEURONS = Integer.valueOf(dynamicForm.get("NR_OF_NEURONS"));
        preferences.NR_OF_OUTPUTS = Integer.valueOf(dynamicForm.get("NR_OF_OUTPUTS"));
        preferences.NR_OF_INPUTS = Integer.valueOf(dynamicForm.get("NR_OF_INPUTS"));
        preferences.BATCH_SIZE = Integer.valueOf(dynamicForm.get("BATCH_SIZE"));
        preferences.PREPROCESS_COLLAPSE_REPEATED = FormString2Bool(dynamicForm.get("PREPROCESS_COLLAPSE_REPEATED"));
        preferences.CTC_MERGE_REPEATED = FormString2Bool(dynamicForm.get("CTC_MERGE_REPEATED"));
        preferences.APPLY_DROPOUT = FormString2Bool(dynamicForm.get("APPLY_DROPOUT"));
        preferences.KEEP_PROB = Float.valueOf(dynamicForm.get("KEEP_PROB"));
        preferences.ACTIVATION = String.valueOf(dynamicForm.get("ACTIVATION"));
        preferences.LEARNING_RATE = Float.valueOf(dynamicForm.get("LEARNING_RATE"));
        preferences.OPTIMIZER = String.valueOf(dynamicForm.get("OPTIMIZER"));
        preferences.MOMENTUM = Float.valueOf(dynamicForm.get("MOMENTUM"));
        preferences.EPSILON = Float.valueOf(dynamicForm.get("EPSILON"));
        preferences.DECAY_1 = Float.valueOf(dynamicForm.get("DECAY_1"));
        preferences.DECAY_2 = Float.valueOf(dynamicForm.get("DECAY_2"));
        preferences.USE_LOCKING = FormString2Bool(dynamicForm.get("USE_LOCKING"));
        preferences.CENTERED = FormString2Bool(dynamicForm.get("CENTERED"));
        preferences.MIN_ACC = Float.valueOf(dynamicForm.get("MIN_ACC"));
        preferences.MAX_FKP = Float.valueOf(dynamicForm.get("MAX_FKP"));
        preferences.MAX_EPOCHS_SICNE_LAST_MAX = Integer.valueOf(dynamicForm.get("MAX_EPOCHS_SICNE_LAST_MAX"));
        preferences.MAX_TIMES_MAX_REACHED = Integer.valueOf(dynamicForm.get("MAX_TIMES_MAX_REACHED"));


        TensorFlowGlobalValues.writePreferencesToXML(preferences);

        return ok(showPreferences.render(preferences));

    }

    public Result TensorFlowConnect() throws Exception {

        try {
            WebSocket.startWS();
            return ok("Success");
        } catch (Exception e) {
            return ok(e.toString());
        }

    }

    public Result TensorFlowTestSet() throws Exception {
        String id = "1d1e66d7-7743-4297-9c08-5ce0e0357252";
        UUID uuid = UUID.fromString(id);
        System.out.println("new test sequence (" + id + ") ... ");
        TensorFlowMessenger.testSequence(uuid);
        return ok("gesendet");
    }

}