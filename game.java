package application;
import java.util.*;

import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
class game{

	Piece [][] board = new Piece[8][8];
	List<Piece> Whites = new ArrayList<Piece>(16);
	List<Piece> Blacks = new ArrayList<Piece>(16);
	List<Piece> Attackers = new ArrayList<Piece>(16);
	int[] BKC = new int[2];
	int[] WKC = new int[2];
	boolean turn;
	boolean blackCheck;
	boolean whiteCheck;
	
	public game() {
	//this.startGame();
	for(int i = 0; i<8; i++) {
		for(int j = 0; j<8; j++) {
			board[i][j] = null;
			
			if(board[i][j] != null && board[i][j].team == true) {
				Whites.add(board[i][j]);
			}
			else if(board[i][j] != null && board[i][j].team == false) {
				Blacks.add(board[i][j]);
			}
			turn = true;
			
		}
	}
	
	
	
	this.startGame();
	for(int i = 0; i<8; i++) {
		for(int j = 0; j<8; j++) {
	if(board[i][j] != null && board[i][j].team == true) {
		Whites.add(board[i][j]);
	}
	else if(board[i][j] != null && board[i][j].team == false) {
		Blacks.add(board[i][j]);
	}
		}
	}
	BKC[0] = 0; WKC[0] = 7;
	BKC[1] = 4; WKC[1] = 4;
	getMoves(true);
	}
	
	protected void wipeMoves() {
		for(int i = 0; i<=Whites.size()-1;i++) {
			if(Whites.get(i).moves.isEmpty() != true) {
			Whites.get(i).moves.clear();
			}
		}
		for(int i = 0; i<=Blacks.size()-1;i++) {
			if(Blacks.get(i).moves.isEmpty() != true) {
			Blacks.get(i).moves.clear();
			}
		}
	}
	
	protected void nextTurn() {
		if(this.turn == true) {
			this.turn = false;
		}
		else {
			this.turn = true;
		}
		wipeMoves();
		getMoves(turn);
	}
	
	public void getMoves(boolean x) {
		if(x == true) {
			for(int i = 0;i<=Whites.size()-1;i++) {
				Whites.get(i).makeListOfMoves(this);
		}
		}
		if(x == false) {
			for(int i = 0;i<=Blacks.size()-1;i++) {
			Blacks.get(i).makeListOfMoves(this);
		}
		}
	}
	
	
	public void putPawnsIn() {
		for(int i = 1; i<7; i+=5) {
			for(int j = 0; j<8; j++) {
				if(i == 1) {
				board[i][j] = new PawnPiece(i,j,false);
				}
				else {
				board[i][j] = new PawnPiece(i,j,true);
				}
			}
		}
	}
	public void putKingsIn() {
		board[0][4] = new KingPiece(0,4,false);
		board[7][4] = new KingPiece(7,4,true);
	}
	public void putQueensIn() {
		board[7][3] = new QueenPiece(7,3,true);
		board[0][3] = new QueenPiece(0,3,false);
	}
	public void putBishopsIn() {
		for(int i = 0; i<8; i+=7) {
			for(int j = 2; j<6; j+=3) {
				if(i == 0) {
				board[i][j] = new BishopPiece(i,j,false);
				}
				else {
				board[i][j] = new BishopPiece(i,j,true);
				}
			}
		}
	}
	public void putKnightsIn() {
		for(int i = 0; i<8; i+=7) {
			for(int j = 1; j<7; j+=5) {
				if(i == 0) {
				board[i][j] = new KnightPiece(i,j,false);
				}
				else {
				board[i][j] = new KnightPiece(i,j,true);
				}
		}
	}
	}
	
	public void putRooksIn() {
		for(int i = 0; i<8; i+=7) {
			for(int j = 0; j<8; j+=7) {
				if(i == 0) {
				board[i][j] = new RookPiece(i,j,false);
				}
				else {
				board[i][j] = new RookPiece(i,j,true);
				}
		}
	}
	}
	
	public void setTeams() {
		for(int i = 0; i<8;i++){
			board[0][i].team = false;
			board[1][i].team = false;
		}
		for(int i = 0; i<8;i++) {
			board[6][i].team = true;
			board[7][i].team = true;
		}
	}
	
	void displayVirtualBoard() {//for I/O
		for(int i = 0; i<8; i++) {
			for(int j = 0; j<8; j++) {
				if(j == 0) { System.out.println('\n');}
				System.out.print(board[i][j] + " ");
			}
		}
	}
	public void gameOver(game g, Stage s) {
			Pane pane = new Pane();
			pane.getChildren().add(new Button("Game Over"));
			Scene scene = new Scene(pane,400,400);
			s.setScene(scene);
	}
	public void startGame() {
		putPawnsIn();
		putKingsIn();
		putQueensIn();
		putBishopsIn();
		putKnightsIn();
		putRooksIn();
		setTeams();
	}
			
				
	
	
}
