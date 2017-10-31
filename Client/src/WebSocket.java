/**
 * Created by Lars Badde on 24.07.2017.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Logger;

import javax.management.timer.Timer;
import javax.websocket.*;
import java.net.URI;
import java.net.URISyntaxException;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.glassfish.tyrus.client.ClientManager;


@ClientEndpoint
public class WebSocket {

    private static Session WSsession;

    private static CountDownLatch latch;

    private Logger logger = Logger.getLogger(this.getClass().getName());
    public static Boolean WSstatus = false;

    @OnOpen
    public void onOpen(Session session) {
        WSsession =session;
        WSstatus = true;
        logger.info("Connected ... " + session.getId());
        Main.startListening();
        try {
            session.getBasicRemote().sendText("{\"type\":\"Initialize\", \"deviceName\":\"" +LMListener.name+ "\"}");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @OnMessage
    public String onMessage(String message, Session session) {
        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
        try {
            logger.info("Received : " + message);
            String userInput = bufferRead.readLine();
            return userInput;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @OnClose
    public void onClose(Session session, CloseReason closeReason) throws IOException, InterruptedException {
        WSstatus = false;
        logger.info(String.format("Session %s close because of %s", session.getId(), closeReason));
        reconnect();
    }

    public static void startWS() throws IOException, ConnectException {


        try {
            latch = new CountDownLatch(1);

            ClientManager client = ClientManager.createClient();
            client.connectToServer(WebSocket.class, new URI("ws://localhost:9000/ws"));
            latch.await();

        } catch (DeploymentException | URISyntaxException | InterruptedException  | ConnectException e) {
            throw new RuntimeException(e);
        }
    }

    public static void sendToWS(String message) {
        try {
            if (WSstatus) {
                Main.log("Received vector: "+message);
                WSsession.getBasicRemote().sendText(message);
                //WSsession.getBasicRemote().sendObject(o);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void reconnect() throws InterruptedException, IOException {
        Thread.sleep(5000);
        try {
            WebSocket.startWS();
        } catch (Exception e) {
            System.out.println("WS throws Exception "+e.toString());
            WebSocket.reconnect();
        }
    }



}

