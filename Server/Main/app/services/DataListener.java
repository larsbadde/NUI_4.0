package services;

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
import controllers.TrainingController;
import models.Hand;
import models.TrainingData;
import org.reactivestreams.Publisher;
import org.slf4j.Logger;
import play.libs.F;
import play.libs.F.Either;
import play.mvc.*;
import scala.compat.java8.FutureConverters;
import services.DatabaseAccess;
import services.rnn.TensorFlowRestoreModel;
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
import org.tensorflow.Tensor;

/**
 * Created by Lars Badde
 */
@Singleton
public class DataListener  {

    /**
     *
     */


    public interface TrainingDataListener {
        void onReceiveFrame(Hand hand);
    }

    public interface PredictionDataListener {
        void runTensor(Tensor t);
    }

}