package DAGShortestPath;

import java.util.List;
import java.util.Stack;

public class AcyclicShortestPath {

	public void shortestPath(List<Vertex> vertexList, Vertex sourceVertex, Vertex targetVertex){
		
		sourceVertex.setMinDistance(0);
		TopologicalSort topologicalSort = new TopologicalSort();
		topologicalSort.makeTopologicalOrder(vertexList);
		
		Stack<Vertex> stack = topologicalSort.getTopologicalOrder();
			
		for(Vertex actualVertex : stack){
		
			System.out.print(actualVertex+" ");
			
			for(Edge edge : actualVertex.getAdjacenciesList()){
				
				Vertex u = edge.getStartVertex();
				Vertex v = edge.getTargetVertex();
				
				double newDistance = u.getMinDistance() + edge.getWeight();
				
				if( newDistance < v.getMinDistance() ){
					v.setMinDistance(newDistance);
					v.setPredecessor(u);
				}						
			}	
		}
		
		if( targetVertex.getMinDistance() == Double.MAX_VALUE){
			System.out.println("No shortest path there...");
		}else{
			System.out.println("Target vertex shortest path: "+targetVertex.getMinDistance());
		}
		
	}
}
