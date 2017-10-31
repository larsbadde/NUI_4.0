package services.rnn;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;

/**
 * Created by Lars Badde
 */
public class TensorFlowGlobalValues {

    public static String CLASSIFICATION_DIR = "D:/NUI_4.0/Server/Classification/";
    public static String PREF_DIR = "D:/NUI_4.0/Server/Classification/preferences.xml";

    // RNN DEFAULT VALUES:
    public static Integer NR_OF_EPOCHS = 160;
    public static Integer NR_OF_STEPS = 1;
    public static Integer NR_OF_LAYERS = 3;
    public static Integer NR_OF_NEURONS = 200;
    public static Integer NR_OF_OUTPUTS = 12;
    public static Integer NR_OF_INPUTS = 41;
    public static Integer BATCH_SIZE = 1;
    public static Boolean PREPROCESS_COLLAPSE_REPEATED = Boolean.TRUE;
    public static Boolean CTC_MERGE_REPEATED = Boolean.FALSE;
    public static Boolean APPLY_DROPOUT = Boolean.TRUE;
    public static Float KEEP_PROB = (float) 0.5;
    public static String ACTIVATION = "tanh";
    public static Float LEARNING_RATE = (float) 0.00005;
    public static String OPTIMIZER = "adam";
    public static Float MOMENTUM = (float) 0.9;
    public static Float EPSILON = (float) 1e-08;
    public static Float DECAY_1 = (float) 0.9;
    public static Float DECAY_2 = (float) 0.9999;
    public static Boolean USE_LOCKING = Boolean.FALSE;
    public static Boolean CENTERED = Boolean.FALSE;


    private static Transformer createXmlTransformer() throws Exception {
        Transformer transformer = TransformerFactory.newInstance()
                .newTransformer();
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        return transformer;
    }

    private static void overwriteXmlFile(File xmlFile, Document document,
                                         Transformer transformer) throws FileNotFoundException,
            TransformerException {
        StreamResult result = new StreamResult(new PrintWriter(
                new FileOutputStream(xmlFile, false)));
        DOMSource source = new DOMSource(document);
        transformer.transform(source, result);
    }

    public static class Preferences {
        public Integer NR_OF_EPOCHS;
        public Integer NR_OF_STEPS;
        public Integer NR_OF_LAYERS;
        public Integer NR_OF_NEURONS;
        public Integer NR_OF_OUTPUTS;
        public Integer NR_OF_INPUTS;
        public Integer BATCH_SIZE;
        public Boolean PREPROCESS_COLLAPSE_REPEATED;
        public  Boolean CTC_MERGE_REPEATED;
        public  Boolean APPLY_DROPOUT;
        public  Float KEEP_PROB;
        public  String ACTIVATION;
        public  Float LEARNING_RATE;
        public  String OPTIMIZER;
        public  Float MOMENTUM;
        public  Float EPSILON;
        public  Float DECAY_1;
        public  Float DECAY_2;
        public  Boolean USE_LOCKING;
        public  Boolean CENTERED;

        public Preferences() {
        }

        public Preferences(Integer NR_OF_EPOCHS, Integer NR_OF_STEPS, Integer NR_OF_LAYERS, Integer NR_OF_NEURONS, Integer NR_OF_OUTPUTS, Integer NR_OF_INPUTS, Integer BATCH_SIZE, Boolean PREPROCESS_COLLAPSE_REPEATED,
                           Boolean CTC_MERGE_REPEATED, Boolean APPLY_DROPOUT, Float KEEP_PROB, String ACTIVATION, Float LEARNING_RATE, String OPTIMIZER, Float MOMENTUM, Float EPSILON,Float DECAY_1, Float DECAY_2,
                           Boolean USE_LOCKING, Boolean CENTERED) {
            this.NR_OF_EPOCHS = NR_OF_EPOCHS;
            this.NR_OF_STEPS = NR_OF_STEPS;
            this.NR_OF_LAYERS = NR_OF_LAYERS;
            this.NR_OF_NEURONS = NR_OF_NEURONS;
            this.NR_OF_OUTPUTS = NR_OF_OUTPUTS;
            this.NR_OF_INPUTS = NR_OF_INPUTS;
            this.BATCH_SIZE = BATCH_SIZE;
            this.PREPROCESS_COLLAPSE_REPEATED = PREPROCESS_COLLAPSE_REPEATED;
            this.CTC_MERGE_REPEATED = CTC_MERGE_REPEATED;
            this.APPLY_DROPOUT = APPLY_DROPOUT;
            this.KEEP_PROB = KEEP_PROB;
            this.ACTIVATION = ACTIVATION;
            this.LEARNING_RATE = LEARNING_RATE;
            this.OPTIMIZER = OPTIMIZER;
            this.MOMENTUM = MOMENTUM;
            this.EPSILON = EPSILON;
            this.DECAY_1 = DECAY_1;
            this.DECAY_2 = DECAY_2;
            this.USE_LOCKING = USE_LOCKING;
            this.CENTERED = CENTERED;

        }
    }




