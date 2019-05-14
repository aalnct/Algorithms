package DijkstraAlgorithm;

public class Edge {

	private Vertex targetVertex;
	private double weight;

	public Edge(Vertex targetVertex, double weight) {
		this.targetVertex = targetVertex;
		this.weight = weight;
	}

	public Vertex getTargetVertex() {
		return targetVertex;
	}

	public void setTargetVertex(Vertex targetVertex) {
		this.targetVertex = targetVertex;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
}
