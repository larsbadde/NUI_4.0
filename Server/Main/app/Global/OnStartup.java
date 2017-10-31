package global;

import play.libs.F;
import play.libs.F.Either;
import play.mvc.*;
import services.wsclient.WebSocket;
import services.rnn.TensorFlowGlobalValues;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

/**
 * Created by Lars Badde
 */
@Singleton
public class OnStartup {

    @Inject
    public OnStartup() {

        try {
            WebSocket.startWS();
            TensorFlowGlobalValues.InitiatePreferences();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}