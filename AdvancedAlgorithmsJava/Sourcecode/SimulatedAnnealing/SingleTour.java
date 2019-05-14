package com.balazsholczer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SingleTour {

	private List<City> tour = new ArrayList<>();
	private int distance = 0;

	public SingleTour() {
		for (int i = 0; i < Repository.numberOfCities(); i++) {
			tour.add(null);
		}
	}

	public SingleTour(List<City> tour) {
		List<City> currentTour = new ArrayList<>();

		for (int i = 0; i < tour.size(); ++i)
			currentTour.add(null);

		for (int i = 0; i < tour.size(); ++i)
			currentTour.set(i, tour.get(i));

		this.tour = currentTour;
	}

	public List<City> getTour() {
		return tour;
	}

	public void generateIndividual() {
		for (int cityIndex = 0; cityIndex < Repository.numberOfCities(); cityIndex++) {
			setCity(cityIndex, Repository.getCity(cityIndex));
		}

		Collections.shuffle(tour);
	}

	public City getCity(int tourPosition) {
		return (City) tour.get(tourPosition);
	}

	public void setCity(int tourPosition, City city) {
		tour.set(tourPosition, city);
		distance = 0;
	}

	public int getDistance() {
		if (distance == 0) {
			int tourDistance = 0;

			for (int cityIndex = 0; cityIndex < tourSize(); cityIndex++) {

				City fromCity = getCity(cityIndex);
				City destinationCity;

				if (cityIndex + 1 < tourSize()) {
					destinationCity = getCity(cityIndex + 1);
				} else {
					destinationCity = getCity(0);
				}

				tourDistance += fromCity.distanceTo(destinationCity);
			}
			distance = tourDistance;
		}
		return distance;
	}

	public int tourSize() {
		return tour.size();
	}

	@Override
	public String toString() {
		String geneString = "|";
		for (int i = 0; i < tourSize(); i++) {
			geneString += getCity(i) + "|";
		}
		return geneString;
	}
}
