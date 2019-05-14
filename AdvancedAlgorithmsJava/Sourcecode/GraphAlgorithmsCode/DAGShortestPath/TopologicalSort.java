package DAGShortestPath;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class TopologicalSort {

	private Stack<Vertex> stack;
	
	public TopologicalSort(){
		this.stack = new Stack<>();
	}
	
	public void makeTopologicalOrder(List<Vertex> vertexList){
		
		for(Vertex vertex : vertexList){
			if( !vertex.isVisited() ){
				dfs(vertex);
			}
		}
	}

	private void dfs(Vertex vertex) {
		
		for(Edge edge : vertex.getAdjacenciesList()){
			if( !edge.getTargetVertex().isVisited() ){
				edge.getTargetVertex().setVisited(true);
				dfs(edge.getTargetVertex());
			}
		}
		
		this.stack.push(vertex);
	}
	
	public Stack<Vertex> getTopologicalOrder(){
		Collections.reverse(stack);
		return this.stack;		
	}
}
