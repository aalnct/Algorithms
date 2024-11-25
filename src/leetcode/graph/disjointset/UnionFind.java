package leetcode.graph.disjointset;

/***
 *  Union Find is also called as Disjoint set
 */
public class UnionFind {

    private static int[] root;
    public UnionFind(int size) {
        this.root = new int[size];
        for (int i=0; i < size; i++) {
            root[i] = i;
        }
    }
    public static void main(String[] args) {
        UnionFind uf = new UnionFind(10);
        // 1-2-5-6-7
        // 3-8-9
        //4
        uf.union(1, 2);
        uf.union(2, 5);
        uf.union(5, 6);
        uf.union(6, 7);
        uf.union(3, 8);
        uf.union(8, 9);

        System.out.println(isConnected(1,5));
        System.out.println(isConnected(5, 7)); // true
        System.out.println(isConnected(4, 9));
    }
    private static int find(int x) {
        return root[x];
    }
    private static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            for (int i=0; i < root.length; i++) {
                if (root[i] == rootY) {
                    root[i] = rootX;
                }
            }
        }
    }
    private static boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }
}
