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
		//Image picture = new Image("Images/Cityscape/"+index+".jpg");
		Image picture = new Image("Images/Cityscape/1.jpg");
		
		
		
		int x = 0;
		int y = 0;
		int width = 0;
		int height = 0;
		PixelReader yolo = picture.getPixelReader();
		WritableImage pic;
		
		if(picture.getHeight()<picture.getWidth()) {
			int d = (int)(picture.getWidth()-picture.getHeight());
			x = d;
			y = 0;
			width = (int)picture.getWidth()-d;
			height = (int)picture.getHeight();
			
			System.out.print(d+ " ");
			
			pic = new WritableImage(yolo,x,y,width,height);
		}else if(picture.getHeight()>picture.getWidth()) {
			int d = (int)(-picture.getWidth()+picture.getHeight());
			x = 0;
			y = (int) (d);
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
		
		//Initialize the pointer to the viewport's rectangle
//		Rectangle2D rect;
		
		//Decide whether to crop from top and bottom or left and right
//		if(picture.getHeight()<picture.getWidth()) {
//			
//			double d = (picture.getWidth()-picture.getHeight())/2;
//			rect = new Rectangle2D(d, 0, picture.getWidth()-d, picture.getHeight());
//			System.out.print(picture.getWidth() + " " + picture.getHeight() +" "+ (picture.getWidth()-2*d));
//			
//		}else if(picture.getHeight()>picture.getWidth()) {
//			
//			double d = (picture.getHeight()-picture.getWidth())/2;
//			rect = new Rectangle2D(0,d,picture.getWidth(),picture.getHeight()-d);
//			
//		}else {
//			
//			rect = new Rectangle2D(0,0,picture.getWidth(),picture.getHeight());
//		}
		//Rectangle2D rect = new Rectangle2D(picture.getWidth()/2-120, 0, 240, 240);

		
		//Insert the image into an image view

		//ImageView stormguard = new ImageView(picture);
		
		
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
