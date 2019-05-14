package com.balazsholczer;

public class City {

	private int x;
	private int y;

	public City() {
		this.x = (int) (Math.random() * 10);
		this.y = (int) (Math.random() * 10);
		System.out.println(x+"-"+y);
	}

	public City(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public double distanceTo(City city) {

		int xDistance = Math.abs(getX() - city.getX());
		int yDistance = Math.abs(getY() - city.getY());

		double distance = Math.sqrt((xDistance * xDistance) + (yDistance * yDistance));

		return distance;
	}

	@Override
	public String toString() {
		return x + "-" + y;
	}
}
