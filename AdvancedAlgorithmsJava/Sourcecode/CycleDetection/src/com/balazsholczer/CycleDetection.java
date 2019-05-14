package com.balazsholczer;

import java.util.List;

public class CycleDetection {

	public void detectCycle(List<Vertex> vertexList) {
		
		for(Vertex vertex : vertexList) {
			
			if( !vertex.isVisited() ){
				dfs(vertex);
			}
		}
	}

	private void dfs(Vertex vertex) {
		
		System.out.println("DFS on vertex " + vertex);
		vertex.setBeingVisited(true);
		
		for(Vertex v : vertex.getAdjacenciesList()){
			
			System.out.println("Visiting the neighbours of vertex "+vertex);
			if( v.isBeingVisited() ) {
				System.out.println("Backward edge ... so there is a cycle");
				return;
			}
			
			if( !v.isVisited() ){
				System.out.println("isiting vertex "+v+"recursively...");
				v.setVisited(true);
				dfs(v);
			}
		}
		
		System.out.println("Set vertex "+vertex+" setBeingVisited(false) and visited(true)");
		vertex.setBeingVisited(false);
		vertex.setVisited(true);
		
	}
}
