package leetcode.graph.disjointset;

public class GraphValidTree {

    private static int[] parent;

    public static void main(String[] args) {
        int [][] edges = {
                {0,1},
                {0,2},
                {0,3},
                {1,4}
        };
        int n = 5;

        System.out.println(isValidTree(n,edges));
    }

    public GraphValidTree(int n) {
        parent = new int[n];
        for(int i=0; i< n; i++) {
            parent[i] = i;
        }
    }

    public static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    public static boolean union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);

        if (parentX == parentY) {
            return false; // there is a cycle
        }

        parent[parentX] = parentY;
        return true;
    }

    public static boolean isValidTree(int n, int [][] edges) {
        if (edges.length != n-1) {
            return false;
        }

        GraphValidTree gvt = new GraphValidTree(n);

        for(int [] edge : edges) {
            int x = edge[0];
            int y = edge[1];

            if (!union(x,y)) {
                return false;
            }
        }

        // check if there is only one root, else not a valid tree
        int root = find(0);
        for (int i=1; i <n; i++) {
            if (find(i) != root) {
                return false;
            }
        }
        return true;
    }

}
