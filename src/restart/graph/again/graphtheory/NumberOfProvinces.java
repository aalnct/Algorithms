package restart.graph.again.graphtheory;

public class NumberOfProvinces {

    public static void main(String[] args) {
        int [][] isConnected = {
                {1,1,0},
                {1,1,0},
                {0,0,1}
        };

        System.out.println(numberOfProvinces(isConnected));
    }

    static int numberOfProvinces (int [][] isConnected) {
        int provinces = 0;

        int n = isConnected.length;
        boolean [] visited = new boolean[n];

        for (int i=0; i < n; i++) {
            if (!visited[i]) {
                provinces++;
                dfs (isConnected,visited,i);
            }
        }
        return provinces;
    }

    static void dfs (int [][] isConnected, boolean [] visited, int city) {
        visited[city] = true;

        int n = isConnected.length;

        for (int neighbour = 0; neighbour < n; neighbour++) {
            if (isConnected[city][neighbour] == 1 && !visited[neighbour]) {
                dfs(isConnected,visited,neighbour);
            }
        }
    }
}
