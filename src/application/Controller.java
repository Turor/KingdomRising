package application;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Controller implements EventHandler<ActionEvent> {
	
	private MainMenu mmenu;
	
	private Map map;
	
	private CityContainer upgrades;
	
	private InGameMenu igmenu;
	
	private Stage mainStage;
	
	public Controller(MainMenu newmenu, Map newMap, CityContainer cityMenu, InGameMenu newigmenu,
			Stage primaryStage) {
		
		mmenu = newmenu;
		
		//Set up 
		mmenu.getExit().setOnAction(this);
		mmenu.getNewGame().setOnAction(this);
		mmenu.getLoadGame().setOnAction(this);
		mmenu.getOptions().setOnAction(this);
		
		
		map = newMap;
		upgrades = cityMenu;
		igmenu = newigmenu;
		mainStage = primaryStage;
	}
	
	public void handle(ActionEvent event) {
		if(event.getSource().equals(mmenu.getExit())) {
			Platform.exit();
		}else if(event.getSource().equals(mmenu.getNewGame())) {
			map.setVisible(true);
			mmenu.setVisible(false);

		}else if(event.getSource().equals(mmenu.getOptions())) {
			mmenu.setVisible(false);
			igmenu.setVisible(true);
			
		}
	}
	
	public void handle(MouseEvent event) {
		
	}
	
	

}
