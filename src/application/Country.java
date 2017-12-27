package application;

import java.util.Random;

public class Country {
	
	private City[] cities;
	
	private int population;
	
	private int money;
	
	public Country() {
		//Instantiate money and population
		money = 0;
		population = 0;
		
		//Instantiate the cities
		Random yolo = new Random();
		cities = new City[8];
		for(int i = 0; i < cities.length; i++) {
			int cityWealth = yolo.nextInt(10);
			int cityPop = yolo.nextInt(10);
			cities[i] = new City(cityWealth, cityPop, i);
			population+=cityWealth;
			money+=cityPop;
		}
		
		
		
		
	}
	
	public int getMoney() {
		return money;
	}
	
	public int getPopulation() {
		return population;
	}
	
	public void nextDay() {
		updateMoney();
		updatePopulation();
		updateBonuses();
	}
	
	private void updateMoney() {
		for(int i = 0; i < cities.length;i++) {
			money += cities.getIncome();
		}
	}
	
	private void updatePopulation() {
		for(int i = 0; i < cities.length;i++)
			population += cities.getPopulation();
	}

}
