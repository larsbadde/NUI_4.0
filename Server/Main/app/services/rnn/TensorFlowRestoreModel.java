package services.rnn;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.*;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.*;

import com.sun.prism.PixelFormat;
import models.Hand;
import org.tensorflow.DataType;
import org.tensorflow.Graph;
import org.tensorflow.Output;
import org.tensorflow.Session;
import org.tensorflow.Tensor;
import org.tensorflow.TensorFlow;
import org.tensorflow.SavedModelBundle;
import org.tensorflow.Output;
import services.DataListener;
import services.ExtractHandData;

/**
 * Created by Lars Badde
 */
public class TensorFlowRestoreModel {

    public static String IMPORT_DIRECTORY = "Export/TrainingData/All/Model/";

    public static Session s=null;
    public static Graph g=null;


    /**
     * Sets the Servers session to the saved Session from Python script @IMPORT_DIR
     *
     * @throws IOException
     */
    public static void restore() throws IOException, FileNotFoundException {


        if (s==null || g==null) {
            byte[] graphDef = readAllBytesOrExit(Paths.get(IMPORT_DIRECTORY, "/saved_model.pbtxt"));
        /*List<String> labels =
                readAllLinesOrExit(Paths.get(IMPORT_DIRECTORY, "trained_model.txt"));
                */

            try (SavedModelBundle b = SavedModelBundle.load(IMPORT_DIRECTORY, "serve")) {
                // create the session from the Bundle
                Session sess = b.session();
                s = sess;
                g = b.graph();



                Tensor t = Tensor.create(new float[][][] {{{(float)0.8231331,(float)-5.2657013,(float)-1.1111984,(float)0.0074825287,(float)0.075252056,(float)0.07835889,(float)-0.035752058,(float)-0.035610847,(float)0.045247793,(float)1.5594741,(float)57.78549,(float)-0.21489286,(float)0.011989355,(float)0.15965772,(float)13.370155,(float)3.4708557,(float)3.7776794,(float)-1.1115816,(float)0.72939104,(float)-0.44342846,(float)11.001129,(float)10.549805,(float)-50.719162,(float)-0.8261242,(float)0.71805984,(float)-0.1849739,(float)9.334606,(float)3.0003967,(float)-52.456577,(float)-0.1875816,(float)0.19306469,(float)0.004947722,(float)5.4054375,(float)-0.8630371,(float)-24.599575,(float)1.3387873,(float)-1.1488495,(float)-2.8362968,(float)22.174248,(float)-32.095154,(float)10.069847}}});
                runTensor(t);
                runTensor(t);



            }
        }





    }


    public static void runTensor(Tensor inputTensor) throws IOException, FileNotFoundException {

            Integer gesture = null;
            Tensor y_ph = Tensor.create(new int[]{0});
            Tensor result = s.runner()
                    .feed("input_x", inputTensor)
                    .feed("Placeholder", y_ph)
                    .fetch("prediction")
                    .run().get(0);
            System.out.println(result);

            /*
            byte[] bytes = new byte[64];
            ByteBuffer buffer = ByteBuffer.wrap(bytes);
            result.writeTo(buffer);
            String output = new String(buffer.array());
            String out = new String(bytes);
            System.out.println("-"+output+"-"+out);
            char o = (char) output.charAt(0);
            int code = (int) o;
            System.out.println(" It is: "+code);
            */

    }


    private static byte[] readAllBytesOrExit(Path path) {
        try {
            return Files.readAllBytes(path);
        } catch (IOException e) {
            System.err.println("Failed to read [" + path + "]: " + e.getMessage());
            System.exit(1);
        }
        return null;
    }

    private static List<String> readAllLinesOrExit(Path path) {
        try {
            return Files.readAllLines(path, Charset.forName("UTF-8"));
        } catch (IOException e) {
            System.err.println("Failed to read [" + path + "]: " + e.getMessage());
            System.exit(0);
        }
        return null;
    }

    public static Tensor Hand2Tensor(Hand hand) {


        Tensor output = null;
        return output;

    }


}