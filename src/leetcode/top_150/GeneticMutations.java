package leetcode.top_150;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class GeneticMutations {

    public static void main(String[] args) {
        String startGene = "AACCGGTT";
        String endGene = "AAACGGTA";
        String [] bank =  {"AACCGGTA","AACCGCTA","AAACGGTA"} ;

        System.out.println(geneticMutation(startGene,endGene, bank));
    }

    /**
     *
     * @param startGene
     * @param endGene
     * @param bank
     * @return
     */
    private static int geneticMutation(String startGene, String endGene, String [] bank) {
        Set<String> bankSet = new HashSet<>();
        for (String gene : bank) {
            bankSet.add(gene);
        }

        if (!bankSet.contains(endGene)) {
            return -1;
        }

        char [] valid = {'A','C','G','T'};
        Queue<String> queue = new LinkedList<>();
        queue.offer(startGene);

        int mutation = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i=0; i < size; i++) {
                String currentGene = queue.poll();
                if (currentGene.equals(endGene)) {
                    return mutation;
                }

                char [] geneArray = currentGene.toCharArray();
                for (int j=0; j < geneArray.length; j++) {
                    char originalGene = geneArray[j];

                    for (char c : valid) {
                        geneArray[j] = c;

                        String newGene = new String(geneArray);

                        if (bankSet.contains(newGene)) {
                            queue.offer(newGene);
                            bankSet.remove(newGene);
                        }
                    }
                    geneArray[j] = originalGene;
                }
            }
            mutation++;
        }
        return -1;
    }

}
