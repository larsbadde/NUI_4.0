package services;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.ArrayList;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;
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
import java.io.BufferedReader;
import java.io.FileReader;

import com.opencsv.*;
import com.opencsv.bean.*;

import models.TrainingData;
import services.DatabaseAccess;
import services.rnn.TensorFlowGlobalValues;
import stats.SessionModell;

/**
 * Created by Lars Badde
 */
@Singleton
public class ExportTrainingData {

    public static Random random = new Random();

    public static String EXPORT_DIRECTORY = "Export/TrainingData/";

    public static String ExportTDForUser(Long userID) throws IOException {
        // TODO split data for user
        return ExportThisDataToCSV(DatabaseAccess.getTrainingDataForUser(userID), "/" + userID + "/Data/", "Train");
    }
    public static String ExportAllTD() throws IOException {
        List<ArrayList<TrainingData>> splitted_list =SplitData();

        if (ExportThisDataToCSV(splitted_list.get(0), "/ALL/Data/", "Test")!=null &&
                ExportThisDataToCSV(splitted_list.get(1), "/ALL/Data/", "Train")!=null){
            return "okay";
        } else {
            return "Fehler beim Export";
        }


    }
    public static String ExportTDForGesture (Long gestureID) throws IOException {
        return null; //TODO
    }
    public static String ExportThisDataToCSV(List<TrainingData> trainingDataList, String filepath, String filename ) throws IOException {

        File theFolder = new File(EXPORT_DIRECTORY + filepath );
        if (!theFolder.exists()) {
            theFolder.mkdir();
            System.out.println("Created directory");
        }
        DateFormat formatter = new SimpleDateFormat("yyyy_MM_dd");
        String date = formatter.format(new Date());

        String filePath = EXPORT_DIRECTORY + filepath + filename+ ".csv";
        CSVWriter writer = new CSVWriter(new FileWriter(filePath), ',', CSVWriter.NO_QUOTE_CHARACTER);
        //FileWriter fileWriter = new FileWriter(filePath);
        //Write Headline to CSV
        writer.writeNext(TensorFlowGlobalValues.TD_HEADERS);

        Integer count_t = 0;
        Integer label = TensorFlowGlobalValues.ng_label;
        UUID last_sessionID = UUID.randomUUID();
        SessionModell sessionModell = null;
        // Write Data to CSV
        for (TrainingData trainingData : trainingDataList) {
            String[] fields = new String[TensorFlowGlobalValues.NR_OF_INPUTS + 3];


            if (last_sessionID.equals(trainingData.SessionID)){
            } else {
                count_t=0;
                sessionModell = DatabaseAccess.getSessionData(trainingData.SessionID);
            }
             last_sessionID = trainingData.SessionID;


            if (count_t<(1-TensorFlowGlobalValues.labeling_percentage)*(sessionModell.c_frames-1) && !TensorFlowGlobalValues.only_last_label_valid && !TensorFlowGlobalValues.only_first_label_invalid) {
                label=TensorFlowGlobalValues.ng_label;
            } else if (count_t<(sessionModell.c_frames-1) && TensorFlowGlobalValues.only_last_label_valid && !TensorFlowGlobalValues.only_first_label_invalid)  {
                label=TensorFlowGlobalValues.ng_label;
            } else if (count_t==0 && TensorFlowGlobalValues.only_first_label_invalid){
                label=TensorFlowGlobalValues.ng_label;
            } else {
                label=trainingData.gesture.id.intValue()-1;
            }

            fields[0] = trainingData.SessionID.toString();
            fields[1] = count_t.toString();
            fields[2] = trainingData.HandPosition_X.toString();
            fields[3] = trainingData.HandPosition_Y.toString();
            fields[4] = trainingData.HandPosition_Z.toString();
            fields[5] = trainingData.PalmNormal_pitch.toString();
            fields[6] = trainingData.PalmNormal_yaw.toString();
            fields[7] = trainingData.PalmNormal_roll.toString();
            fields[8] = trainingData.Direction_pitch.toString();
            fields[9] = trainingData.Direction_yaw.toString();
            fields[10] = trainingData.Direction_roll.toString();
            fields[11] = trainingData.grabAngle.toString();
            fields[12] = trainingData.pinchDistance.toString();
            fields[13] = trainingData.THUMB_Direction_pitch.toString();
            fields[14] = trainingData.THUMB_Direction_yaw.toString();
            fields[15] = trainingData.THUMB_Direction_roll.toString();
            fields[16] = trainingData.THUMB_Center_X.toString();
            fields[17] = trainingData.THUMB_Center_Y.toString();
            fields[18] = trainingData.THUMB_Center_Z.toString();
            fields[19] = trainingData.INDEX_Direction_pitch.toString();
            fields[20] = trainingData.INDEX_Direction_yaw.toString();
            fields[21] = trainingData.INDEX_Direction_roll.toString();
            fields[22] = trainingData.INDEX_Center_X.toString();
            fields[23] = trainingData.INDEX_Center_Y.toString();
            fields[24] = trainingData.INDEX_Center_Z.toString();
            fields[25] = trainingData.MIDDLE_Direction_pitch.toString();
            fields[26] = trainingData.MIDDLE_Direction_yaw.toString();
            fields[27] = trainingData.MIDDLE_Direction_roll.toString();
            fields[28] = trainingData.MIDDLE_Center_X.toString();
            fields[29] = trainingData.MIDDLE_Center_Y.toString();
            fields[30] = trainingData.MIDDLE_Center_Z.toString();
            fields[31] = trainingData.RING_Direction_pitch.toString();
            fields[32] = trainingData.RING_Direction_yaw.toString();
            fields[33] = trainingData.RING_Direction_roll.toString();
            fields[34] = trainingData.RING_Center_X.toString();
            fields[35] = trainingData.RING_Center_Y.toString();
            fields[36] = trainingData.RING_Center_Z.toString();
            fields[37] = trainingData.PINKY_Direction_pitch.toString();
            fields[38] = trainingData.PINKY_Direction_yaw.toString();
            fields[39] = trainingData.PINKY_Direction_roll.toString();
            fields[40] = trainingData.PINKY_Center_X.toString();
            fields[41] = trainingData.PINKY_Center_Y.toString();
            fields[42] = trainingData.PINKY_Center_Z.toString();
            fields[43] = label.toString();


            writer.writeNext(fields);
            count_t++;
        }
        try {
            writer.close();

            return filePath;

            //response().setHeader("Content-disposition", "attachment; filename=" + tmpFile.getName());
            //return ok(tmpFile).as("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");

        } catch (IOException e) {
            return null;
        }
    }

