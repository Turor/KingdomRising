package application;

import javafx.scene.Group;

public class CityContainer extends Group {
	
	public CityContainer(Country country) {
		//Starts hidden
		this.setVisible(false);
		
		//Create all the different city menus
		CityMenu stormguard = new CityMenu(country.getCity(0));
		
		
	}
	
}
