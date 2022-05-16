package application;

import javafx.scene.paint.Color;
import javafx.scene.shape.*;

public class rook extends PieceModel {

	Shape p;
	int row;
	int column;
	Color color;
	public rook(int n, int k, Color t) {
		row = n;
		column = k;
		color = t;
	}
	
	public void Create() {
		Polygon head = new Polygon(new double[] {row * 100 + 477.5, column * 100 + 20,row * 100 + 485, column * 100 + 10,row * 100 + 490, column * 100 + 10,row * 100 + 490, column * 100 + 20,row * 100 + 495, column * 100 + 20,row * 100 + 495, column * 100 + 10,row * 100 + 505, column * 100 + 10,row * 100 + 505, column * 100 + 20,row * 100 + 510, column * 100 + 20,row * 100 + 510, column * 100 + 10,row * 100 + 515, column * 100 + 10,row * 100 + 522.5, column * 100 + 20});
		Polygon middleUpper = new Polygon(new double[] {row * 100 + 477.5, column * 100 + 20,row * 100 + 485, column * 100 + 30,row * 100 + 515, column * 100 + 30,row * 100 + 522.5, column * 100 + 20});
		Rectangle Body = new Rectangle(row * 100 + 487.5,column * 100 + 30,25,45);
		Polygon booty = new Polygon(new double[] {row * 100 + 477.5,column * 100 + 95,row * 100 + 487.5,column * 100 + 70,row * 100 + 512.5,column * 100 + 70,row * 100 + 522.5,column * 100 + 95});
		
		
		Shape un1 = Shape.union(head, middleUpper);
		Shape un2 = Shape.union(booty, Body);
		Shape unf = Shape.union(un1, un2);
		
		unf.setStroke(Color.BLACK);
		unf.setFill(color);
		
		p = unf;

	}
}
