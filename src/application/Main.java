package application;
	
import java.io.File;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			/*
			 * Root Directory Info
			 * -------------------
			 * MainMenu 	=	0
			 * Map 			= 	1
			 * InGameMenu	=	2
			 * CityMenu		=	3
			 * 
			 */
			Group root = new Group();
			Country country = new Country();
			
			MainMenu menu = new MainMenu();
			Map map = new Map(country);
			InGameMenu igMenu = new InGameMenu();
			
			//Instantiate all the city menus
			CityContainer cityMenu = new CityContainer(country);
			
			Controller control = new Controller(menu, map, cityMenu, igMenu,primaryStage);
			
			root.getChildren().addAll(menu,map,igMenu,cityMenu);
			
			Scene scene = new Scene(root,768,512);
			
			
			
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
