package DAGShortestPath;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

	private String name;
	private Vertex predecessor;
	private boolean visited;
	private List<Edge> adjacenciesList;
	private double minDistance = Double.MAX_VALUE;
	
	public Vertex(String name){
		this.name = name;
		this.adjacenciesList = new ArrayList<Edge>();
	}
	
	public void addNeighbour(Edge edge){
		this.adjacenciesList.add(edge);
	}
	
	public Vertex getPredecessor() {
		return predecessor;
	}

	public void setPredecessor(Vertex predecessor) {
		this.predecessor = predecessor;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public double getMinDistance() {
		return minDistance;
	}

	public void setMinDistance(double minDistance) {
		this.minDistance = minDistance;
	}

	public List<Edge> getAdjacenciesList() {
		return adjacenciesList;
	}

	@Override
	public String toString() {
		return this.name;
	}
}
