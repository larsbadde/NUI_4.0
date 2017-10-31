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
import models.TrainingData;
import org.tensorflow.DataType;
import org.tensorflow.Graph;
import org.tensorflow.Output;
import org.tensorflow.Session;
import org.tensorflow.Tensor;
import org.tensorflow.TensorFlow;
import org.tensorflow.SavedModelBundle;
import org.tensorflow.Output;

/**
 * Created by Lars Badde
 */
public class TD2Hand {

    public static Hand TD2Hand (TrainingData trainingData) {

        Hand hand = new Hand();
        hand.HandID = trainingData.HandID;
        hand.timestamp = trainingData.timestamp;
        hand.DeviceID = trainingData.device.name;
        hand.isRight = trainingData.isRight;
        hand.HandPosition_X = trainingData.HandPosition_X;
        hand.HandPosition_Y = trainingData.HandPosition_Y;
        hand.HandPosition_Z = trainingData.HandPosition_Z;
        hand.PalmNormal_pitch = trainingData.PalmNormal_pitch;
        hand.PalmNormal_yaw = trainingData.PalmNormal_yaw;
        hand.PalmNormal_roll = trainingData.PalmNormal_roll;
        hand.Direction_pitch = trainingData.Direction_pitch;
        hand.Direction_yaw = trainingData.Direction_yaw;
        hand.Direction_roll = trainingData.Direction_roll;
        hand.grabAngle = trainingData.grabAngle;
        hand.pinchDistance = trainingData.pinchDistance;
        hand.THUMB_Direction_pitch = trainingData.THUMB_Direction_pitch;
        hand.THUMB_Direction_yaw = trainingData.THUMB_Direction_yaw;
        hand.THUMB_Direction_roll = trainingData.THUMB_Direction_roll;
        hand.THUMB_Center_X = trainingData.THUMB_Center_X;
        hand.THUMB_Center_Y = trainingData.THUMB_Center_Y;
        hand.THUMB_Center_Z = trainingData.THUMB_Center_Z;
        hand.INDEX_Direction_pitch = trainingData.INDEX_Direction_pitch;
        hand.INDEX_Direction_yaw = trainingData.INDEX_Direction_yaw;
        hand.INDEX_Direction_roll = trainingData.INDEX_Direction_roll;
        hand.INDEX_Center_X = trainingData.INDEX_Center_X;
        hand.INDEX_Center_Y = trainingData.INDEX_Center_Y;
        hand.INDEX_Center_Z = trainingData.INDEX_Center_Z;
        hand.MIDDLE_Direction_pitch = trainingData.MIDDLE_Direction_pitch;
        hand.MIDDLE_Direction_yaw = trainingData.MIDDLE_Direction_yaw;
        hand.MIDDLE_Direction_roll = trainingData.MIDDLE_Direction_roll;
        hand.MIDDLE_Center_X = trainingData.MIDDLE_Center_X;
        hand.MIDDLE_Center_Y = trainingData.MIDDLE_Center_Y;
        hand.MIDDLE_Center_Z = trainingData.MIDDLE_Center_Z;
        hand.RING_Direction_pitch = trainingData.RING_Direction_pitch;
        hand.RING_Direction_yaw = trainingData.RING_Direction_yaw;
        hand.RING_Direction_roll = trainingData.RING_Direction_roll;
        hand.RING_Center_X = trainingData.RING_Center_X;
        hand.RING_Center_Y = trainingData.RING_Center_Y;
        hand.RING_Center_Z = trainingData.RING_Center_Z;
        hand.PINKY_Direction_pitch = trainingData.PINKY_Direction_pitch;
        hand.PINKY_Direction_yaw = trainingData.PINKY_Direction_yaw;
        hand.PINKY_Direction_roll = trainingData.PINKY_Direction_roll;
        hand.PINKY_Center_X = trainingData.PINKY_Center_X;
        hand.PINKY_Center_Y = trainingData.PINKY_Center_Y;
        hand.PINKY_Center_Z = trainingData.PINKY_Center_Z;

        return hand;
    }

}