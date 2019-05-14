package PrimJarnikGreedy;

import java.util.List;
import java.util.PriorityQueue;

public class Algorithm {

	private List<Vertex> vertexList;
	private PriorityQueue<Vertex> heap;
	
	public Algorithm(Graph graph){
		this.vertexList = graph.getVertexList();
		this.heap = new PriorityQueue<>();
	}
	
	public void spanningTree(){
	
		for(Vertex vertex : vertexList){
			if( !vertex.isVisited() ){
				greedyPrim(vertex);
			}
		}	
	}
	
	private void greedyPrim(Vertex vertex){
		
		vertex.setMinDistance(0);
		heap.add(vertex);
		
		while( !heap.isEmpty() ){
			Vertex v = heap.remove();
			scanVertex(v);
		}
	}

	private void scanVertex(Vertex vertex) {
		vertex.setVisited(true);
		
		for( Edge edge : vertex.getAdjacencies() ){
			Vertex w = edge.getTargetVertex();
			
			if( w.isVisited() ) continue;
			
			if( edge.getWeight() < w.getMinDistance() ){
				w.setMinDistance(edge.getWeight());
				w.setMinEdge(edge);
				
				if( this.heap.contains(w) ){
					this.heap.remove(w);
				}
				
				this.heap.add(w);
			}	
		}
	}
	
	public void show(){
		for(Vertex vertex : vertexList){
			if( vertex.getMinEdge() != null ){
				Edge e = vertex.getMinEdge();
				System.out.println("Edge: "+e.getStartVertex()+"-"+e.getTargetVertex());
			}
		}
	}
}