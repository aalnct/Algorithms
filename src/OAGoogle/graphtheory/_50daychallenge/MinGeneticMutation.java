package OAGoogle.graphtheory._50daychallenge;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinGeneticMutation {

    public static void main(String[] args) {
        String startGene = "AACCGGTT";
        String endGene = "AACCGGTA";
        String [] bank = {"AACCGGTA"};

        System.out.println(minGeneticMutation(startGene,endGene,bank));
    }

    static int minGeneticMutation (String startGene, String endGene, String [] bank) {
        Set<String> bankSet = new HashSet<>();
        for (String gene : bank) {
            bankSet.add(gene);
        }

        if (!bankSet.contains(endGene)) {
            return -1;
        }

        char [] validChars = {'A','C','G','T'};
        Queue<String> queue = new LinkedList<>();
        queue.add(startGene);

        int mutations = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i < size; i++) {
                String currentGene = queue.poll();
                if (currentGene.equals(endGene)) {
                    return mutations;
                }

                char [] geneArray = currentGene.toCharArray();
                for (int j=0; j < geneArray.length; j++) {
                    char originalChar = geneArray[j]; // preserving the original char for later revert

                    for (char c : validChars) { // replacing the character at index j and checking in bankSet if it is already present ...
                        geneArray[j] = c;
                        String newGene = new String(geneArray);

                        if (bankSet.contains(newGene)) {
                            queue.offer(newGene);
                            bankSet.remove(newGene);
                        }
                    }
                    geneArray[j] = originalChar;
                }
            }
            mutations++;
        }
        return -1;
    }
}
