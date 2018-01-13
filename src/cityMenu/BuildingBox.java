package cityMenu;





import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import model.Building;


public class BuildingBox extends Group {
	
	private TextField popCost;
	
	private TextField goldCost;
	
	private TextField currentPopIncome;
	
	private TextField currentGoldIncome;
	
	private TextArea description;
	
	private Text name;
	
	

	public BuildingBox(Building b) {
		
		Canvas background = new Canvas(384,64);
		background.getGraphicsContext2D().setFill(Color.rgb(20, 20, 20));
		background.getGraphicsContext2D().fillRect(0, 0, 384, 60);
		this.getChildren().add(background);
		
		Image icon = new Image("Images/Buildings/"+b.getName()+".png");
		ImageView yolo = new ImageView(icon);
		yolo.setLayoutX(4);
		yolo.setLayoutY(4);
		this.getChildren().add(yolo);
		
		name = new Text();
		name.setText(b.getName());
		name.setLayoutX(4);
		name.setLayoutY(40);
		name.getStyleClass().add("name");
		this.getChildren().add(name);
		
		goldCost = new TextField();
		goldCost.setLayoutX(80);
		goldCost.setLayoutY(0);
		goldCost.setMaxWidth(56);
		goldCost.setMaxHeight(8);
		goldCost.setText(""+b.getGCost());
		goldCost.setEditable(false);
		goldCost.getStyleClass().add("cost");
		goldCost.setMouseTransparent(true);
		goldCost.setFocusTraversable(false);
		this.getChildren().add(goldCost);
		
		ImageView gCostIcon = new ImageView(new Image("Images/Icons/GoldCost.png"));
		gCostIcon.setLayoutX(72);
		gCostIcon.setLayoutY(4);
		this.getChildren().add(gCostIcon);
		
		
		popCost = new TextField();
		popCost.setLayoutX(140);
		popCost.setMaxWidth(48);
		popCost.setMaxHeight(8);
		popCost.setText(""+b.getPCost());
		popCost.setEditable(false);
		popCost.getStyleClass().add("cost");
		popCost.setMouseTransparent(true);
		popCost.setFocusTraversable(false);
		this.getChildren().add(popCost);
		
		ImageView pCostIcon = new ImageView(new Image("Images/Icons/PopCost.png"));
		pCostIcon.setLayoutX(134);
		pCostIcon.setLayoutY(4);
		this.getChildren().add(pCostIcon);
		
		
		
		
		
		
	}
	
}
