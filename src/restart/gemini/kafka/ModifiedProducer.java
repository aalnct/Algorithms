package restart.gemini.kafka;

import java.util.List;

public class ModifiedProducer {

    private final SimpleBrokerWithPartition brokerWithPartition;

    public ModifiedProducer (SimpleBrokerWithPartition partition) {
        this.brokerWithPartition = partition;
    }

    public void produce (String topicName, String messages) {
        this.brokerWithPartition.sendMessage(topicName,messages);
    }

    public void produceToPartition (String topicName, int partitionIndex, String message) {
        if (partitionIndex < 0 || partitionIndex >= brokerWithPartition.getNumberOfPartitions(topicName)) {
            throw new IllegalArgumentException(" **** Invalid Partition Index provided " + partitionIndex);
        }
        List<String> messages =
                brokerWithPartition.getMessage(topicName,partitionIndex);
        messages.add(message);
        System.out.println(" **** Message added directly to Partition **** " + partitionIndex + " of topic "
        + topicName + " message " + message);
    }
}
