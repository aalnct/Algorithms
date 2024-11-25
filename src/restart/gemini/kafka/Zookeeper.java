package restart.gemini.kafka;

public class Zookeeper {

    public static void main(String[] args) {
        SimpleBroker broker = new SimpleBroker();

        broker.createTopic("test_topic");

        Producer producer = new Producer(broker);
        producer.produce("test_topic", "Hello kafka like system");
        producer.produce("test_topic" , "Another message");

        Consumer consumer = new Consumer(broker);
        consumer.consume("test_topic");
    }
}
