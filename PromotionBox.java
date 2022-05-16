package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class PromotionBox {
	game l;
	PawnPiece x;
	Stage v;
	Scene Board;
	Pane w;
	public PromotionBox(PawnPiece f, game g, Stage q, Scene B, Pane w1) {
		x = f;
		l = g;
		v = q;
		Board = B;
		start(v);
		w = w1;
	}
	
	

	public void start(Stage box){
		
		
		
		VBox pane = new VBox();pane.setPadding(new Insets(5,5,5,5));
		RadioButton r1 = new RadioButton("Queen"); RadioButton r2 = new RadioButton("Rook"); RadioButton r3 = new RadioButton("Knight"); RadioButton r4 = new RadioButton("Bishop");
		ToggleGroup group = new ToggleGroup();
		r1.setToggleGroup(group); r2.setToggleGroup(group); r3.setToggleGroup(group); r4.setToggleGroup(group);pane.getChildren().addAll(r1,r2,r3,r4);
		r1.setOnAction(e -> {QueenPiece t = new QueenPiece(x.x,x.y,x.team); queen q = new queen(x.y,x.x,(Color) x.z.getFill());q.Create();t.z = q.p;l.board[x.x][x.y] = t;w.getChildren().add(t.z);w.getChildren().remove(x.z) ;l.Whites.remove(x); l.Blacks.remove(x);if(t.team == true) {l.Whites.add(t);} else{l.Blacks.add(t);}box.setScene(Board);box.show();});
		r2.setOnAction(e -> {RookPiece t = new RookPiece(x.x,x.y,x.team); rook q = new rook(x.y,x.x,(Color) x.z.getFill());q.Create();t.z = q.p;l.board[x.x][x.y] = t;w.getChildren().add(t.z);w.getChildren().remove(x.z) ;l.Whites.remove(x); l.Blacks.remove(x);if(t.team == true) {l.Whites.add(t);} else{l.Blacks.add(t);}box.setScene(Board);box.show();});
		r3.setOnAction(e -> {KnightPiece t = new KnightPiece(x.x,x.y,x.team); knight q = new knight(x.y,x.x,(Color) x.z.getFill());q.Create();t.z = q.p;l.board[x.x][x.y] = t;w.getChildren().add(t.z);w.getChildren().remove(x.z) ;l.Whites.remove(x); l.Blacks.remove(x);if(t.team == true) {l.Whites.add(t);} else{l.Blacks.add(t);}box.setScene(Board);box.show();});
		r4.setOnAction(e -> {BishopPiece t = new BishopPiece(x.x,x.y,x.team); bishop q = new bishop(x.y,x.x,(Color) x.z.getFill());q.Create();t.z = q.p;l.board[x.x][x.y] = t;w.getChildren().add(t.z);w.getChildren().remove(x.z) ;l.Whites.remove(x); l.Blacks.remove(x);if(t.team == true) {l.Whites.add(t);} else{l.Blacks.add(t);}box.setScene(Board);box.show();});
		
		
		
		box.setTitle("Promotion");
		Scene x = new Scene(pane,400,400); 
		box.setScene(x);
		box.setMaximized(true);
		box.setFullScreen(true);
		box.show();
	}
	public static void main(String[] args) {
		Application.launch(args);
	}

}
