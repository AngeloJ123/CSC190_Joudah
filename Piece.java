package application;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;
import java.util.*;
abstract class Piece {
	
	int x; 
	int y;
	int counter;
	Shape z;
	boolean team;
	ImageView I;
	ArrayList<Move> moves = new ArrayList<Move>();
	protected void incrementCounter(){
		counter++;
	}

	protected void setImageIn(Pane p) {
		I.setFitHeight(80);
		I.setFitWidth(80);
		p.getChildren().add(I);
	}
	protected void updateImageLocation() {
		I.setX(y * 100 + 560);
		I.setY(x * 100 + 110);
	}
	protected abstract void makeListOfMoves(game g);
	protected boolean validateMove(Move x) {
		for(int i = 0;i<this.moves.size();i++) {
			if(this.moves.get(i).compareTo(x) == true) {
				return true;
			}
		}
		return false;
	}
}

