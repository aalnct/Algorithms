package restart.gemini.kafka;

import java.util.ArrayList;
import java.util.List;

public class Consumer {
    private final SimpleBroker broker;

    public Consumer (SimpleBroker broker) {
        this.broker = broker;
    }

    public void consume (String topicName) {
        List<String> messages = broker.getMessages(topicName);
        for (String msg : messages) {
            System.out.println(" Consumed Messages " + msg);
        }
    }
}