    // TRAINING-DATA:
    public static double test_size = 0.2;  // the ratio of the test-data compared to the whole training-data



    public static double learning_rate = 0.001;
    public static boolean only_last_label_valid = false;
    public static boolean only_first_label_invalid = true;
    public static double labeling_percentage = 0.8;  // Indicates how many percent of the sessions frames are labeled as the target gesture id. All other frames are labeled with 99 for "no gesture"
    public static int ng_label = 10;
    public static String[] TD_HEADERS = {"SessionID", "t", "HandPosition_X", "HandPosition_Y", "HandPosition_Z", "PalmNormal_pitch", "PalmNormal_yaw", "PalmNormal_roll", "Direction_pitch", "Direction_yaw", "Direction_roll", "grabAngle", "pinchDistance", "THUMB_Direction_pitch", "THUMB_Direction_yaw", "THUMB_Direction_roll", "THUMB_Center_X", "THUMB_Center_Y", "THUMB_Center_Z", "INDEX_Direction_pitch", "INDEX_Direction_yaw", "INDEX_Direction_roll", "INDEX_Center_X", "INDEX_Center_Y", "INDEX_Center_Z", "MIDDLE_Direction_pitch", "MIDDLE_Direction_yaw", "MIDDLE_Direction_roll", "MIDDLE_Center_X", "MIDDLE_Center_Y", "MIDDLE_Center_Z", "RING_Direction_pitch", "RING_Direction_yaw", "RING_Direction_roll", "RING_Center_X", "RING_Center_Y", "RING_Center_Z", "PINKY_Direction_pitch", "PINKY_Direction_yaw", "PINKY_Direction_roll", "PINKY_Center_X", "PINKY_Center_Y", "PINKY_Center_Z", "LABEL"};


    public static Preferences getPreferencesFromXML() throws Exception {
        File fXmlFile = new File(PREF_DIR);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);

        //optional, but recommended
        //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
        doc.getDocumentElement().normalize();

        NodeList nList = doc.getElementsByTagName("option");

        Preferences preferences = new Preferences();

        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            Element eElement = (Element) nNode;
            String name = eElement.getAttribute("name");
            String value = eElement.getElementsByTagName("value").item(0).getTextContent();


