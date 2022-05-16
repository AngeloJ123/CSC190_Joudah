package application;

import java.util.List;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class UserControls{
	
	public void move(game g, CoordNode node, Pane board, Stage s, Scene e, Pane w) {
		
		Move move = new Move(node.d,node.c);
		if(g.board[node.b][node.a] != null && g.board[node.b][node.a] != g.board[node.d][node.c] && g.board[node.b][node.a].validateMove(move) == true && g.board[node.b][node.a].team == g.turn) {
			Piece x = g.board[node.b][node.a];
			Piece y = g.board[node.d][node.c];
			if(y != null) {
				 board.getChildren().remove(y.z);
				 board.getChildren().remove(y.I);
				 if(g.board[node.d][node.c].team == true) {
					 g.Whites.remove(g.board[node.d][node.c]);
				 }
				 else {
					 g.Blacks.remove(g.board[node.d][node.c]);
				 }
			}
			g.board[node.d][node.c] = g.board[node.b][node.a];
			g.board[node.b][node.a] = null;
			g.board[node.d][node.c].y = node.c;
			g.board[node.d][node.c].x = node.d; 
			x.z.relocate(node.c * 100 + 575,node.d * 100 + 105);
			if(x.I != null) {x.updateImageLocation();}
			if(x instanceof PawnPiece && (node.d == 7 || node.d == 0)) { ((PawnPiece) x).promote(g,(PawnPiece)x,s,e,w);}
			if(x instanceof KingPiece && x.team == true) {g.WKC[0] = node.d;g.WKC[1] = node.c;}else if(x instanceof KingPiece && x.team == false) {g.BKC[0] = node.d;g.BKC[1] = node.d;}
			x.incrementCounter();
			if(x.team == true) {
			checkforCheck(g.Whites,g);}
			else {checkforCheck(g.Blacks,g);}
			if(((KingPiece)g.board[g.BKC[0]][g.BKC[1]]).isInCheck(g)) {
			if(g.turn == true && cantEscape(g)) {g.gameOver(g, s);}}
			if(((KingPiece)g.board[g.WKC[0]][g.WKC[1]]).isInCheck(g)) {
			if(g.turn == false && cantEscape(g)) {g.gameOver(g, s);}}
			g.nextTurn();
			}
		
	}
	
	public void checkforCheck(List<Piece> x, game g) {
		Piece y = x.get(0);
		g.getMoves(y.team);
		((KingPiece)(g.board[g.BKC[0]][g.BKC[1]])).check = false;
		((KingPiece)(g.board[g.WKC[0]][g.WKC[1]])).check = false;
		for(Piece f: x) {
			for(Move t: f.moves) {
				if(y.team == true) {
					if(t.x == g.BKC[0] && t.y == g.BKC[1]) {
						((KingPiece)(g.board[g.BKC[0]][g.BKC[1]])).check = true;
						g.Attackers.add(f);
					}
					if(g.Attackers.size() < 1) {((KingPiece)(g.board[g.BKC[0]][g.BKC[1]])).check = false;}

						}
				if(y.team == false) {
					if(t.x == g.WKC[0] && t.y == g.WKC[1]) {
						((KingPiece)(g.board[g.WKC[0]][g.WKC[1]])).check = true;
						g.Attackers.add(f);
					}
					if(g.Attackers.size() < 1) {((KingPiece)(g.board[g.WKC[0]][g.WKC[1]])).check = false;}

				}
			}
		}
	}
	public static boolean cantEscape(game g) {
		MatrixSearcher x = new MatrixSearcher();
		if(g.turn == true) {
			KingPiece k = ((KingPiece)g.board[g.BKC[0]][g.BKC[1]]);
			x.Search(k, g);
			if(g.Attackers.size() > 1 && k.moves.isEmpty()) {return true;}
			Move L = new Move(g.Attackers.get(0).x,g.Attackers.get(0).y);
			for(Piece y: g.Blacks) {
				for(Move f: y.moves) {
					if(f.compareTo(L) == true) {
						g.Attackers.clear();
						return false;
					}
				}
			}
		}
		if(g.turn == false) {
			KingPiece k = ((KingPiece)g.board[g.WKC[0]][g.WKC[1]]);
			x.Search(k, g);
			if(g.Attackers.size() > 1 && k.moves.isEmpty()) {return true;}
			Move L = new Move(g.Attackers.get(0).x,g.Attackers.get(0).y);
			for(Piece y: g.Whites) {
				for(Move f: y.moves) {
					if(f.compareTo(L) == true) {
						g.Attackers.clear();
						return false;
					}
				}
			}
			
		}
		return false;
	}
	
}
