package restart.gemini.kafka;

public class EnhancedKafkaDemo {
    public static void main(String[] args) {

        SimpleBrokerWithPartition brokerWithPartition = new SimpleBrokerWithPartition();

        String topicName = "test_topic";

        // create a topic with 3 partitions
        brokerWithPartition.createTopic(topicName, 3);

        ModifiedProducer producer = new ModifiedProducer(brokerWithPartition);
        producer.produce(topicName, "Message1");
        producer.produce(topicName, "Message 2");
        producer.produceToPartition(topicName,1, "Message specifically for partition 1");

        ModifiedConsumer consumer = new ModifiedConsumer(brokerWithPartition);
        for (int i=0; i < brokerWithPartition.getNumberOfPartitions(topicName); i++) {
            consumer.consume(topicName,i);
        }
    }
}
