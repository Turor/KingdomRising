package cityMenu;

import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import model.Building;
import javafx.scene.control.Tab;
import javafx.scene.paint.Color;

public class CommonTab extends Tab {

	public CommonTab(Building[] buildings) {
		
		
		setText("Common");
		Group list = new Group();
		Canvas yolo = new Canvas(400,416);
		yolo.getGraphicsContext2D().setFill(Color.rgb(235, 235, 255));
		yolo.getGraphicsContext2D().fillRect(0, 0, 400, 416);	
		list.getChildren().add(yolo);
		
		//Vertical padding
		int currenty = 8;
		for(int i = 0; i < buildings.length;i++) {
			if(buildings[i].getType() < 7) {
				BuildingBox b;
				b = new BuildingBox(buildings[i]);
				b.setLayoutX(8);
				b.setLayoutY(currenty);
				currenty+=68;
				list.getChildren().add(b);
			}
		}
		
		
		
		list.setLayoutX(32);
		list.setLayoutY(64);
		this.setContent(list);
		//this.setContent(list);

	}

}
