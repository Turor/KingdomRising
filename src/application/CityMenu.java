package application;

import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class CityMenu extends Group {
	
	public CityMenu(City city,int index) {
		setVisible(false);
		

		
		//Pull the cityscape image
		Image picture = new Image("Images/Cityscape/"+index+".jpg");
		//Image picture = new Image("Images/Cityscape/1.jpg");
		
		
		
		int x = 0;
		int y = 0;
		int width = 0;
		int height = 0;
		PixelReader yolo = picture.getPixelReader();
		WritableImage pic;
		
		if(picture.getHeight()<picture.getWidth()) {
			int d = (int)(picture.getWidth()-picture.getHeight());
			x = d/2;
			y = 0;
			width = (int)picture.getWidth()-d;
			height = (int)picture.getHeight();
			
			System.out.print(d+ " ");
			
			pic = new WritableImage(yolo,x,y,width,height);
		}else if(picture.getHeight()>picture.getWidth()) {
			int d = (int)(-picture.getWidth()+picture.getHeight());
			x = 0;
			y = d/2;
			width = (int)picture.getWidth();
			height = (int)(picture.getHeight()-d);
			
			System.out.print(d+ " ");
			
			pic = new WritableImage(yolo,x,y,width,height);
			
		} else {
			width = (int)picture.getWidth();
			height = (int)picture.getHeight();
			pic = new WritableImage(yolo,0,0,width,height);
		}
			
		//Insert the image into an image view
		ImageView stormguard = new ImageView(pic);
		System.out.println(pic.getWidth() + " " + pic.getHeight());
		
		if(picture.getWidth() < picture.getHeight())
			stormguard.setFitWidth(240);
		else if(picture.getWidth()>picture.getHeight())
			stormguard.setFitHeight(240);
		else
			stormguard.setFitHeight(240);
		
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
