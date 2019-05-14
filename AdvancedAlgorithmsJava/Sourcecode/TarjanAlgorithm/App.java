package com.udemy;

import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) {
		
		List<Vertex> vertexList = new ArrayList<>();
		
		Vertex v1 = new Vertex("1");
		Vertex v2 = new Vertex("2");
		Vertex v3 = new Vertex("3");
		Vertex v4 = new Vertex("4");
		Vertex v5 = new Vertex("5");
		Vertex v6 = new Vertex("6");
		Vertex v7 = new Vertex("7");
		
		v1.addNeighbour(v5);
		v2.addNeighbour(v1);
		v3.addNeighbour(v2);
		v3.addNeighbour(v4);
		v4.addNeighbour(v3);
		v5.addNeighbour(v2);
		v6.addNeighbour(v2);
		v6.addNeighbour(v5);
		v6.addNeighbour(v7);
		v7.addNeighbour(v6);
		v7.addNeighbour(v3);
		
		vertexList.add(v1);
		vertexList.add(v2);
		vertexList.add(v6);
		vertexList.add(v4);
		vertexList.add(v5);
		vertexList.add(v3);
		vertexList.add(v7);
		
		TarjanAlgorithm tarjanAlgorithm = new TarjanAlgorithm(vertexList);
		tarjanAlgorithm.runAlgorithm();
		tarjanAlgorithm.printComponents();
	}
}
