package application;

import java.io.File;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {

		/*
		 * Root Directory Info
		 * -------------------
		 * MainMenu 	=	0
		 * Map 			= 	1
		 * InGameMenu	=	2
		 * Stormguard	=	3
		 * 
		 * 
		 */
		AnchorPane root = new AnchorPane();
		Country country = new Country();

		MainMenu menu = new MainMenu();
		Map map = new Map(country);
		InGameMenu igMenu = new InGameMenu();

		//Instantiate all the city menus
		//CityContainer cityMenu = new CityContainer(country);
		
		CityMenu stormguard = new CityMenu(country.getCity(0),0);

		Controller control = new Controller(menu, map, igMenu,primaryStage);

		root.getChildren().addAll(menu,map,igMenu,stormguard);

		Scene scene = new Scene(root,768,512);




		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();


	}

	public static void main(String[] args) {
		launch(args);
	}
}