            // TODO not working properly...
            switch (name) {
                case "NR_OF_EPOCHS":
                    preferences.NR_OF_EPOCHS = Integer.valueOf(value);
                    break;
                case "NR_OF_STEPS":
                    preferences.NR_OF_STEPS = Integer.valueOf(value);
                    break;
                case "NR_OF_LAYERS":
                    preferences.NR_OF_LAYERS = Integer.valueOf(value);
                    break;
                case "NR_OF_NEURONS":
                    preferences.NR_OF_NEURONS = Integer.valueOf(value);
                    break;
                case "NR_OF_OUTPUTS":
                    preferences.NR_OF_OUTPUTS = Integer.valueOf(value);
                    break;
                case "NR_OF_INPUTS":
                    preferences.NR_OF_INPUTS = Integer.valueOf(value);
                    break;
                case "BATCH_SIZE":
                    preferences.BATCH_SIZE = Integer.valueOf(value);
                    break;
                case "PREPROCESS_COLLAPSE_REPEATED":
                    preferences.PREPROCESS_COLLAPSE_REPEATED = Boolean.valueOf(value);
                    break;
                case "CTC_MERGE_REPEATED":
                    preferences.CTC_MERGE_REPEATED = Boolean.valueOf(value);
                    break;
                case "APPLY_DROPOUT":
                    preferences.APPLY_DROPOUT = Boolean.valueOf(value);
                    break;
                case "KEEP_PROB":
                    preferences.KEEP_PROB = Float.valueOf(value);
                    break;
                case "ACTIVATION":
                    preferences.ACTIVATION = value;
                    break;
                case "LEARNING_RATE":
                    preferences.LEARNING_RATE = Float.valueOf(value);
                    break;
                case "OPTIMIZER":
                    preferences.OPTIMIZER = value;
                    break;
                case "MOMENTUM":
                    preferences.MOMENTUM = Float.valueOf(value);
                    break;
                case "EPSILON":
                    preferences.EPSILON = Float.valueOf(value);
                    break;
                case "DECAY_1":
                    preferences.DECAY_1 = Float.valueOf(value);
                    break;
                case "DECAY_2":
                    preferences.DECAY_2 = Float.valueOf(value);
                    break;
                case "USE_LOCKING":
                    preferences.USE_LOCKING = Boolean.valueOf(value);
                    break;
                case "CENTERED":
                    preferences.CENTERED = Boolean.valueOf(value);
                    break;
                default:
                    break;


            }

        }
        return preferences;
    }

    public static void InitiatePreferences() throws Exception {
        Preferences preferences = getPreferencesFromXML();
        NR_OF_EPOCHS = preferences.NR_OF_EPOCHS;
        NR_OF_STEPS = preferences.NR_OF_STEPS;
        NR_OF_LAYERS = preferences.NR_OF_LAYERS;
        NR_OF_NEURONS = preferences.NR_OF_NEURONS;
        NR_OF_OUTPUTS = preferences.NR_OF_OUTPUTS;
        NR_OF_INPUTS = preferences.NR_OF_INPUTS;
        BATCH_SIZE = preferences.BATCH_SIZE;
        PREPROCESS_COLLAPSE_REPEATED = preferences.PREPROCESS_COLLAPSE_REPEATED;
        CTC_MERGE_REPEATED = preferences.CTC_MERGE_REPEATED;
        APPLY_DROPOUT = preferences.APPLY_DROPOUT;
        KEEP_PROB = preferences.KEEP_PROB;
        ACTIVATION = preferences.ACTIVATION;
        LEARNING_RATE = preferences.LEARNING_RATE;
        OPTIMIZER = preferences.OPTIMIZER;
        MOMENTUM = preferences.MOMENTUM;
        EPSILON = preferences.EPSILON;
        DECAY_1 = preferences.DECAY_1;
        DECAY_2 = preferences.DECAY_2;
        USE_LOCKING = preferences.USE_LOCKING;
        CENTERED = preferences.CENTERED;

    }

    public static void writePreferencesToXML(Preferences preferences) throws Exception {

        System.out.println("DOIT");
        File fXmlFile = new File(PREF_DIR);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);

        //optional, but recommended
        //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
        doc.getDocumentElement().normalize();

        NodeList nList = doc.getElementsByTagName("option");


        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            Element eElement = (Element) nNode;
            String name = eElement.getAttribute("name");
            Node actual = eElement.getElementsByTagName("value").item(0);

            switch (name) {
                case "NR_OF_EPOCHS":
                    actual.setTextContent(String.valueOf(preferences.NR_OF_EPOCHS));
                    break;
                case "NR_OF_STEPS":
                    actual.setTextContent(String.valueOf(preferences.NR_OF_STEPS));
                    break;
                case "NR_OF_LAYERS":
                    actual.setTextContent(String.valueOf(preferences.NR_OF_LAYERS));
                    break;
                case "NR_OF_NEURONS":
                    actual.setTextContent(String.valueOf(preferences.NR_OF_NEURONS));
                    break;
                case "NR_OF_OUTPUTS":
                    actual.setTextContent(String.valueOf(preferences.NR_OF_OUTPUTS));
                    break;
                case "NR_OF_INPUTS":
                    actual.setTextContent(String.valueOf(preferences.NR_OF_INPUTS));
                    break;
                case "BATCH_SIZE":
                    actual.setTextContent(String.valueOf(preferences.BATCH_SIZE));
                    break;
                case "PREPROCESS_COLLAPSE_REPEATED":
                    actual.setTextContent(String.valueOf(preferences.PREPROCESS_COLLAPSE_REPEATED));
                    break;
                case "CTC_MERGE_REPEATED":
                    actual.setTextContent(String.valueOf(preferences.CTC_MERGE_REPEATED));
                    break;
                case "APPLY_DROPOUT":
                    actual.setTextContent(String.valueOf(preferences.APPLY_DROPOUT));
                    break;
                case "KEEP_PROB":
                    actual.setTextContent(String.valueOf(preferences.KEEP_PROB));
                    break;
                case "ACTIVATION":
                    actual.setTextContent(String.valueOf(preferences.ACTIVATION));
                    break;
                case "LEARNING_RATE":
                    actual.setTextContent(String.valueOf(preferences.LEARNING_RATE));
                    break;
                case "OPTIMIZER":
                    actual.setTextContent(String.valueOf(preferences.OPTIMIZER));
                    break;
                case "MOMENUTM":
                    actual.setTextContent(String.valueOf(preferences.MOMENTUM));
                    break;
                case "EPSILON":
                    actual.setTextContent(String.valueOf(preferences.EPSILON));
                    break;
                case "DECAY_1":
                    actual.setTextContent(String.valueOf(preferences.DECAY_1));
                    break;
                case "DECAY_2":
                    actual.setTextContent(String.valueOf(preferences.DECAY_2));
                    break;
                case "USE_LOCKING":
                    actual.setTextContent(String.valueOf(preferences.USE_LOCKING));
                    break;
                case "CENTERED":
                    actual.setTextContent(String.valueOf(preferences.CENTERED));
                    break;
                default:
                    break;


            }

        }
        Transformer transformer = createXmlTransformer();
        overwriteXmlFile(fXmlFile,doc,transformer );
    }




}
