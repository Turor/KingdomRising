package application;

import java.util.Random;

public class Country {
	
	/**The different cities which are present in the kingdom*/
	private City[] cities;
	
	/**The total number of people living in the country*/
	private long population;
	
	/**The total amount of money the player has collected*/
	private long wealth;
	
	/**The amount of money the player can spend*/
	private long capital;
	
	/**The number of people the player can put to work*/
	private long unemployed;
	
	/**The national modifier to growth*/
	private double growthModifier;
	
	/**The national modifier to income*/
	private double incomeModifier;
	
	/**The number of days which have passed since the start of the game*/
	private int date;
	
	public Country() {
		//Instantiate money and population
		wealth = 0;
		population = 0;
		capital = 0;
		unemployed = 0;
		date = 0;
		growthModifier = 1;
		incomeModifier = 1;
		
		//Instantiate the cities
		Random yolo = new Random();
		cities = new City[1];
		for(int i = 0; i < cities.length; i++) {
			int cityWealth = yolo.nextInt(10);
			int cityPop = yolo.nextInt(10);
			cities[i] = new City(cityWealth, cityPop, i);
			population+=cityPop;
			wealth+=cityWealth;
			unemployed += cityPop;
			capital+= cityWealth;
		}

	}
	
	/**
	 * Advances to the next day
	 */
	public void nextDay() {
		updateBonuses();
		updateWealth();
		updatePopulation();
		date++;
		//Check Random Event
	}
	
	/**
	 * Updates each city's bonuses
	 */
	private void updateBonuses() {
		for(int i = 0; i < cities.length;i++)
			cities[i].updateBonuses();
	}
	
	/**
	 * Updates each city's wealth and adds the change to the country's capital
	 */
	private void updateWealth() {
		for(int i = 0; i < cities.length;i++) {
			cities[i].updateIncome(incomeModifier);
			int dailyIncome = cities[i].getIncome();
			wealth += dailyIncome;
			capital += dailyIncome;
		}
	}
	
	/**
	 * Updates each city's growth and adds the change to the country's populace
	 */
	private void updatePopulation() {
		for(int i = 0; i < cities.length;i++) {
			cities[i].updatePopGrowth(growthModifier);
			int dailyGrowth = cities[i].getGrowth();
			population += dailyGrowth;
			unemployed += dailyGrowth;
		}
	}
	
	/**
	 * Method to return the total number of people who live in the kingdom
	 * @return
	 */
	public long getPopulation() {
		return population;
	}
	
	/**
	 * Method to return the amount of capital that has been spent on the country
	 * @return
	 */
	public long getWealth() {
		return wealth;
	}
	
	/**
	 * The amount of money the player has to work with
	 * @return
	 */
	public long getCapital() {
		return capital;
	}
	
	/**
	 * The amount of people the player has to work with
	 * @return
	 */
	public long getUnemployed() {
		return unemployed;
	}
	
	/**
	 * Returns how many days have passed since the game began
	 * @return
	 */
	public int getDate() {
		return date;
	}
	
	/**
	 * Method which returns the pointer to the city class that is currently being viewed
	 * @param index The city to be viewed
	 * @return
	 */
	public City getCity(int index) {
		return cities[index];
	}

}
