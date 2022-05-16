package application;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

class BishopPiece extends Piece{

	public BishopPiece(int xf, int yf, boolean t) {
		team = t;
		x = xf;
		y = yf;
		counter = 0;
	}

	@Override
	protected void makeListOfMoves(game g) {
		moves = new MatrixSearcher().Search(this, g);
	}


}




class KnightPiece extends Piece{

	public KnightPiece(int xf, int yf, boolean t) {
		team = t;
		x = xf;
		y = yf;
		counter = 0;
	}

	@Override
	protected void makeListOfMoves(game g) {
		moves = new MatrixSearcher().Search(this, g);
		
	}
}




class RookPiece extends Piece{

	public RookPiece(int xf, int yf, boolean t) {
		team = t;
		x = xf;
		y = yf;
		counter = 0;
	}

	@Override
	protected void makeListOfMoves(game g) {
		moves = new MatrixSearcher().Search(this, g);
	}

}





class QueenPiece extends Piece{

	public QueenPiece(int xf, int yf, boolean t) {
		counter = 0;
		team = t;
		x = xf;
		y = yf;
	}
	@Override
	protected void makeListOfMoves(game g) {
		moves = new MatrixSearcher().Search(this, g);
		
	}

}




class KingPiece extends Piece{
	boolean check;
	public KingPiece(int xf, int yf, boolean t) {
		counter = 0;
		team = t;
		x = xf;
		y = yf;
		check = false;
	}

	@Override
	protected void makeListOfMoves(game g) {
		moves = new MatrixSearcher().Search(this, g);
	}
	protected void castle() {
		
	}
	public boolean isInCheck(game g) {
		if(this.check == true) {return true;}
		return false;
	}
}




class PawnPiece extends Piece{
	
	public PawnPiece(int xf, int yf, boolean t) {
		team = t;
		x = xf;
		y = yf;
		counter = 0;
	}

	@Override
	protected void makeListOfMoves(game g) {
		moves = new MatrixSearcher().Search(this, g);
		}
	
	protected void promote(game g, PawnPiece x, Stage s, Scene B, Pane w) {	
		new PromotionBox(x,g,s,B,w);
	}
			//new Stage().setScene(new Scene(sortedList,500,500));
			
	}
