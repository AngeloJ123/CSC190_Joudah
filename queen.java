package application;

import javafx.scene.paint.Color;
import javafx.scene.shape.*;

public class queen extends PieceModel {
	Shape p;
	int row;
	int column;
	Color color;
	public queen(int n, int k, Color t) {
		row = n;
		column = k;
		color = t;
	}
	
	public void Create() {
		
		
	
		
		Circle top = new Circle(row * 100 + 500, column * 100 + 15,5);
		Circle halfCirc = new Circle(row * 100 + 500, column * 100 + 28.5,12.5);
		Polygon midHead = new Polygon(row * 100 + 517.5,column * 100 + 28.5,row * 100 + 500,column * 100 + 40,row * 100 + 482.5,column * 100 + 28.5);
		Rectangle body = new Rectangle(row * 100 + 491, column * 100 + 35, 17.5, 57.5);
		Ellipse ring = new Ellipse(row * 100 + 500,column * 100 + 57.5, 15, 5);
		Ellipse bottom = new Ellipse(row * 100 + 500,column * 100 + 90, 25, 7.5);
		
		Shape un1 = Shape.union(halfCirc, midHead);
		Shape un2 = Shape.union(body, top);
		Shape un3 = Shape.union(un1, un2);
		Shape un4 = Shape.union(un3, ring);
		Shape unf = Shape.union(un4, bottom);
	
		unf.setStroke(Color.BLACK);
		unf.setFill(color);
		p = unf;
	}
	

}
