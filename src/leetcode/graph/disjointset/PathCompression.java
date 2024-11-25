package leetcode.graph.disjointset;


public class PathCompression {

    private static int [] root;

    public PathCompression(int size) {
        root = new int[size];

        for (int i=0; i<size; i++) {
            root[i] = i;
        }
    }

    public static void main(String[] args) {
        PathCompression pc = new PathCompression(10);
        union(1,2);
        System.out.println(isConnected(1,2));
    }

    private static int find(int x) {
        if (x == root[x]) {
            return x;
        }
        return root[x] = find(root[x]);
    }

    private static void union(int x, int y) {
        // here we join after find x and y details
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            root[rootY] = rootX;
        }
    }

    private static boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }
}