    public static List<ArrayList<TrainingData>> SplitData() {

        List<UUID> sessionList = DatabaseAccess.getAllSessions();
        int c_test = (int)(TensorFlowGlobalValues.test_size*sessionList.size());
        int c_train = sessionList.size()-c_test;

        List<UUID> testList = new ArrayList<UUID>();
        List<UUID> trainList = new ArrayList<UUID>();
        int index = 0;

        List<Integer> indices = new ArrayList<Integer>();
        for (int i=0; i<c_test; i++) {
            index = random.nextInt(sessionList.size());
            if (testList.contains(index)){
                index = random.nextInt(sessionList.size());
            }
            indices.add(index);
            testList.add(sessionList.get(index));
        }
        ArrayList<TrainingData> td_test = new ArrayList<TrainingData>();
        ArrayList<TrainingData> td_train = new ArrayList<TrainingData>();
        for (UUID id : sessionList) {
            if (testList.contains(id)){
                for (TrainingData td : DatabaseAccess.getTrainingDataForSession(id)) {
                    td_test.add(td);
                }

            } else {
                for (TrainingData td : DatabaseAccess.getTrainingDataForSession(id)) {
                    td_train.add(td);
                }
            }
        }


        List<ArrayList<TrainingData>> train_test_list = new ArrayList<ArrayList<TrainingData>>();
        train_test_list.add(td_train);
        train_test_list.add(td_test);

        return train_test_list;
    }
}