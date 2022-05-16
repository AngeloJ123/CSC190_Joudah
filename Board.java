package application;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import java.io.*;




public class Board extends Application {
	
	
	public static void handleImages(Stage box, game g, Image T,Scene Board, Pane p) {
		VBox pane = new VBox();pane.setPadding(new Insets(5,5,5,5));
		RadioButton r1 = new RadioButton("Queen"); RadioButton r2 = new RadioButton("Rook"); RadioButton r3 = new RadioButton("Knight"); RadioButton r4 = new RadioButton("Bishop");RadioButton r5 = new RadioButton("Pawn");
		ToggleGroup group = new ToggleGroup();
		r1.setToggleGroup(group); r2.setToggleGroup(group); r3.setToggleGroup(group); r4.setToggleGroup(group);pane.getChildren().addAll(r1,r2,r3,r4,r5);
		r1.setOnAction(e -> {for(Piece x:g.Whites) {if(x instanceof QueenPiece) {ImageView I = new ImageView();I.setImage(T);x.I = I;x.setImageIn(p);x.updateImageLocation();}}for(Piece x:g.Blacks) {if(x instanceof QueenPiece) {ImageView I = new ImageView();I.setImage(T);x.I = I;x.setImageIn(p);x.updateImageLocation();}};box.setScene(Board);});
		r2.setOnAction(e -> {for(Piece x:g.Whites) {if(x instanceof RookPiece) {ImageView I = new ImageView();I.setImage(T);x.I = I;x.setImageIn(p);x.updateImageLocation();}}for(Piece x:g.Blacks) {if(x instanceof RookPiece) {ImageView I = new ImageView();I.setImage(T);x.I = I;x.setImageIn(p);x.updateImageLocation();}};box.setScene(Board);});
		r3.setOnAction(e -> {for(Piece x:g.Whites) {if(x instanceof KnightPiece) {ImageView I = new ImageView();I.setImage(T);x.I = I;x.setImageIn(p);x.updateImageLocation();}}for(Piece x:g.Blacks) {if(x instanceof KnightPiece) {ImageView I = new ImageView();I.setImage(T);x.I = I;x.setImageIn(p);x.updateImageLocation();}};box.setScene(Board);});
		r4.setOnAction(e -> {for(Piece x:g.Whites) {if(x instanceof BishopPiece) {ImageView I = new ImageView();I.setImage(T);x.I = I;x.setImageIn(p);x.updateImageLocation();}}for(Piece x:g.Blacks) {if(x instanceof BishopPiece) {ImageView I = new ImageView();I.setImage(T);x.I = I;x.setImageIn(p);x.updateImageLocation();}};box.setScene(Board);});
		r5.setOnAction(e -> {for(Piece x:g.Whites) {if(x instanceof PawnPiece) {ImageView I = new ImageView();I.setImage(T);x.I = I;x.setImageIn(p);x.updateImageLocation();}}for(Piece x:g.Blacks) {if(x instanceof PawnPiece) {ImageView I = new ImageView();I.setImage(T);x.I = I;x.setImageIn(p);x.updateImageLocation();}};box.setScene(Board);});		
		box.setTitle("ImageSel");
		Scene x = new Scene(pane,400,400); 
		box.setScene(x);
		box.setMaximized(true);
		box.setFullScreen(true);
		box.show();
	}
	
	
	
	public static void createBlackandWhiteSquares(Pane board) {
		for(int i = 0;i<8;i++) {
			for(int j = 0; j<8;j++) {
				
			Rectangle newRec = new Rectangle(100,100);
			newRec.setX((i+1)*100+450);
			newRec.setY((j+1)*100);
			if((i % 2 == 0 && j % 2 == 0) || (i % 2 == 1 && j % 2 == 1)) {
				newRec.setStroke(Color.BLACK);
				newRec.setFill(Color.GRAY);
			}
			if((i % 2 == 0 && j % 2 == 1)|| (i % 2 == 1 && j % 2 == 0)) {
				newRec.setFill(Color.WHITE);
				newRec.setStroke(Color.BLACK);
			}
			board.getChildren().add(newRec);
			}
		}
	}
	
	public static void addPawns(Pane board, game x) {
		for(int i = 1; i<=8;i++) {
			for(int j = 2; j<=7; j+=5) {
				pawn newPawn = new pawn(i,j);
				if(j % 2 == 0) {pawn.color = Color.BLACK;
				}
				else {pawn.color = Color.WHITE;}
				
				newPawn.Create();
				x.board[j-1][i-1].z = newPawn.p;
				
				board.getChildren().add(newPawn.p);
				
			}
		}
		
	}
	
	public static void addRooks(Pane board, game x) {
		rook[] rooks = new rook[] {new rook(1,8,Color.WHITE),new rook(1,1,Color.BLACK),new rook(8,8,Color.WHITE),new rook(8,1,Color.BLACK)};
		for(int i = 0; i<= rooks.length-1;i++) {
		rooks[i].Create();
		board.getChildren().add(rooks[i].p);
		}
		x.board[7][0].z = rooks[0].p;
		x.board[7][7].z = rooks[2].p;
		x.board[0][0].z = rooks[1].p;
		x.board[0][7].z = rooks[3].p;	
	}
	
