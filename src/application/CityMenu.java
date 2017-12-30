package application;

import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class CityMenu extends Group {
	
	public CityMenu(City city,int index) {
		setVisible(false);
		

		
		//Pull the cityscape image
		//Image picture = new Image("Images/Cityscape/"+index+".jpg");
		Image picture = new Image("Images/Cityscape/0.jpg");
		//Insert the image into an image view
		ImageView stormguard = new ImageView(picture);
		
		//Initialize the pointer to the viewport's rectangle
		Rectangle2D rect;
		
		//Decide whether to crop from top and bottom or left and right
		if(picture.getHeight()<picture.getWidth()) {
			stormguard.setFitWidth(240);
			double d = (picture.getWidth()-picture.getHeight())/2;
			rect = new Rectangle2D(d, 0, picture.getWidth()-d, picture.getHeight());
			System.out.print(picture.getWidth() + " " + picture.getHeight() +" "+ (picture.getWidth()-d));
			
			
		}else if(picture.getHeight()>picture.getWidth()) {
			stormguard.setFitHeight(240);
			double d = (picture.getHeight()-picture.getWidth())/2;
			rect = new Rectangle2D(0,d,picture.getWidth(),picture.getHeight()-d);
			
		}else {
			stormguard.setFitHeight(240);
			rect = new Rectangle2D(0,0,picture.getWidth(),picture.getHeight());
		}
		
		stormguard.setViewport(rect);
		stormguard.setPreserveRatio(true);
		stormguard.setSmooth(true);
		stormguard.setCache(true);
		stormguard.setLayoutX(520);
		stormguard.setLayoutY(8);
		
		
		
		Canvas background = new Canvas(768,480);
		background.getGraphicsContext2D().setFill(Color.AZURE);
		background.getGraphicsContext2D().fillRect(0, 0, 768, 480);
		background.setOpacity(.25);
		this.getChildren().add(background);
		
		this.getChildren().add(stormguard);
		
		
	}

}
