package DijkstraAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class DijsktraAlgorithm {

	public void computePaths(Vertex sourceVertex){
		 
		sourceVertex.setMinDistance(0);
		PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>();
		priorityQueue.add(sourceVertex);
		
		while( !priorityQueue.isEmpty() ){
			Vertex actualVertex = priorityQueue.poll();
			
			for( Edge edge : actualVertex.getAdjacencies() ){
				Vertex v = edge.getTargetVertex();
				double weight = edge.getWeight();
				double currentDistanceThroghV = actualVertex.getMinDistance() +  weight;
				
				if( currentDistanceThroghV < v.getMinDistance() ){
					priorityQueue.remove(v);
					v.setMinDistance(currentDistanceThroghV);
					v.setPreviousVertex(actualVertex);
					priorityQueue.add(v);
				}
			}
		}
	}
	
	public List<Vertex> getShortestPathTo(Vertex targetVertex){
		List<Vertex> path = new ArrayList<Vertex>();
        for (Vertex vertex = targetVertex; vertex != null; vertex = vertex.getPreviousVertex())
            path.add(vertex);
        Collections.reverse(path);
        return path;	
	}
}
