package application;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

class pawn extends PieceModel{

	Shape p;
	int row;
	int column;
	static Color color;
	public pawn(int n, int k) {
		row = n;
		column = k;
		
	}
	
	public void Create() {
		
		Rectangle body = new Rectangle(25,60);
		Circle head = new Circle(20);
		Ellipse top = new Ellipse(20,10);
		Ellipse bottom = new Ellipse(25,10);

		top.setCenterX(row * 100 + 500);
		top.setCenterY(column * 100 + 50);
		bottom.setCenterX(row * 100 + 500);
		bottom.setCenterY(column * 100 + 85);
		head.setCenterX(row * 100 + 500);
		head.setCenterY(column * 100 + 30);
		body.setX(row * 100 + 487.5);
		body.setY(column * 100 + 30);
		
		
		top.setFill(color);
		bottom.setFill(color);
		body.setFill(color);
		head.setFill(color);
		
		
		Shape intersection1 = Shape.union(top, bottom);
		Shape intersection2 = Shape.union(head, body);
		Shape intersection3 = Shape.union(intersection1, intersection2);
		
		intersection3.setStroke(Color.BLACK);
		intersection3.setFill(color);
		
		
		p = intersection3;

		
		
	}
	
	
	
}
