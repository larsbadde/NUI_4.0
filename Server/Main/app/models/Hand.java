package models;

import java.util.*;
import javax.persistence.*;

import controllers.ExternalWebSocketActor;
import io.ebean.*;
import play.data.format.*;
import play.data.validation.*;

/**
 * Created by Lars Badde
 */
@Entity
public class Hand extends Model {

    @Id
    public Long HandID;
    public Long timestamp;
    public String DeviceID;
    public Boolean isRight;
    public Float HandPosition_X;
    public Float HandPosition_Y;
    public Float HandPosition_Z;
    public Float PalmNormal_pitch;
    public Float PalmNormal_yaw;
    public Float PalmNormal_roll;
    public Float Direction_pitch;
    public Float Direction_yaw;
    public Float Direction_roll;
    public Float grabAngle;
    public Float pinchDistance;
    public Float THUMB_Direction_pitch;
    public Float THUMB_Direction_yaw;
    public Float THUMB_Direction_roll;
    public Float THUMB_Center_X;
    public Float THUMB_Center_Y;
    public Float THUMB_Center_Z;
    public Float INDEX_Direction_pitch;
    public Float INDEX_Direction_yaw;
    public Float INDEX_Direction_roll;
    public Float INDEX_Center_X;
    public Float INDEX_Center_Y;
    public Float INDEX_Center_Z;
    public Float MIDDLE_Direction_pitch;
    public Float MIDDLE_Direction_yaw;
    public Float MIDDLE_Direction_roll;
    public Float MIDDLE_Center_X;
    public Float MIDDLE_Center_Y;
    public Float MIDDLE_Center_Z;
    public Float RING_Direction_pitch;
    public Float RING_Direction_yaw;
    public Float RING_Direction_roll;
    public Float RING_Center_X;
    public Float RING_Center_Y;
    public Float RING_Center_Z;
    public Float PINKY_Direction_pitch;
    public Float PINKY_Direction_yaw;
    public Float PINKY_Direction_roll;
    public Float PINKY_Center_X;
    public Float PINKY_Center_Y;
    public Float PINKY_Center_Z;

    public Hand() {}

    public Hand (Long id, Long timestamp, String DeviceID, Boolean isRight, Float HandPosition_X, Float HandPosition_Y, Float HandPosition_Z,
                 Float PalmNormal_pitch, Float PalmNormal_yaw, Float PalmNormal_roll, Float Direction_pitch, Float Direction_yaw, Float Direction_roll, Float grabAngle, Float pinchDistance,
                 Float THUMB_Direction_pitch, Float THUMB_Direction_yaw, Float THUMB_Direction_roll,
                 Float THUMB_Center_X, Float THUMB_Center_Y, Float THUMB_Center_Z, Float INDEX_Direction_pitch,
                 Float INDEX_Direction_yaw, Float INDEX_Direction_roll, Float INDEX_Center_X, Float INDEX_Center_Y,
                 Float INDEX_Center_Z, Float MIDDLE_Direction_pitch, Float MIDDLE_Direction_yaw,
                 Float MIDDLE_Direction_roll, Float MIDDLE_Center_X, Float MIDDLE_Center_Y, Float MIDDLE_Center_Z,
                 Float RING_Direction_pitch, Float RING_Direction_yaw, Float RING_Direction_roll,
                 Float RING_Center_X, Float RING_Center_Y, Float RING_Center_Z, Float PINKY_Direction_pitch,
                 Float PINKY_Direction_yaw, Float PINKY_Direction_roll, Float PINKY_Center_X, Float PINKY_Center_Y,
                 Float PINKY_Center_Z) {

        this.HandID =id;
        this.timestamp = timestamp;
        this.DeviceID = DeviceID;
        this.isRight = isRight;
        this.HandPosition_X = HandPosition_X;
        this.HandPosition_Y = HandPosition_Y;
        this.HandPosition_Z = HandPosition_Z;
        this.PalmNormal_pitch = PalmNormal_pitch;
        this.PalmNormal_yaw = PalmNormal_yaw;
        this.PalmNormal_roll = PalmNormal_roll;
        this.Direction_pitch = Direction_pitch;
        this.Direction_yaw = Direction_yaw;
        this.Direction_roll = Direction_roll;
        this.grabAngle = grabAngle;
        this.pinchDistance = pinchDistance;
        this.THUMB_Direction_pitch = THUMB_Direction_pitch;
        this.THUMB_Direction_yaw = THUMB_Direction_yaw;
        this.THUMB_Direction_roll = THUMB_Direction_roll;
        this.THUMB_Center_X = THUMB_Center_X;
        this.THUMB_Center_Y = THUMB_Center_Y;
        this.THUMB_Center_Z = THUMB_Center_Z;
        this.INDEX_Direction_pitch = INDEX_Direction_pitch;
        this.INDEX_Direction_yaw = INDEX_Direction_yaw;
        this.INDEX_Direction_roll = INDEX_Direction_roll;
        this.INDEX_Center_X = INDEX_Center_X;
        this.INDEX_Center_Y = INDEX_Center_Y;
        this.INDEX_Center_Z = INDEX_Center_Z;
        this.MIDDLE_Direction_pitch = MIDDLE_Direction_pitch;
        this.MIDDLE_Direction_yaw = MIDDLE_Direction_yaw;
        this.MIDDLE_Direction_roll = MIDDLE_Direction_roll;
        this.MIDDLE_Center_X = MIDDLE_Center_X;
        this.MIDDLE_Center_Y = MIDDLE_Center_Y;
        this.MIDDLE_Center_Z = MIDDLE_Center_Z;
        this.RING_Direction_pitch = RING_Direction_pitch;
        this.RING_Direction_yaw = RING_Direction_yaw;
        this.RING_Direction_roll = RING_Direction_roll;
        this.RING_Center_X = RING_Center_X;
        this.RING_Center_Y = RING_Center_Y;
        this.RING_Center_Z = RING_Center_Z;
        this.PINKY_Direction_pitch = PINKY_Direction_pitch;
        this.PINKY_Direction_yaw = PINKY_Direction_yaw;
        this.PINKY_Direction_roll = PINKY_Direction_roll;
        this.PINKY_Center_X = PINKY_Center_X;
        this.PINKY_Center_Y = PINKY_Center_Y;
        this.PINKY_Center_Z = PINKY_Center_Z;


    }

    public long getHandID() {
        return HandID;
    }
}