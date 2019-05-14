package DijkstraAlgorithm;

import java.util.List;

public class App {

	public static void main(String[] args) {

		Vertex v0 = new Vertex("Redvile");
		Vertex v1 = new Vertex("Blueville");
		Vertex v2 = new Vertex("Greenville");
		Vertex v3 = new Vertex("Orangeville");
		Vertex v4 = new Vertex("Purpleville");

		v0.setAdjacencies(new Edge[]{ new Edge(v1, 5),
		                              new Edge(v2, 10),
	                                  new Edge(v3, 8) });
		v1.setAdjacencies(new Edge[]{ new Edge(v0, 5),
		                              new Edge(v2, 3),
		                              new Edge(v4, 7) });
		v2.setAdjacencies(new Edge[]{ new Edge(v0, 10),
	                                  new Edge(v1, 3) });
		v3.setAdjacencies(new Edge[]{ new Edge(v0, 8),
		                              new Edge(v4, 2) });
		v4.setAdjacencies(new Edge[]{ new Edge(v1, 7),
	                                  new Edge(v3, 2) });
		Vertex[] vertices = { v0, v1, v2, v3, v4 };
	  
		DijsktraAlgorithm dijsktraAlgorithm = new DijsktraAlgorithm();
		dijsktraAlgorithm.computePaths(v0);
	    
	    List<Vertex> path = dijsktraAlgorithm.getShortestPathTo(v4);
		System.out.println("Path: " + path);
	
		

	}
}
