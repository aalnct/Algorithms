package restart.gemini.kafka.kafka2;

import java.util.List;

public class BrokerWithPartitionAndOffset {

    private static final class Partition {
        private List<String> messages;

        public List<String> getMessages() {
            return messages;
        }

        public void addMessage(String message) {
            messages.add(message);
        }

        public String getMessage (int partitionIndex) {
            if (partitionIndex < 0 || partitionIndex >= messages.size()) {
                throw new IllegalArgumentException(" **** Partition index is invalid *****");
            }
            return messages.get(partitionIndex);
        }


    }
}
