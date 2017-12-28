package application;

public class City {
	
	/**How much the city is growing a day*/
	private int growth;
	
	/**The amount of money the city is generating a day*/
	private int income;
	
	/**The bonuses each type of building is receiving to their income*/
	private double[] bonuses;
	
	/**The list of building objects*/
	private Building[] buildings;
	
	
	public City(int popStart, int moneyStart, int cityID) {
		growth = popStart;
		income = moneyStart;
		buildings = new Building[6];
		if(cityID == 0) {
			//Shack
			String name = "Favella";
			String desc = "Place where poor laborers live and lacks all kinds of comforts.";
			int gCost = 5;
			int popCost = 0;
			int gInc = 0;
			int pInc = 5;
			int type = 1;
			double[] tbonuses = new double[] {0,0,0,.05,0,0};
			
			buildings[0] = new Building(name, desc, gCost, popCost, gInc, pInc, type,tbonuses);
						
			//Cottages
			name = "Cottage";
			desc = "Place where skilled laborers live. Nice and cozy. These people can actua"
					+ "lly pay taxes.";
			gCost = 10;
			popCost = 0;
			gInc = 1;
			pInc = 3;
			type = 2;
			buildings[1] = new Building(name, desc, gCost, popCost, gInc, pInc, type,tbonuses);
			
			//Estate
			name = "Estate";
			desc = "Place where wealthy merchants and nobles live. They pay tribute"
					+ " directly to the Royal Family.";
			gCost = 50;
			popCost = 2;
			gInc = 10;
			pInc = 1;
			type = 3;
			buildings[2] = new Building(name, desc, gCost, popCost, gInc, pInc, type,tbonuses);
			
			//Fishing boat
			name = "Fishing Boat";
			desc = "A state owned vessel which employees fishermen to go out and catch fish";
			gCost = 10;
			popCost = 5;
			gInc = 8;
			pInc = 0;
			type = 4;
			buildings[3] = new Building(name, desc, gCost, popCost, gInc, pInc, type,tbonuses);
			
			//Artisan Shops
			name = "Artisan Shops";
			desc = "These shops are owned by artisans who sell their crafts.";
			gCost = 20;
			popCost = 3;
			gInc = 13;
			pInc = 0;
			type = 5;
			buildings[4] = new Building(name, desc, gCost, popCost, gInc, pInc, type,tbonuses);
			
			//Chartered Companies
			name = "Chartered Companies";
			desc = "A chartered company is one which possesses a Royal charter, giving"
					+ " the company the right to act with the authority of the Royal family.";
			gCost = 250;
			popCost = 150;
			gInc = 200;
			pInc = 0;
			type = 6;
			buildings[5] = new Building(name, desc, gCost, popCost, gInc, pInc, type,tbonuses);
			
		
			
		}
		
		
		
		//Method which establishes that which makes cities unique
		//instantiateUniqueProperties(cityID);
		
	}
	
	private void updateBonuses() {
		for(int type = 0; type < bonuses.length;type++) {
			for(int building = 0; building < buildings.length; building++) {
				
			}
		}
	}
		
	private void updateIncome() {
		income = 0;
		for(int i = 0; i < buildings.length;i++) {
			income += buildings[i].getGIncome()*bonuses[i];
		}
	}
	
	private void updateGrowth() {
		growth = 0;
		for(int i = 0; i < buildings.length;i++) {
			growth += buildings[i].getPIncome()*bonuses[i];
		}
	}
	
	public int getIncome() {
		updateIncome();
		return income;
	}
	
	public int getGrowth() {
		updateGrowth();
		return growth;
	}

}
