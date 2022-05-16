package application;

import javafx.scene.paint.Color;
import javafx.scene.shape.*;

class knight extends PieceModel{

	Shape p;
	int row;
	int column;
	Color color;
	public knight(int n, int k, Color t) {
		row = n;
		column = k;
		color = t;
	}
	public void Create() {
		
		
	
		Ellipse bottom = new Ellipse(row * 100 + 500,column * 100 + 90, 35, 7.5);
		Polygon body = new Polygon(row * 100 + 470, column * 100 + 70 , row * 100 + 485 , column * 100 + 60 , row * 100 + 485 
				, column * 100 + 40 , row * 100 + 465, column * 100 + 40, row * 100 + 480, column * 100 + 20, 
				row * 100 + 500, column * 100 + 10 ,row * 100 + 515, column * 100 + 30, row * 100 + 515, column * 100 + 60,row * 100 +  530, column * 100 + 70 );
		Polygon butt = new Polygon(row * 100 + 470, column * 100 + 70, row * 100 + 465, column * 100 + 90, row * 100 + 535, column * 100 + 90, row * 100 + 530, column * 100 + 70);
		Polygon Hair = new Polygon(row * 100 + 500, column * 100 + 10, row * 100 + 520 ,column * 100 + 10, row * 100 + 525, column * 100 + 30, row * 100 + 525, column * 100 + 55, row * 100 + 505, column * 100 + 55);

		
		
		Shape un1 = Shape.union(body, bottom);
		Shape un2 = Shape.union(Hair, un1);
		Shape unf = Shape.union(un2, butt);
	
		unf.setStroke(Color.BLACK);
		unf.setFill(color);
		p = unf;
	}
	

}
