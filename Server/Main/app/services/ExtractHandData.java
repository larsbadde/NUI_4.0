package services;

import controllers.TrainingController;
import models.Hand;
import controllers.ExternalWebSocketActor;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.TrainingData;
import services.rnn.Hand2Tensor;
import services.rnn.TensorFlowMessenger;
import services.rnn.TensorFlowRestoreModel;

/**
 * Created by Lars Badde
 */
public class ExtractHandData {

    /**
     * data-listener
     *
     */

    private static DataListener.TrainingDataListener train_listener;

    public static void setTrainingDataListener (DataListener.TrainingDataListener lstnr) {
        train_listener = lstnr;
    }
    public static void stopTrainingDataListener () {
        train_listener = null;
    }


    /**
     * TODO:
     * -
     */

    public static void Frame2Hand(ExternalWebSocketActor.Frame40 frame40) {

        for (ExternalWebSocketActor.Hand40 hand40 : frame40.Hands) {
            if (hand40.Fingers.size() == 5) {
                Hand hand = new Hand();
                hand.HandID = frame40.id;
                hand.timestamp = frame40.timestamp;
                hand.DeviceID = frame40.DeviceID;
                hand.isRight = hand40.isRight;
                hand.HandPosition_X = hand40.HandPosition.get(0);
                hand.HandPosition_Y = hand40.HandPosition.get(1);
                hand.HandPosition_Z = hand40.HandPosition.get(2);
                hand.PalmNormal_pitch = hand40.PalmNormal.get(0);
                hand.PalmNormal_yaw = hand40.PalmNormal.get(1);
                hand.PalmNormal_roll = hand40.PalmNormal.get(2);
                hand.Direction_pitch = hand40.Direction.get(0);
                hand.Direction_yaw = hand40.Direction.get(1);
                hand.Direction_roll = hand40.Direction.get(2);
                hand.grabAngle = hand40.grabAngle;
                hand.pinchDistance = hand40.pinchDistance;
                for (ExternalWebSocketActor.Finger40 finger40 : hand40.Fingers) {
                    switch (finger40.type) {
                        case "TYPE_THUMB":
                            hand.THUMB_Center_X = finger40.center.get(0);
                            hand.THUMB_Center_Y = finger40.center.get(1);
                            hand.THUMB_Center_Z = finger40.center.get(2);
                            hand.THUMB_Direction_pitch = finger40.direction.get(0);
                            hand.THUMB_Direction_yaw = finger40.direction.get(1);
                            hand.THUMB_Direction_roll = finger40.direction.get(2);
                            break;
                        case "TYPE_INDEX":
                            hand.INDEX_Center_X = finger40.center.get(0);
                            hand.INDEX_Center_Y = finger40.center.get(1);
                            hand.INDEX_Center_Z = finger40.center.get(2);
                            hand.INDEX_Direction_pitch = finger40.direction.get(0);
                            hand.INDEX_Direction_yaw = finger40.direction.get(1);
                            hand.INDEX_Direction_roll = finger40.direction.get(2);
                            break;
                        case "TYPE_MIDDLE":
                            hand.MIDDLE_Center_X = finger40.center.get(0);
                            hand.MIDDLE_Center_Y = finger40.center.get(1);
                            hand.MIDDLE_Center_Z = finger40.center.get(2);
                            hand.MIDDLE_Direction_pitch = finger40.direction.get(0);
                            hand.MIDDLE_Direction_yaw = finger40.direction.get(1);
                            hand.MIDDLE_Direction_roll = finger40.direction.get(2);
                            break;
                        case "TYPE_RING":
                            hand.RING_Center_X = finger40.center.get(0);
                            hand.RING_Center_Y = finger40.center.get(1);
                            hand.RING_Center_Z = finger40.center.get(2);
                            hand.RING_Direction_pitch = finger40.direction.get(0);
                            hand.RING_Direction_yaw = finger40.direction.get(1);
                            hand.RING_Direction_roll = finger40.direction.get(2);
                            break;
                        case "TYPE_PINKY":
                            hand.PINKY_Center_X = finger40.center.get(0);
                            hand.PINKY_Center_Y = finger40.center.get(1);
                            hand.PINKY_Center_Z = finger40.center.get(2);
                            hand.PINKY_Direction_pitch = finger40.direction.get(0);
                            hand.PINKY_Direction_yaw = finger40.direction.get(1);
                            hand.PINKY_Direction_roll = finger40.direction.get(2);
                            break;
                        default:
                            break;
                    }
                }


                if (train_listener != null) {
                    if (TrainingController.actualDevice.name.equals(hand.DeviceID)) {
                        train_listener.onReceiveFrame (hand);
                    }
                } else {
                    try {
                        TensorFlowMessenger.sendHandFrame(hand);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }

            }
        }



    }

}