	public static void addKnights(Pane board, game x) {
		knight BlackL = new knight(2,1,Color.BLACK);
		knight BlackR = new knight(7,1,Color.BLACK);
		knight WhiteL = new knight(2,8,Color.WHITE);
		knight WhiteR = new knight(7,8,Color.WHITE);
		BlackL.Create();
		BlackR.Create();
		WhiteL.Create();
		WhiteR.Create();
		x.board[0][1].z = BlackL.p;
		x.board[0][6].z = BlackR.p;
		x.board[7][1].z = WhiteL.p;
		x.board[7][6].z = WhiteR.p;
		board.getChildren().add(BlackL.p);
		board.getChildren().add(BlackR.p);	
		board.getChildren().add(WhiteR.p);	
		board.getChildren().add(WhiteL.p);	
	}
	
	public static void addKings(Pane board, game x) {
		king BlackK = new king(5,1,Color.BLACK);
		king WhiteK = new king(5,8,Color.WHITE);
		WhiteK.Create();
		BlackK.Create();
		x.board[0][4].z = BlackK.p;
		x.board[7][4].z = WhiteK.p;
		board.getChildren().add(WhiteK.p);
		board.getChildren().add(BlackK.p);	
	}
	
	public static void addQueens(Pane board, game x) {
		queen BlackQ = new queen(4,1,Color.BLACK);
		queen WhiteQ = new queen(4,8,Color.WHITE);
		WhiteQ.Create();
		BlackQ.Create();
		x.board[0][3].z = BlackQ.p;
		x.board[7][3].z = WhiteQ.p;
		board.getChildren().add(WhiteQ.p);
		board.getChildren().add(BlackQ.p);	
	}
	
	public static void addBishops(Pane board, game x) {
		bishop[] bishops = new bishop[]{new bishop(3,1,Color.BLACK),new bishop(6,1,Color.BLACK),new bishop(3,8,Color.WHITE),new bishop(6,8,Color.WHITE)};
		for(int i = 0; i<= bishops.length-1;i++) {
			bishops[i].Create();
			board.getChildren().add(bishops[i].p);
			}
		x.board[0][2].z = bishops[0].p;
		x.board[0][5].z = bishops[1].p;
		x.board[7][2].z = bishops[2].p;
		x.board[7][5].z = bishops[3].p;
		
	}

	public static void putPiecesOnBoard(Pane board, game Game) {
		addBishops(board,Game);
		addPawns(board,Game);
		addQueens(board,Game);
		addKings(board,Game);
		addKnights(board,Game);
		addRooks(board,Game);
	}
	
	@Override public void start(Stage primaryStage) throws FileNotFoundException {
		game current;
		InputStream stream = getClass().getResourceAsStream("wood.jpg");
		Image image = new Image(stream);
		ImageView imageview = new ImageView();
		imageview.setImage(image);
	    imageview.setX(0);
		imageview.setY(0);
		UserControls user = new UserControls();
		Pane pane = new Pane();
		pane.getChildren().add(imageview);
		createBlackandWhiteSquares(pane);
		current = new game();
		putPiecesOnBoard(pane,current);
		Button imageSelecter = new Button("Select");
		pane.getChildren().add(imageSelecter);
		Scene Board = new Scene(pane,1600,800);
		CoordNode holder = new CoordNode();
		
		
		Board.setOnMousePressed(e -> {
			if(e.getButton() == MouseButton.PRIMARY) { 
				holder.a = (int)(Math.floor((e.getSceneX() - 450) / 100)) - 1;
				holder.b = (int)(Math.floor(e.getSceneY()) / 100) - 1;
			}
			} );
		
		Board.setOnMouseReleased(e -> {
			if(e.getButton() == MouseButton.PRIMARY) {
				System.out.println(current.Attackers);
				holder.c = (int)(Math.floor((e.getSceneX() - 450) / 100)) - 1;
				holder.d = (int)(Math.floor(e.getSceneY()) / 100) - 1 ;
				if(holder.a > 7 || holder.c > 7 || holder.a  < 0 || holder.c < 0 || holder.b > 7 || holder.d > 7 || holder.b  < 0 || holder.d < 0) {holder.wipe();}
				else {user.move(current,holder,pane,primaryStage,Board,pane);}}});
		
		imageSelecter.setOnMousePressed(e -> {
			FileChooser filec = new FileChooser();
			filec.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("All Images", "*.*"),
	        new FileChooser.ExtensionFilter("JPG", "*.jpg"),
	        new FileChooser.ExtensionFilter("PNG", "*.png"));
			File file = filec.showOpenDialog(primaryStage);
			Image fileImage = new Image(file.toURI().toString());
			ImageView selImage = new ImageView();
			selImage.setImage(fileImage);
			handleImages(primaryStage,current,fileImage,Board,pane);
			});
		
		primaryStage.setTitle("Chess");
		primaryStage.setScene(Board);
		primaryStage.setMaximized(true);
		primaryStage.setFullScreen(true);
		primaryStage.show();
	}
	

	public static void main(String[] args) {
		Application.launch(args);
	}
}
