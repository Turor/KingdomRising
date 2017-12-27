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
			Group root = new Group();
			
			MainMenu menu = new MainMenu();
			Map map = new Map();
			Upgrades upgrade = new Upgrades();
			InGameMenu igMenu = new InGameMenu();
			
			
			Controller control = new Controller(menu, map, upgrade, igMenu,primaryStage);
			
			root.getChildren().addAll(menu,map,upgrade,igMenu);
			
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
