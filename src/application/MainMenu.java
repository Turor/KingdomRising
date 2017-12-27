package application;

import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;

/**
 * Main menu for Kingdom Rising
 * @author Turora
 * Note: The buttons could be combined into their own group so that they could be more easily
 * moved around on the screen. As of now, every button has to get changed individually. If at
 * a later date, the formatting gets more complex, do that.
 */
public class MainMenu extends Group {
	
	/**The button which enters the new game menu from the main menu*/
	private Button newGame;
	
	/**The button which enters the load game menu from the main menu*/
	private Button loadGame;
	
	/**The button which enter the option menu from the main menu*/
	private Button options;
	
	/**The button which exits the game from the main menu*/
	private Button exit;
	
	/**Canvas object which controls the background of the main menu*/
	private Canvas graphics;
	
	/**Controller which handles scene changes*/
	private Controller control;
	
	/**
	 * Default Constructor for the Main menu screen
	 */
	public MainMenu() {
		//The drop shadow effect for the buttons
		DropShadow dropshadow = new DropShadow();
		dropshadow.setOffsetX(6.0);
		dropshadow.setOffsetY(4.0);


		//Draw the background image
		graphics = new Canvas(768,512);
		Image background = new Image("Images/TitleScreen2.jpg");
		//graphics.minWidth(512);
		//graphics.minHeight(768);
		graphics.getGraphicsContext2D().drawImage(background, 0, 0,768,512);
		getChildren().add(graphics);
		
		//Draw the game title
		Text t = new Text("Kingdom Rising");
		t.setFont(Font.font("Lucida Calligraphy", FontPosture.ITALIC,72));
		t.setFill(Color.BLACK);
		t.setLayoutX(64);
		t.setLayoutY(144);
		t.setEffect(new DropShadow(5, 3, 3, Color.BLACK));	
		getChildren().add(t);
	
		//Add the new game button
		newGame = new Button("New Game");
		newGame.setEffect(dropshadow);
		newGame.setLayoutX(256);
		newGame.setLayoutY(224);
		newGame.setMinHeight(32);
		newGame.setMinWidth(256);	
		getChildren().add(newGame);
		
		//Add the load game button
		loadGame = new Button("Load Game");
		loadGame.setEffect(dropshadow);
		loadGame.setLayoutX(256);
		loadGame.setLayoutY(272);
		loadGame.setMinWidth(256);
		loadGame.setMinHeight(32);
		loadGame.setDisable(true);
		getChildren().add(loadGame);
		
		//Add the options button
		options = new Button("Options");
		options.setEffect(dropshadow);
		options.setLayoutX(256);
		options.setLayoutY(320);
		options.setMinWidth(256);
		options.setMinHeight(32);
		getChildren().add(options);
		
		//Add the exit game button
		exit = new Button("Exit");
		exit.setEffect(dropshadow);
		exit.setLayoutX(256);
		exit.setLayoutY(368);
		exit.setMinWidth(256);
		exit.setMinHeight(32);	
		getChildren().add(exit);
		
	}
	
	/**
	 * Method to gain access to the new game button
	 * @return The pointer to the new game button found on the main menu
	 */
	public Button getNewGame() {
		return newGame;
	}
	
	/**
	 * Method to gain access to the load game button
	 * @return The pointer to the load game button
	 */
	public Button getLoadGame() {
		return loadGame;
	}
	
	/**
	 * Method to gain access to the options button
	 * @return The pointer to the options menu
	 */
	public Button getOptions() {
		return options;
	}
	
	/**
	 * Method to gain access to the exit button
	 * @return The pointer to the exit button
	 */
	public Button getExit() {
		return exit;
	}

}
