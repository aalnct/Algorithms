package restart.gemini.kafka;

public class Producer {
    private final SimpleBroker broker;

    public Producer (SimpleBroker broker) {
        this.broker = broker;
    }

    public void produce (String topicName, String message) {
        broker.sendMessage(topicName,message);
    }
}
