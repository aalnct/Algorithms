package PrimJarnikGreedy;

import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) {
		
		Graph graph = new Graph();
		
		Vertex vertexA = new Vertex("A");
		Vertex vertexB = new Vertex("B");
		Vertex vertexC = new Vertex("C");
		Vertex vertexD = new Vertex("D");
		Vertex vertexE = new Vertex("E");
		Vertex vertexF = new Vertex("F");
		Vertex vertexG = new Vertex("G");		
		
		graph.addVertex(vertexA);
		graph.addVertex(vertexB);
		graph.addVertex(vertexC);
		graph.addVertex(vertexD);
		graph.addVertex(vertexE);
		graph.addVertex(vertexF);
		graph.addVertex(vertexG);
			
		graph.addEdge(new Edge(vertexA, vertexB, 7));
		graph.addEdge(new Edge(vertexA, vertexD, 5));
		graph.addEdge(new Edge(vertexD, vertexB, 9));
		graph.addEdge(new Edge(vertexD, vertexE, 15));
		graph.addEdge(new Edge(vertexD, vertexF, 6));
		graph.addEdge(new Edge(vertexB, vertexE, 7));
		graph.addEdge(new Edge(vertexB, vertexC, 8));
		graph.addEdge(new Edge(vertexC, vertexE, 5));
		graph.addEdge(new Edge(vertexF, vertexE, 8));
		graph.addEdge(new Edge(vertexF, vertexG, 11));
		graph.addEdge(new Edge(vertexE, vertexG, 9));
		
		
		Algorithm algorithm = new Algorithm(graph);
		algorithm.spanningTree();
		algorithm.show();
	}
}
