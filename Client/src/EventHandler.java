/**
 * Created by Lars Badde on 17.07.2017.
 */


import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


public class EventHandler {

    public static class Message {
        public String type;
        public String origin;
        public Long timestamp;
        public LMListener.Frame40 data;

    }

    public static final ObjectMapper objectMapper = new ObjectMapper();

    public static LMListener.Frame40 lastFrame;

    public static void ReceiveTrackingVector(LMListener.Frame40 frame) throws JsonProcessingException {


        LMListener.Frame40 DiffFrame = null;
        if (lastFrame != null) {
            DiffFrame = VectorBuilding.buildDiff(frame, lastFrame);
        } else {
            lastFrame = frame;
        }

        if (frame != null) {
            lastFrame = frame;

            Message message = new Message();
            message.origin = LMListener.name;
            message.type = "trackingData";
            message.timestamp = System.currentTimeMillis();
            message.data = DiffFrame;

            JsonNode json = objectMapper.valueToTree(message);
            String jsonInString = objectMapper.writeValueAsString(json);

            Message msg = objectMapper.treeToValue(json, Message.class);
            WebSocket.sendToWS(jsonInString);

        } else {

        }

    }
}
