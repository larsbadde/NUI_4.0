/**
 * Created by Media Markt on 08.08.2017.
 */
public class VectorBuilding {


    public static LMListener.Frame40 buildDiff(LMListener.Frame40 actFrame, LMListener.Frame40 lastframe40) {

        LMListener.Frame40 retFrame = new LMListener.Frame40();

        retFrame.id = actFrame.id;
        retFrame.timestamp = actFrame.timestamp - lastframe40.timestamp;
        retFrame.DeviceID = actFrame.DeviceID;
        retFrame.NrOfHands = actFrame.NrOfHands;
        retFrame.NrOfFingers = actFrame.NrOfFingers;


        for (LMListener.Hand40 hand40 : actFrame.Hands) {
            for (LMListener.Hand40 lasthand40 : lastframe40.Hands) {
                if (lasthand40.id.equals(hand40.id)) {
                    LMListener.Hand40 rethand40 = new LMListener.Hand40();
                    rethand40.id = hand40.id;
                    rethand40.isLeft = hand40.isLeft;
                    rethand40.isRight = hand40.isRight;

                    try {
                        rethand40.Direction.add(hand40.Direction.get(0) - lasthand40.Direction.get(0));
                        rethand40.Direction.add(hand40.Direction.get(1) - lasthand40.Direction.get(1));
                        rethand40.Direction.add(hand40.Direction.get(2) - lasthand40.Direction.get(2));
                        rethand40.HandPosition.add(hand40.HandPosition.get(0) - lasthand40.HandPosition.get(0));
                        rethand40.HandPosition.add(hand40.HandPosition.get(1) - lasthand40.HandPosition.get(1));
                        rethand40.HandPosition.add(hand40.HandPosition.get(2) - lasthand40.HandPosition.get(2));
                        rethand40.PalmNormal.add(hand40.PalmNormal.get(0) - lasthand40.PalmNormal.get(0));
                        rethand40.PalmNormal.add(hand40.PalmNormal.get(1) - lasthand40.PalmNormal.get(1));
                        rethand40.PalmNormal.add(hand40.PalmNormal.get(2) - lasthand40.PalmNormal.get(2));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    rethand40.grabAngle = hand40.grabAngle;
                    rethand40.pinchDistance = hand40.pinchDistance;


                    for (LMListener.Finger40 finger40 : hand40.Fingers) {
                        for (LMListener.Finger40 lastfinger40 : lasthand40.Fingers) {
                            if (lastfinger40.id.equals(finger40.id)) {
                                LMListener.Finger40 retfinger40 = new LMListener.Finger40();
                                retfinger40.id = finger40.id;
                                retfinger40.type = finger40.type;


                                retfinger40.center.add(finger40.center.get(0) - lastfinger40.center.get(0));
                                retfinger40.center.add(finger40.center.get(1) - lastfinger40.center.get(1));
                                retfinger40.center.add(finger40.center.get(2) - lastfinger40.center.get(2));
                                retfinger40.direction.add(finger40.direction.get(0) - lastfinger40.direction.get(0));
                                retfinger40.direction.add(finger40.direction.get(1) - lastfinger40.direction.get(1));
                                retfinger40.direction.add(finger40.direction.get(2) - lastfinger40.direction.get(2));


                                rethand40.Fingers.add(retfinger40);

                            }
                        }
                    }


                    retFrame.Hands.add(rethand40);
                }
            }
        }


        return retFrame;
    }
}
