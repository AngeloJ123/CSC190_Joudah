package application;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.image.ImageView;
import java.io.*;



public class Board extends Application {
	
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
		x.board[7][0].z = rooks[0].p;
		x.board[7][7].z = rooks[2].p;
		x.board[0][0].z = rooks[1].p;
		x.board[0][7].z = rooks[3].p;
		board.getChildren().add(rooks[i].p);
		}
				
		
	}
	
	public static void addKnights(Pane board, game x) {
		knight BlackL = new knight(2,8,Color.BLACK);
		knight BlackR = new knight(2,1,Color.BLACK);
		knight WhiteL = new knight(7,1,Color.WHITE);
		knight WhiteR = new knight(7,6,Color.WHITE);
		x.board[0][1].z = BlackL.p;
		x.board[0][7].z = BlackR.p;
		x.board[7][1].z = WhiteL.p;
		x.board[7][7].z = WhiteR.p;
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
	
	
	@Override public void start(Stage primaryStage) throws FileNotFoundException {
		InputStream stream = new FileInputStream("C:\\Users\\Angelo\\OneDrive\\Documents\\Eclipe Projects\\Chess Board\\src\\application\\wood.jpg");
		Image image = new Image(stream);
		ImageView imageview = new ImageView();
		imageview.setImage(image);
	    imageview.setX(0);
		imageview.setY(0);
		Rectangle board = new Rectangle(900,900);
		board.setY(50); 
		board.setX(500);
		board.setFill(Color.PINK);
		Pane pane = new Pane(board);
		pane.getChildren().add(imageview);
		createBlackandWhiteSquares(pane);
		
		
		game newGame = new game(pane);
		
		Scene Board = new Scene(pane,1600,800);
		
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
