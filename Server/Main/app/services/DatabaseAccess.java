package services;

import controllers.TrainingController;
import io.ebean.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.*;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.libs.Json;
import akka.stream.javadsl.*;
import play.libs.streams.ActorFlow;
import play.mvc.*;
import akka.actor.*;
import akka.stream.*;
import javax.inject.Inject;

import stats.SessionModell;
import stats.UserStat;
import views.html.*;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.time.Instant;
import java.util.*;

/**
 * Created by Lars Badde
 */
@Singleton
public class DatabaseAccess {


    @Inject
    FormFactory formFactory;

    ObjectMapper mapper = new ObjectMapper();

    /**
     * Frame related
     */

    public static long addHandToDB(Hand hand) {
        Ebean.save(hand);
        return hand.getHandID();
    }

    /**
     *
     * User
     */
    public static List<User> getUsers() {
        return Ebean.find(User.class).order().asc("id").findList();
    }

    public static User getUser (Long id) {
        User user = Ebean.find(User.class, id);
        return user;
    }

    /**
     *
     * Gesture
     */
    public static List<Gesture> getGestures() {
        return Ebean.find(Gesture.class).order().asc("id").findList();
    }

    public static Gesture getGesture (Long id) {
        Gesture gesture = Ebean.find(Gesture.class, id);
        return gesture;
    }

    /**
     * Device
     */

    public static List<Device> getDevices() {
        return  Ebean.find(Device.class).order().asc("id").findList();
    }

    public static Device getDevice (Long id) {
        Device device = Ebean.find(Device.class, id);
        return device;
    }


    /**
     * Training-Session:
     */
    public static void addTrainingData (TrainingController.TrainingSessionData tsd, Boolean rightHanded, User user, Gesture gesture, Device device,  Hand hand) {

        if (hand.isRight==rightHanded) {
            TrainingData td = new TrainingData();
            td.SessionID = tsd.SessionID;
            td.user = user;
            td.gesture = gesture;
            td.HandID = hand.HandID;
            td.timestamp = hand.timestamp;
            td.device = device;
            td.isRight = hand.isRight;
            td.HandPosition_X = hand.HandPosition_X;
            td.HandPosition_Y = hand.HandPosition_Y;
            td.HandPosition_Z = hand.HandPosition_Z;
            td.PalmNormal_pitch = hand.PalmNormal_pitch;
            td.PalmNormal_yaw = hand.PalmNormal_yaw;
            td.PalmNormal_roll = hand.PalmNormal_roll;
            td.Direction_pitch = hand.Direction_pitch;
            td.Direction_yaw = hand.Direction_yaw;
            td.Direction_roll = hand.Direction_roll;
            td.grabAngle = hand.grabAngle;
            td.pinchDistance = hand.pinchDistance;
            td.THUMB_Direction_pitch = hand.THUMB_Direction_pitch;
            td.THUMB_Direction_yaw =  hand.THUMB_Direction_yaw;
            td.THUMB_Direction_roll =  hand.THUMB_Direction_roll;
            td.THUMB_Center_X =  hand.THUMB_Center_X;
            td.THUMB_Center_Y =  hand.THUMB_Center_Y;
            td.THUMB_Center_Z =  hand.THUMB_Center_Z;
            td.INDEX_Direction_pitch =  hand.INDEX_Direction_pitch;
            td.INDEX_Direction_yaw =  hand.INDEX_Direction_yaw;
            td.INDEX_Direction_roll =  hand.INDEX_Direction_roll;
            td.INDEX_Center_X =  hand.INDEX_Center_X;
            td.INDEX_Center_Y =  hand.INDEX_Center_Y;
            td.INDEX_Center_Z =  hand.INDEX_Center_Z;
            td.MIDDLE_Direction_pitch =  hand.MIDDLE_Direction_pitch;
            td.MIDDLE_Direction_yaw =  hand.MIDDLE_Direction_yaw;
            td.MIDDLE_Direction_roll =  hand.MIDDLE_Direction_roll;
            td.MIDDLE_Center_X =  hand.MIDDLE_Center_X;
            td.MIDDLE_Center_Y =  hand.MIDDLE_Center_Y;
            td.MIDDLE_Center_Z =  hand.MIDDLE_Center_Z;
            td.RING_Direction_pitch =  hand.RING_Direction_pitch;
            td.RING_Direction_yaw =  hand.RING_Direction_yaw;
            td.RING_Direction_roll =  hand.RING_Direction_roll;
            td.RING_Center_X =  hand.RING_Center_X;
            td.RING_Center_Y =  hand.RING_Center_Y;
            td.RING_Center_Z =  hand.RING_Center_Z;
            td.PINKY_Direction_pitch =  hand.PINKY_Direction_pitch;
            td.PINKY_Direction_yaw =  hand.PINKY_Direction_yaw;
            td.PINKY_Direction_roll =  hand.PINKY_Direction_roll;
            td.PINKY_Center_X =  hand.PINKY_Center_X;
            td.PINKY_Center_Y =  hand.PINKY_Center_Y;
            td.PINKY_Center_Z =  hand.PINKY_Center_Z;



            Ebean.save(td);


        }

    }

