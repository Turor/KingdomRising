package cityMenu;

import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import model.City;

public class CityMenu extends Group {
	
	public CityMenu(City city,int index) {
		setVisible(false);
		
		//Fog out the map
		Canvas background = new Canvas(768,480);
		background.getGraphicsContext2D().setFill(Color.AZURE);
		background.getGraphicsContext2D().fillRect(0, 0, 768, 480);
		background.setOpacity(.25);
		background.getStyleClass().add("overlay");
		this.getChildren().add(background);
		

		
		//Pull the cityscape image
		Image picture = new Image("Images/Cityscape/"+index+".jpg");
		//Image picture = new Image("Images/Cityscape/1.jpg");
		
		
	
			
		//Insert the image into an image view
		ImageView stormguard = new ImageView(picture);
		Rectangle2D rect;
		
		if(picture.getWidth()<picture.getHeight()) {
			double d = picture.getHeight()-picture.getWidth();
			rect = new Rectangle2D(0,d/2,picture.getWidth(),picture.getHeight()-d);
			stormguard.setFitWidth(240);
		}else if( picture.getWidth()>picture.getHeight()) {
			double d = picture.getWidth()-picture.getHeight();
			rect = new Rectangle2D(d/2,0,picture.getWidth()-d,picture.getHeight());
			stormguard.setFitHeight(240);
		}else {
			rect = new Rectangle2D(-picture.getWidth()/2,-picture.getHeight()/2,picture.getWidth()/2,picture.getHeight()/2);
			stormguard.setFitHeight(240);
		}
		
		stormguard.setViewport(rect);
		
		stormguard.setPreserveRatio(true);
		stormguard.setSmooth(true);
		stormguard.setCache(true);
		stormguard.setLayoutX(520);
		stormguard.setLayoutY(8);
		
		this.getChildren().add(stormguard);
		
		//Make the building tabs
		TabPane yolo = new TabPane();
		yolo.setLayoutX(32);
		yolo.setLayoutY(16);

		CommonTab t = new CommonTab(city.getBuildingsList());
		t.setClosable(false);
		yolo.getTabs().add(t);
		this.getChildren().add(yolo);
		
		
		
		
	}

}
