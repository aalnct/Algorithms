package restart.gemini.kafka;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleBroker {
    private Map<String, List<String>> topics;

    public SimpleBroker () {
        topics = new HashMap<>();
    }

    public void createTopic(String topicName) {
       if (topics.containsKey(topicName)) {
           System.out.println(" Topic already exists" + topicName);
           return;
       }
       topics.put(topicName, new ArrayList<>());
        System.out.println(" Topic " + topicName + " created");
    }

    public void sendMessage (String topicName, String message) {
        if (!topics.containsKey(topicName)) {
            System.out.println(" No such " + topicName + " exists");
            return;
        }
        topics.get(topicName).add(message);
        System.out.println("Message added to topic " + topicName + " message " + message);
    }

    public List<String> getMessages (String topicName) {
        if (!topics.containsKey(topicName)) {
            System.out.println(" No such " + topicName + " exists");
            return new ArrayList<>();
        }
        return topics.get(topicName);
    }
}