    public static List<TrainingData> getTrainingData () {
        return Ebean.find(TrainingData.class).order().asc("timestamp").findList();
    }

    public static Integer deleteTrainingData (UUID SessionID) {
        Integer count = Ebean.find(TrainingData.class).where().eq("SessionID", SessionID).order().asc("timestamp").findList().size();
        Ebean.find(TrainingData.class).where().eq("SessionID", SessionID).delete();

        return count;
    }

    /**
     * Session-Statistics:
     */
    public static class Statistic {
        public Long frames;
        public Long duration;
        public Long userID;
        public Long deviceID;
    }
    public static Statistic getStatisticsForTrainingSession (UUID SessionID) {
        Statistic statistic = new Statistic();
        List<TrainingData> listOfTrainingData = Ebean.find(TrainingData.class).where().eq("SessionID", SessionID).order().asc("timestamp").findList();
        try {
            statistic.frames = (long) listOfTrainingData.size();
            statistic.duration = listOfTrainingData.get(listOfTrainingData.size()-1).timestamp-listOfTrainingData.get(0).timestamp;
            statistic.userID = listOfTrainingData.get(0).user.id;
            statistic.deviceID = listOfTrainingData.get(0).device.id;
            System.out.println("ID...."+statistic.userID);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return statistic;
    }

    public static List<TrainingData> getTrainingDataForSession (UUID SessionID) {

        List<TrainingData> listOfTrainingData = Ebean.find(TrainingData.class).where().eq("SessionID", SessionID).order().asc("timestamp").findList();
        return listOfTrainingData;
    }

    public static List<UserStat> getAllUserStatistics() {
        List<User> users = getUsers();
        List<UserStat> userStatList =null;
        for (User user : users ) {
           // TODO
        }
        UserStat userStat = new UserStat();


        return userStatList;
    }

    public static List<UUID> getAllSessions() {
        UUID last_UUID = UUID.randomUUID();
        List<UUID> sessionlist = new ArrayList<UUID>();
        for (TrainingData trainingData : getTrainingData()) {
            if (last_UUID.equals(trainingData.SessionID)){

            } else {
                sessionlist.add(trainingData.SessionID);
            }
            last_UUID=trainingData.SessionID;
        }
        return sessionlist;
    }

    public static SessionModell getSessionData(UUID SessionID) {
        SessionModell sessionModell = new SessionModell();
        sessionModell.id = SessionID.toString();
        TrainingData td = Ebean.find(TrainingData.class).where().eq("SessionID", SessionID).findList().get(0);
        sessionModell.gesture = td.gesture;
        sessionModell.user = td.user;
        List<TrainingData> trainingDataList = Ebean.find(TrainingData.class).where().eq("SessionID", SessionID).findList();
        sessionModell.c_frames = trainingDataList.size();
        sessionModell.c_duration = (float)((float)trainingDataList.get(sessionModell.c_frames-1).timestamp-(float)trainingDataList.get(0).timestamp)/(float)1000000;
        sessionModell.fps = (float)((float) sessionModell.c_frames/sessionModell.c_duration);

        return sessionModell;
    }

    public static TrainingData getTrainingData(Long id) {
        TrainingData trainingData = Ebean.find(TrainingData.class, id);
        return trainingData;
    }

    public static List<TrainingData> getTrainingDataForUser(Long id) {
        List<TrainingData> listOfTrainingData  = Ebean.find(TrainingData.class).where().eq("user_id",id).order().asc("timestamp").findList();
        return listOfTrainingData;
    }



}