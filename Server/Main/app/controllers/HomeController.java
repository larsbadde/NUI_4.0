package controllers;

import akka.NotUsed;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Status;
import akka.japi.Pair;
import akka.stream.Materializer;
import akka.stream.OverflowStrategy;
import akka.stream.javadsl.*;
import com.fasterxml.jackson.databind.JsonNode;
import org.reactivestreams.Publisher;
import org.slf4j.Logger;
import play.libs.F;
import play.libs.F.Either;
import play.mvc.*;
import play.libs.Json;
import scala.compat.java8.FutureConverters;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import static akka.pattern.Patterns.ask;

import akka.stream.javadsl.*;
import play.libs.streams.ActorFlow;
import play.mvc.*;
import akka.actor.*;
import akka.stream.*;
import javax.inject.Inject;


import services.DatabaseAccess;
import views.html.*;

/**
 * Created by Lars Badde
 */
@Singleton
public class HomeController extends Controller {

    private Logger logger = org.slf4j.LoggerFactory.getLogger("controllers.HomeController");

    private ActorRef stocksActor;
    private ActorRef userParentActor;
    private Materializer materializer;
    private ActorSystem actorSystem;

    @Inject
    public HomeController(ActorSystem actorSystem,
                          Materializer materializer) {
        this.actorSystem = actorSystem;
        this.materializer = materializer;
    };

    public Result index() {
        return ok(views.html.index.render());
    }

    public WebSocket ws() {
        //return WebSocket.Json.acceptOrResult(request -> {

        return WebSocket.Text.accept(request ->
                ActorFlow.actorRef(ExternalWebSocketActor::props,
                        actorSystem, materializer
                )
        );

            /*



                // Log events to the console
                Sink<String, ?> in = Sink.foreach(System.out::println);

                // Send a single 'Hello!' message and then leave the socket open
                Source<String, ?> out = Source.single("Hello!").concat(Source.maybe());

                return Flow.fromSinkAndSource(in, out);
            });



            /*
            //if (sameOriginCheck(request)) {
                final CompletionStage<Flow<JsonNode, JsonNode, NotUsed>> future = wsFutureFlow(request);
                final CompletionStage<Either<Result, Flow<JsonNode, JsonNode, ?>>> stage = future.thenApplyAsync(Either::Right);
                return stage.exceptionally(this::logException);
            //} else {
              //  return forbiddenResult();
            //}
            */

        };

    /**
     * Checks that the WebSocket comes from the same origin.  This is necessary to protect
     * against Cross-Site WebSocket Hijacking as WebSocket does not implement Same Origin Policy.
     * <p>
     * See https://tools.ietf.org/html/rfc6455#section-1.3 and
     * http://blog.dewhurstsecurity.com/2013/08/30/security-testing-html5-websockets.html
     */
    public boolean sameOriginCheck(Http.RequestHeader rh) {
        final String origin = rh.getHeader("Origin");

        if (origin == null) {
            logger.error("originCheck: rejecting request because no Origin header found");
            return false;
        } else if (originMatches(origin)) {
            logger.debug("originCheck: originValue = " + origin);
            return true;
        } else {
            logger.error("originCheck: rejecting request because Origin header value " + origin + " is not in the same origin");
            return false;
        }
    }

    private boolean originMatches(String origin) {
        return origin.contains("localhost:9000") || origin.contains("localhost:19001");
    }


    /**
     * User-Handling
     */

    public Result ShowUsers() {

        return ok(userShowAll.render(DatabaseAccess.getUsers()));
    }

    public Result StartAddingAUser() {

        //TODO ...

        return ok(wip.render());
    }
    public Result getJsonUserList() {
        return ok(Json.toJson(DatabaseAccess.getUsers()));
    }
    public Result ShowUser (Long id) {

        // TODO ...

        return ok(DatabaseAccess.getUser(id).toString());
    }


    /**
     * Gesture-Handling
     */

    public Result ShowGestures() {

        return ok(gestureShowAll.render(DatabaseAccess.getGestures()));
    }

    public Result StartAddingAGesture() {

        //TODO ...

        return ok(wip.render());
    }

    public Result getJsonGestureList() {
        return ok(Json.toJson(DatabaseAccess.getGestures()));
    }

    public Result ShowGesture (Long id) {

        // TODO ...

        return ok(DatabaseAccess.getGesture(id).toString());
    }

    /**
     * Device-Handling
     */

    public Result ShowDevices() {


        return ok(deviceShowAll.render(DatabaseAccess.getDevices()));
    }

    public Result StartAddingADevice() {

        //TODO ...

        return ok(wip.render());
    }
    public Result getJsonDeviceList() {
        return ok(Json.toJson(DatabaseAccess.getDevices()));
    }

    public Result ShowDevice (Long id) {

        // TODO ...
        return ok(DatabaseAccess.getDevice(id).toString());
    }
}
