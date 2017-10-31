package services.wsclient;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.inject.*;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.framing.Framedata;
import org.java_websocket.handshake.ServerHandshake;

/**
 * Created by Lars Badde
 */
@Singleton
public class WebSocket extends WebSocketClient {

    public static WebSocket socket = null;
    public static Boolean connected = false;

    public WebSocket( URI serverUri , Draft draft ) {
        super( serverUri, draft );
    }

    public WebSocket( URI serverURI ) {
        super( serverURI );
    }

    @Override
    public void onOpen( ServerHandshake handshakedata ) {
        System.out.println( "opened connection" );
        connected=true;
        //socket.send("connected");
        // if you plan to refuse connection based on ip or httpfields overload: onWebsocketHandshakeReceivedAsClient
    }

    @Override
    public void onMessage( String message ) {
        System.out.println( "received: " + message );

    }

    @Override
    public void onFragment( Framedata fragment ) {
        System.out.println( "received fragment: " + new String( fragment.getPayloadData().array() ) );
    }

    @Override
    public void onClose( int code, String reason, boolean remote ) {
        // The codecodes are documented in class org.java_websocket.framing.CloseFrame
        System.out.println( "Connection closed by " + ( remote ? "remote peer" : "us" ) );
        connected = false;
        try {
            reconnect();
        } catch (Exception e) {
            //e.printStackTrace();
        }

    }

    @Override
    public void onError( Exception ex ) {
        ex.printStackTrace();
        // if the error is fatal then onClose will be called additionally
        try {
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }


    public static void reconnect() throws InterruptedException, IOException {
        if (!connected) {
            Thread.sleep(5000);
            try {
                System.out.println("Try reconnect ...");
                startWS();
            } catch (Exception e) {
                System.out.println("WS throws Exception "+e.toString());
                reconnect();
            }
        }

    }

    @Inject
    public static void startWS () throws URISyntaxException {
        socket= new WebSocket( new URI( "ws://localhost:8000" ), new Draft_6455() ); // more about drafts here: http://github.com/TooTallNate/Java-WebSocket/wiki/Drafts
        socket.connect();
    }

    public static void sendString(String msg) {
        if (connected){
            try {
                //System.out.println("Sending String: "+msg);
                socket.send(msg);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}