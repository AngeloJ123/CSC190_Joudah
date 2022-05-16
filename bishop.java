package application;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class bishop extends PieceModel{
	Shape p;
	int row;
	int column;
	Color color;
	public bishop(int n, int k, Color t) {
		row = n;
		column = k;
		color = t;
	}
	public void Create() {
		
		
	
		
		Circle top = new Circle(row * 100 + 500, column * 100 + 15,5);
		Circle halfCirc = new Circle(row * 100 + 500, column * 100 + 28.5,12.5);
		Rectangle body = new Rectangle(row * 100 + 491, column * 100 + 35, 17.5, 57.5);
		Ellipse ring = new Ellipse(row * 100 + 500,column * 100 + 50, 15, 5);
		Ellipse ringLower = new Ellipse(row * 100 + 500,column * 100 + 80, 17.5, 5);
		Ellipse bottom = new Ellipse(row * 100 + 500,column * 100 + 90, 25, 7.5);
		Polygon cut = new Polygon(row * 100 + 510.5,column * 100 + 15,row * 100 + 512.5,column * 100 + 14,row * 100 + 500,column * 100 + 25,row * 100 + 500,column * 100 + 20);
		
		Shape un1 = Shape.union(halfCirc, top);
		Shape un2 = Shape.union(body, un1);
		Shape un3 = Shape.union(bottom, un2);
		Shape un4 = Shape.union(ringLower, ring);
		Shape un5 = Shape.union(un3, un4);
		Shape unf = Shape.union(un5, cut);
	
		unf.setStroke(Color.BLACK);
		unf.setFill(color);
		p = unf;
	}
	

}
