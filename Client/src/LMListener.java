/**
 * Created by Lars Badde on 16.07.2017.
 */

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.leapmotion.leap.*;


class LMListener extends Listener {

    public Long lastProcessedFrame = (long)0;

    public static String name = null;

    public static class Finger40 {
        public Integer id;
        public String type;
        public List<Float> direction = new ArrayList<Float>();   // Always compared to Bone: TYPE_DISTAL....
        public List<Float> center = new ArrayList<Float>();      // Always compared to Bone: TYPE_DISTAL....
    }

    public static class Hand40 {
        public Integer id;
        public Boolean isLeft;
        public Boolean isRight;
        public List<Float> HandPosition= new ArrayList<Float>();
        public List<Float> PalmNormal= new ArrayList<Float>();
        public List<Float> Direction = new ArrayList<Float>();
        public Float grabAngle;
        public Float pinchDistance;
        public List<Finger40> Fingers = new ArrayList<Finger40>();
    }

    public static class Frame40 {
        public Long id;
        public Long timestamp;
        public String DeviceID;
        public Integer NrOfHands;
        public Integer NrOfFingers;
        public List<Hand40> Hands = new ArrayList<Hand40>() ;
    }

    public class LeapMotionOnFrame {

        public Frame40 retFrame;

        public Frame frame;
        public Controller controller;
        public Frame40 processFrame () {
            Frame40 frame40 = new Frame40();


            Long lim = lastProcessedFrame+GlobalConstants.FrameRate;
            if (lastProcessedFrame == null || lim <= frame.timestamp()) {
                lastProcessedFrame=frame.timestamp();
                frame40.id = frame.id();
                frame40.timestamp = frame.timestamp();
                frame40.DeviceID = controller.devices().get(0).serialNumber();
                name = frame40.DeviceID;
                frame40.NrOfHands = frame.hands().count();
                frame40.NrOfFingers = frame.fingers().count();


                //Get hands
                for (Hand hand : frame.hands()) {
                    Hand40 hand40 = new Hand40();
                    hand40.id = hand.id();
                    hand40.isLeft = hand.isLeft();
                    hand40.isRight = hand.isRight();



                    try {
                        //Main.log(String.valueOf(hand.direction().pitch())+ " | "+String.valueOf(hand.direction().yaw())+" | "+String.valueOf(hand.direction().roll())+" | "+ String.valueOf(hand.palmPosition().getX())+" | "+ String.valueOf(hand.palmPosition().getY())+" | "+ String.valueOf(hand.palmPosition().getZ()));
                        hand40.Direction.add(hand.direction().pitch());
                        hand40.Direction.add(hand.direction().yaw());
                        hand40.Direction.add(hand.direction().roll());
                        hand40.HandPosition.add(hand.palmPosition().getX());
                        hand40.HandPosition.add(hand.palmPosition().getY());
                        hand40.HandPosition.add(hand.palmPosition().getZ());
                        hand40.PalmNormal.add(hand.palmNormal().pitch());
                        hand40.PalmNormal.add(hand.palmNormal().yaw());
                        hand40.PalmNormal.add(hand.palmNormal().roll());
                    } catch (Exception e) {
                        Main.log(e.toString());
                    }

                    hand40.grabAngle = hand.grabAngle();
                    hand40.pinchDistance = hand.pinchDistance();

                    // Get fingers
                    for (Finger finger : hand.fingers()) {
                        Finger40 finger40 = new Finger40();
                        finger40.id = finger.id();
                        finger40.type = finger.type().toString();


                        Bone bone40 = finger.bone(Bone.Type.TYPE_DISTAL);

                        finger40.center.add(bone40.center().getX());
                        finger40.center.add(bone40.center().getY());
                        finger40.center.add(bone40.center().getZ());
                        finger40.direction.add(bone40.direction().pitch());
                        finger40.direction.add(bone40.direction().yaw());
                        finger40.direction.add(bone40.direction().roll());

                        hand40.Fingers.add(finger40);
                    }

                        frame40.Hands.add(hand40);

                }

                return frame40;
            } else {
               // System.out.println("rejected frame cause of the frame rate   " +lim+ "   |  "+lastProcessedFrame);
                return null;
            }
        }

    }


    public void onInit(Controller controller) {
        System.out.println("Initialized");
    }

    public void onConnect(Controller controller) {
        System.out.println("Connected");
    }

    public void onDisconnect(Controller controller) {
        //Note: not dispatched when running in a debugger.
        System.out.println("Disconnected");
    }

    public void onExit(Controller controller) {
        System.out.println("Exited");
    }

    public void onFrame(Controller controller) {

        LeapMotionOnFrame cf = new LeapMotionOnFrame();
        cf.controller = controller;
        cf.frame = controller.frame();
        try {
            EventHandler.ReceiveTrackingVector(cf.processFrame());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }




        /*
        // Get the most recent frame and report some basic information
        Frame frame = controller.frame();
        Frame40 frame40 = new Frame40();


        frame40.id=frame.id();
        frame40.timestamp=frame.timestamp();
        frame40.DeviceID=controller.devices().get(0).serialNumber();
        frame40.NrOfHands=frame.hands().count();
        frame40.NrOfFingers=frame.fingers().count();

        Main.log("check 1");

        //Get hands
        for(Hand hand : frame.hands()) {
            Hand40 hand40 = new Hand40();
            hand40.id=hand.id();
            hand40.isLeft = hand.isLeft();
            hand40.isRight = hand.isRight();

            try {
                hand40.Direction.add(hand.direction().pitch());
                hand40.Direction.add(hand.direction().yaw());
                hand40.Direction.add(hand.direction().roll());
            }
            catch (Exception e) {
                Main.log(e.toString());
            }

            try {
                hand40.HandPosition.add(hand.palmPosition().getX());
                hand40.HandPosition.add(hand.palmPosition().getY());
                hand40.HandPosition.add(hand.palmPosition().getZ());
            } catch (Exception e) {
                Main.log(e.toString());
            }

            hand40.PalmNormal.add(hand.palmNormal().pitch());
            hand40.PalmNormal.add(hand.palmNormal().yaw());
            hand40.PalmNormal.add(hand.palmNormal().roll());

            hand40.grabAngle = hand.grabAngle();
            hand40.pinchDistance = hand.pinchDistance();

            Main.log("Check 2");

            // Get fingers
            for (Finger finger : hand.fingers()) {
                Finger40 finger40 = new Finger40();
                finger40.id = finger.id();
                finger40.type = finger.type().toString();

                //Get Bones
                Main.log("check 3");
                for(Bone.Type boneType : Bone.Type.values()) {
                    FingerBone40 fingerBone40 = new FingerBone40();
                    fingerBone40.type = boneType.toString();
                    fingerBone40.center[0] = finger.bone(boneType).center().getX();
                    fingerBone40.center[1] = finger.bone(boneType).center().getY();
                    fingerBone40.center[2] = finger.bone(boneType).center().getZ();
                    fingerBone40.direction[0] = finger.bone(boneType).direction().pitch();
                    fingerBone40.direction[1] = finger.bone(boneType).direction().yaw();
                    fingerBone40.direction[2] = finger.bone(boneType).direction().roll();

                    Main.log("check 4");
                    Bone bone = finger.bone(boneType);


                    finger40.Bones.add(fingerBone40);
                }
                hand40.Fingers.add(finger40);
            }
            frame40.Hands.add(hand40);
        }

        Main.log("Received Frame....");
        Main.log(frame40.toString());
        */
    }

}
