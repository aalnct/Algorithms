package restart.gemini.kafka;

import java.util.*;

public class SimpleBrokerWithPartition {

    private final Map<String, List<Partition>> topics;
    private final Random random;
    private static class Partition {
        private final List<String> messages;

        public Partition () {
            this.messages = new ArrayList<>();
        }

        public void addMessages(String message) {
            messages.add(message);
        }

        public List<String> getMessages() {
            return messages;
        }
    }

    public SimpleBrokerWithPartition () {
        this.topics = new HashMap<>();
        this.random = new Random();
    }

    public void createTopic (String topicName, int numberOfPartitions) {
        if (!topics.containsKey(topicName)) {
            System.out.println(" *** Topic does not exists, so will create a new topic with name " + topicName);
            List<Partition> partitionList = new ArrayList<>();
            for (int i=0; i < numberOfPartitions; i++) {
                partitionList.add(new Partition());
            }
            topics.put(topicName,partitionList);
            System.out.println(" **** Topic created **** " + topicName);
        } else {
            System.err.println(" **** Topic already exists " + topicName);
        }
    }

    // consumer will use this message to send message
    public void sendMessage (String topicName, String message) {
        // consumer will subscribe to one topic and feed message to that topic
        // will randomly distribute messages to partition
        if (!topics.containsKey(topicName)) {
            throw new IllegalArgumentException("**** No topic with name exists **** " + topicName);
        } else {
            // get all the message from the topic
            List<Partition> partitionList = topics.get(topicName);
            // so will create partition index based on size of partition list
            int partitionIndex = random.nextInt(partitionList.size());
            // adding message to specified index
            partitionList.get(partitionIndex).addMessages(message);
            System.out.println(" **** Message added to topic **** " + topicName + " at partition index " +partitionIndex
            + " message " + message);
        }
    }

    public List<String> getMessage(String topicName, int partitionIndex) {
        if (!topics.containsKey(topicName)) {
            throw new IllegalArgumentException(" **** No such topic exists " + topicName);
        }

        List<Partition> partitionList = topics.get(topicName);
        if (partitionIndex < 0 || partitionIndex >= partitionList.size()) {
            throw new IllegalArgumentException(" Invalid index provided " + partitionIndex);
        }
        return partitionList.get(partitionIndex).getMessages();
    }

    public int getNumberOfPartitions(String topicName) {
        if (!topics.containsKey(topicName)) {
            throw new IllegalArgumentException(" **** No such topic exists " + topicName);
        }

        return topics.get(topicName).size();
    }
}
