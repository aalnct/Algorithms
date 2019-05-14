package DijkstraAlgorithm;

import java.util.List;

public class Vertex implements Comparable<Vertex> {

	private String name;
	private Edge[] adjacencies;
	private double minDistance = Double.POSITIVE_INFINITY;
	private Vertex previousVertex;

	public Vertex(String name) {
		this.name = name;
	}
	
	public void setPreviousVertex(Vertex vertex){
		this.previousVertex=vertex;
	}
	
	public Vertex getPreviousVertex(){
		return this.previousVertex;
	}
	
	public Edge[] getAdjacencies(){
		return this.adjacencies;
	}
	
	public void setAdjacencies(Edge[] edges){
		this.adjacencies=edges;
	}

	public double getMinDistance() {
		return minDistance;
	}

	public void setMinDistance(double minDistance) {
		this.minDistance = minDistance;
	}

	@Override
	public String toString() {
		return this.name;
	}

	@Override
	public int compareTo(Vertex otherVertex) {
		return Double.compare(minDistance, otherVertex.minDistance);
	}
}
