package application;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;


public class king extends PieceModel {


		Shape p;
		int row;
		int column;
		Color color;
		public king(int n, int k, Color t) {
			row = n;
			column = k;
			color = t;
		}
		
		public void Create() {
			
			Rectangle crossVert = new Rectangle(row * 100 + 495, column * 100 + 10,10,25);
			Rectangle crossHoriz = new Rectangle(row * 100 + 487.5, column * 100 + 15,25,7.5);
			Ellipse belowCross = new Ellipse(row * 100 + 500, column * 100 + 30,15,5);
			Polygon upperPiece = new Polygon(new double[] {row * 100 + 485, column * 100 + 30,row * 100 + 492.5,column * 100 + 40,row * 100 + 507.5,column * 100 + 40,row * 100 + 515,column * 100 + 30});
			Ellipse Upper = new Ellipse(row * 100 + 500, column * 100 + 45,15,5);
			Rectangle base = new Rectangle(row * 100 + 491.5, column * 100 + 30,17.5,60);
			Ellipse bottom = new Ellipse(row * 100 + 500, column * 100 + 90,20,10);
			

			
			Shape un1 = Shape.union(base, bottom);
			Shape un2 = Shape.union(crossHoriz, crossVert);
			Shape un3 = Shape.union(Upper, upperPiece);
			Shape un4 = Shape.union(un2, un1);
			Shape un5 = Shape.union(un4, bottom);
			Shape un6 = Shape.union(un3, un5);
			Shape unf = Shape.union(belowCross,un6);
			

			unf.setStroke(Color.BLACK);
			unf.setFill(color);

		    p = unf;

			
			
		}
		
		
		
	}
