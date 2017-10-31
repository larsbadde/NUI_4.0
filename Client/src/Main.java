/**
 * Created by Lars Badde on 16.07.2017.
 */

import com.leapmotion.leap.Controller;
import java.io.IOException;
import java.net.ConnectException;

public class Main {

    static LMListener lm = new LMListener();
    static Controller controller = new Controller();

    public static void main(String[] args) throws IOException, ConnectException, InterruptedException {
        System.out.println("Programm gestartet");
        System.out.println(System.getProperty("java.library.path"));




        try {
            WebSocket.startWS();
        } catch (Exception e) {
            System.out.println("WS throws Exception "+e.toString());
            WebSocket.reconnect();
        }


        // Keep this process running until Enter is pressed
        System.out.println("Press Enter to quit...");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();

        }

        // Remove the sample listener when done
        controller.removeListener(lm);
    }

    public static void startListening() {
// Create a sample listener and controller
        // Have the sample listener receive events from the controller
        controller.addListener(lm);
        System.out.println("Starting to listen to LeapMotion");
    }

    public static void log(String txt) {
        System.out.println(txt);
    }

}
