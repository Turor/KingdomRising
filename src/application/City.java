package application;

public class City {
	
	private int growth;
	
	private int income;
	
	private int[] growthBuild;
	
	private double[] growthBonus;
	
	private int[] incomeBuild;
	
	private double[] incomeBonus;
	
	private Building[] ids;
	
	
	public City(int popStart, int moneyStart, int cityID, Building[] list) {
		ids = list;
		growth = popStart;
		income = moneyStart;
		
		growthBuild = new int[3];
		incomeBuild = new int[3];
		
		growthBonus = new double[3];
		incomeBonus = new double[3];
		for(int i = 0; i < growthBuild.length;i++) {
			growthBuild[i] = 0;
			growthBonus[i] = 1;
		}
		
		for(int i = 0; i < incomeBuild.length;i++) {
			incomeBuild[i] = 0;
			incomeBonus[i] = 1;
		}
		
		//Method which establishes that which makes cities unique
		//instantiateUniqueProperties(cityID);
		
	}

	//TODO
	private void instantiateUniqueProperties(int cityID) {
		
	}
	
	public int getIncome() {
		
		
	}

}
