package restart.gemini.kafka;

import java.util.List;

public class ModifiedConsumer {

    private final SimpleBrokerWithPartition brokerWithPartition;

    public ModifiedConsumer (SimpleBrokerWithPartition brokerWithPartition) {
        this.brokerWithPartition = brokerWithPartition;
    }

    public void consume (String topicName, int partitionIndex) {
        List<String> messages = brokerWithPartition.getMessage(topicName, partitionIndex);
        for (String msg : messages) {
            System.out.println( " Consumed messages from partition "  + partitionIndex
             + " messages " + msg);
        }
    }
}
