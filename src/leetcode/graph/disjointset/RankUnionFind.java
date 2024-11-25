package leetcode.graph.disjointset;

public class RankUnionFind {

    static int [] root; // actual array of elements
    static int [] rank; // need to maintain height at each level

    public RankUnionFind (int size) {
        root = new int[size];
        rank = new int[size];

        for(int i=0; i < size; i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }

    public static void main(String[] args) {
        RankUnionFind ruf = new RankUnionFind(10);

        union(1,2);
        union(2,5);
        union(5,6);

        System.out.println(isConnected(1,2));
        System.out.println(isConnected(2,5));
        System.out.println(isConnected(5,6));
    }

    private static int find(int x) {
        while (x != root[x]) {
            x = root[x];
        }
        return x;
    }

    private static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if(rootX != rootY) {
            // check the rank so that we can decide on root node ...
            if (root[rootX] > root[rootY]) {
                root[rootY] = rootX;
            } else if (root[rootX] < root[rootY]) {
                root[rootX] = rootY;
            } else { // means same, so take anything , does not matter ...
                root[rootY] =rootX;
                rank[rootX] +=1;
            }
        }
    }

    private static boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }
}
