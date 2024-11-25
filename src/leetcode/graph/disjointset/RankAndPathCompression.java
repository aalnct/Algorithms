package leetcode.graph.disjointset;

public class RankAndPathCompression {

    static int [] root;
    static int [] rank;

    public RankAndPathCompression(int size) {
        root = new int[size];
        rank = new int[size];

        for (int i=0; i < size;i++) {
            root[i] = i;
            /**
             * initially all the vertices will have rank 1 since there are no other vertices connected to it ..
             */
            rank[i] = 1;
        }
    }

    public static void main(String[] args) {
        RankAndPathCompression rpc = new RankAndPathCompression(10);
        union(1,2);
        System.out.println(isConnected(1,2));
    }

    private static int find(int x) {
        if (root[x] == x) {
            return x;
        }
        return root[x] = find(root[x]);
    }

    private static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            if (root[rootX] > root[rootY]) {
                root[rootY] = rootX; // making the same root node
            } else if(root[rootX] < root[rootY]) {
                root[rootX] = rootY; // making the same root node
            } else {
                // means same, that's where we will increase the rank
                root[rootY] = rootX; // since it is same, does not matter what you assigned to what, it can evern be opposite
                rank[rootX] +=1;
            }
        }
    }

    private static boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }
}
