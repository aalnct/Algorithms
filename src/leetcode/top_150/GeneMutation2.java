package leetcode.top_150;

import java.util.*;

public class GeneMutation2 {
    public static void main(String[] args) {
        String startGene = "AACCGGTT";
        String endGene = "AAACGGTA";
        String [] bank =  {"AACCGGTA","AACCGCTA","AAACGGTA"} ;

        System.out.println(geneticMutation(startGene,endGene, bank));
    }

    private static int geneticMutation(String startGene, String endGene, String [] bank) {
        Set<String> bankSet = new HashSet<>();
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.offer(startGene);
        int depth = 0;

        for (String gene : bank) {
            bankSet.add(gene);
        }

        if (!bankSet.contains(endGene)) {
            return -1;
        }

        Set<Character> valid = new HashSet<>(Arrays.asList('A','C','G','T'));

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i=0; i < size; i++) {
                String currentGene = queue.poll();

                if (currentGene.equals(endGene)) {
                    return depth;
                }

                char [] currentChars = currentGene.toCharArray();
                for (int j=0; j < currentChars.length; j++) {
                    // preserving the original characters of genes
                    char originalGene = currentChars[j];

                    for (char mutation : valid) {
                        if (mutation != originalGene) {
                            currentChars[j] = mutation;
                            String mutatedGene = new String(currentChars);

                            if (bankSet.contains(mutatedGene) && !visited.contains(mutatedGene)) {
                                queue.offer(mutatedGene);
                                visited.add(mutatedGene);
                                bankSet.remove(mutatedGene);
                            }
                        }
                    }
                    currentChars[j] = originalGene;
                }
            }
            depth++;
        }
        return -1;
    }
}