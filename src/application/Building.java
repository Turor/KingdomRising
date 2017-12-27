package application;

public class Building {
	
	private String name;
	
	private String description;
	
	private int cost;
	
	private int income;
	
	/**
	 * The type identifier for this building
	 * 1: Low-Income Housing
	 * 2: Med-Income Housing
	 * 3: High-Income Housing
	 * 4: Low-Income Industry
	 * 5: Med-Income Industry
	 * 6: High-Income Industry
	 * 
	 * TODO: 
	 * 7: Unique Buildings
	 * 8: National Wonders
	 * 9: World Wonders
	 */
	private int type;
	
	private int count;
	
	public Building(String nName, String nDesc, int nCost, int nIncome, int nType) {
		name = nName;
		description = nDesc;
		cost = nCost;
		income = nIncome;
		type = nType;
	}
}
