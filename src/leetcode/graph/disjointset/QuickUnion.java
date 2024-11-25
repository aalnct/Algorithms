package leetcode.graph.disjointset;

public class QuickUnion {

    private static int[] root;

    public static void main(String[] args) {
        QuickUnion uf = new QuickUnion(10);

        uf.union(1, 2);
        uf.union(2, 5);
        uf.union(5, 6);
        uf.union(6, 7);
        uf.union(3, 8);
        uf.union(8, 9);
        System.out.println(uf.connected(1, 5)); // true
        System.out.println(uf.connected(5, 7)); // true
        System.out.println(uf.connected(4, 9)); // false
        // 1-2-5-6-7 3-8-9-4
        uf.union(9, 4);
        System.out.println(uf.connected(4, 9)); // true
    }

    public QuickUnion(int size) {
        this.root = new int[size];
        for (int i=0; i< size; i++) {
            root[i] = i;
        }
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
        if (rootX != rootY) {
            root[rootY] = rootX;
        }
    }

    private static boolean connected(int x, int y) {
        return find(x) ==find(y);
    }
}
