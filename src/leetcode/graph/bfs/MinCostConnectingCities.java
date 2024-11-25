package leetcode.graph.bfs;


import java.util.Arrays;

public class MinCostConnectingCities {

    public static void main(String[] args) {
        int n = 3;
        int [] [] connections = {
                {1,2,5},
                {1,3,6},
                {2,3,1}
        };

        System.out.println(minimumCost(n,connections));
    }

    static class Edges  implements Comparable<Edges>{

        int source;
        int destination;
        int cost;

        public Edges(int source, int destination, int cost) {
            this.source = source;
            this.destination = destination;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edges other) {
            return Integer.compare(this.cost,other.cost);
        }
    }

    static class DisjointSet {
        int [] parent;

        public DisjointSet(int n) {
            parent = new int[n+1];
            Arrays.fill(parent,-1);
        }

        int find(int vertex) {
            if(parent[vertex] < 0) {
                return vertex;
            }
            return parent[vertex] = find(parent[vertex]);
        }

        void union(int root1, int root2) {
            if(parent[root1] > parent[root2]) {
                parent[root2] += parent[root1];
                parent[root1] = root2;
            } else {
                parent[root1] += parent[root2];
                parent[root2] = root1;
            }
        }
    }

    public static int minimumCost(int n, int [][] connections) {
        Edges[] edges = new Edges[connections.length];

        for (int i=0; i < connections.length; i++) {
            edges[i] = new Edges(connections[i][0], connections[i][1], connections[i][2]);
        }

        Arrays.sort(edges);

        // initialize disjoint set to detect cycles
        DisjointSet disjointSet = new DisjointSet(n);
        int totalCost = 0;
        int edgesIncluded = 0;

        // Kruskal's algo to find MST
        for (int i=0; i < edges.length; i++) {
            int root1 = disjointSet.find(edges[i].source);
            int root2 = disjointSet.find(edges[i].destination);

            if(root1 != root2) {
                disjointSet.union(root1,root2);
                totalCost = edges[i].cost;
                edgesIncluded++;
            }
            if(edgesIncluded == n-1) break;
        }
        return edgesIncluded == n-1 ? totalCost : -1;
    }
}
