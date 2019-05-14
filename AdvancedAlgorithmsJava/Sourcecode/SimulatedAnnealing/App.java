package com.balazsholczer;

public class App {

	public static void main(String[] args) {

		for (int i = 0; i < 4; i++) {
			City city = new City();
			Repository.addCity(city);
		}

		SimulatedAnnealing simulatedAnnealing = new SimulatedAnnealing();
		simulatedAnnealing.simulation();

		System.out.println("Final solution distance: " + simulatedAnnealing.getBestRoute().getDistance());
		System.out.println("Tour: " + simulatedAnnealing.getBestRoute());
	}
}
