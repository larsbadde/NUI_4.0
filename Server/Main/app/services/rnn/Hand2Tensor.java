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

/**
 * Created by Lars Badde
 */
public class Hand2Tensor {

    public static Tensor Hand2Tensor(Hand hand) {

        Tensor output = Tensor.create(new float[][][] {{{hand.HandPosition_X, hand.HandPosition_Y, hand.HandPosition_Z, hand.PalmNormal_pitch, hand.PalmNormal_yaw, hand.PalmNormal_roll, hand.Direction_pitch, hand.Direction_pitch, hand.Direction_roll, hand.grabAngle, hand.pinchDistance, hand.THUMB_Direction_pitch, hand.THUMB_Direction_yaw, hand.THUMB_Direction_roll, hand.THUMB_Center_X, hand.THUMB_Center_Y, hand.THUMB_Center_Z, hand.INDEX_Direction_pitch, hand.INDEX_Direction_yaw, hand.INDEX_Direction_roll, hand.INDEX_Center_X, hand.INDEX_Center_Y, hand.INDEX_Center_Z,hand.MIDDLE_Direction_pitch, hand.MIDDLE_Direction_pitch, hand.MIDDLE_Direction_roll, hand.MIDDLE_Center_X, hand.MIDDLE_Center_Y, hand.MIDDLE_Center_Z, hand.INDEX_Direction_pitch, hand.INDEX_Direction_yaw, hand.INDEX_Direction_roll, hand.INDEX_Center_X, hand.INDEX_Center_Y, hand.INDEX_Center_Z, hand.PINKY_Direction_pitch, hand.PINKY_Direction_yaw, hand.PINKY_Direction_roll, hand.PINKY_Center_X, hand.PINKY_Center_Y, hand.PINKY_Center_Z,}}});
        return output;
    }

}