package application;

import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;

public class Map extends Group implements EventHandler<MouseEvent> {

	private Button nextDay;

	private Button options;

	/**Canvas which contains the game map*/
	private Canvas graphics;
	
	private Text unemployed;
	
	private Text money;
	
	private Country country;


	/**
	 * 0: Stormguard
	 * 1: Solhaven
	 * 2: Westwind
	 * 3: Aire
	 * 4: Myrcia
	 * 5: Victoria
	 * 6: Sylvard
	 * 7: The Golden Plains
	 * 8: Main Menu
	 */
	private Canvas[] icons;

	public Map(Country ncountry) {
		this.setVisible(false);
		
		country = ncountry;
		graphics = new Canvas(768,512);
		graphics.getGraphicsContext2D().drawImage(new Image("Images/MyrciaNoCities.jpg"), 0, 0);
		this.getChildren().add(graphics);

		icons = new Canvas[9];
		for(int i = 0; i < 9; i++){
			icons[i] = new Canvas(48,48);
			icons[i].getGraphicsContext2D().drawImage(new Image("Images/Icons/i"+i+
					".png"), 0, 0);
			//icons[i].setEffect(new DropShadow(5,6,6,Color.BLACK));
			icons[i].setCursor(Cursor.HAND);
			icons[i].setOnMousePressed(this);

			this.getChildren().add(icons[i]);
		}

		//Stormguard
		icons[0].setLayoutX(142);
		icons[0].setLayoutY(90);

		//Solhaven
		icons[1].setLayoutX(194);
		icons[1].setLayoutY(320);

		//Westwind
		icons[2].setLayoutX(273);
		icons[2].setLayoutY(215);

		//Aire
		icons[3].setLayoutX(428);
		icons[3].setLayoutY(24);

		//Myrcia
		icons[4].setLayoutX(420);
		icons[4].setLayoutY(204);

		//Victoria
		icons[5].setLayoutX(385);
		icons[5].setLayoutY(348);

		//Sylvard
		icons[6].setLayoutX(606);
		icons[6].setLayoutY(140);

		//The Golden Plains
		icons[7].setLayoutX(596);
		icons[7].setLayoutY(320);

		icons[8].setLayoutX(700);
		icons[8].setLayoutY(4);
		
		
		//Resource display box
		Canvas overlay = new Canvas(768,32);
		overlay.setLayoutY(480);
		overlay.setOpacity(.5);
		overlay.getGraphicsContext2D().setFill(Color.GRAY);
		overlay.getGraphicsContext2D().fillRect(0, 0, 768, 32);
		overlay.getGraphicsContext2D().setStroke(Color.BLACK);
		overlay.getGraphicsContext2D().strokeRect(0, 0, 768, 32);
		
		getChildren().add(overlay);
		
		//Citizen display
		unemployed = new Text("Pop: "+country.getUnemployed());
		unemployed.setFont(Font.font("Lucida Calligraphy", FontPosture.REGULAR,24));
		unemployed.setFill(Color.BLACK);
		unemployed.setLayoutX(192);
		unemployed.setLayoutY(504);
		//unemployed.setEffect(new DropShadow(2, 3, 3, Color.ALICEBLUE));	
		getChildren().add(unemployed);
		
		//Money display
		money = new Text("Money: "+ country.getCapital());
		money.setFont(Font.font("Lucida Calligraphy", FontPosture.REGULAR,24));
		money.setFill(Color.BLACK);
		money.setLayoutX(8);
		money.setLayoutY(504);
		//money.setEffect(new DropShadow(2,3,3,Color.ALICEBLUE));
		getChildren().add(money);
		
		
		
		
		
		
		
	}

	public void handle(MouseEvent event) {
		if(event.getSource().equals(icons[8])){
			Alert a = new Alert(Alert.AlertType.CONFIRMATION);
			a.setTitle("Exit Game");
			a.setContentText("Are you sure you want to exit to the menu?");
			
			Optional<ButtonType> result = a.showAndWait();
			if(result.isPresent() && result.get()==ButtonType.OK) {
				this.getParent().getChildrenUnmodifiable().get(0).setVisible(true);
				this.setVisible(false);
			}
		}else if(event.getSource().equals(icons[0])) {
			this.setVisible(false);
		}

	}


}
