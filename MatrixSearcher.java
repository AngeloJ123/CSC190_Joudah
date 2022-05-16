package application;
import java.util.*;

public class MatrixSearcher{
	

	public ArrayList<Move> Search(PawnPiece x, game g){
		ArrayList<Move> listofMoves = new ArrayList<Move>();
		if(x.team == true) {
			if(x.counter == 0 && x.x-2 >= 0) {
			if(g.board[x.x-2][x.y] == null) {listofMoves.add(new Move(x.x-2,x.y));}
			if(g.board[x.x-1][x.y] == null) {listofMoves.add(new Move(x.x-1,x.y));}
			}
			else if(x.x-1 >= 0) {
			if(g.board[x.x-1][x.y] == null) {listofMoves.add(new Move(x.x-1, x.y));}
			if(x.y-1 >= 0 && g.board[x.x-1][x.y-1] != null) {if(g.board[x.x-1][x.y-1].team == false) {listofMoves.add(new Move(x.x-1,x.y-1));}}
			if(x.y+1 <= 7 && g.board[x.x-1][x.y+1] != null)  {if(g.board[x.x-1][x.y+1].team == false) {listofMoves.add(new Move(x.x-1,x.y+1));}}
		}}
		 if(x.team == false){
			 if(x.counter == 0 && x.x+2 <= 7) {
				if(g.board[x.x+2][x.y] == null) {listofMoves.add(new Move(x.x+2,x.y));}
				if(g.board[x.x+1][x.y] == null) {listofMoves.add(new Move(x.x+1,x.y));}
				}
				else if(x.x+1 <= 7){
				{if(g.board[x.x+1][x.y] == null) {listofMoves.add(new Move(x.x+1, x.y));}}
				if(x.y-1 >= 0 && g.board[x.x+1][x.y-1] != null) {if(g.board[x.x+1][x.y-1].team == true) {listofMoves.add(new Move(x.x+1,x.y-1));}}
				if(x.y+1 <= 7 && g.board[x.x+1][x.y+1] != null) {if(g.board[x.x+1][x.y+1].team == true) {listofMoves.add(new Move(x.x+1,x.y+1));}}
		}
		 }
		return listofMoves;
	}
	
	
	
	
	
	
	
	public ArrayList<Move> Search(BishopPiece x, game g){
		ArrayList<Move> listofMoves = new ArrayList<Move>();
		int ny = 1;int nx = 1;
		while(x.y + ny <= 7 && x.x + nx <= 7) {
			if(x.team == true) {
				if(g.board[x.x + nx][x.y + ny] == null) {listofMoves.add(new Move(x.x + nx, x.y + ny));}
				else if(g.board[x.x + nx][x.y + ny] != null && g.board[x.x + nx][x.y + ny].team == true) {break;}
				else {
					listofMoves.add(new Move(x.x + nx, x.y + ny));
					break;
				}
			}
			else {
				if(g.board[x.x + nx][x.y + ny] == null) {listofMoves.add(new Move(x.x + nx, x.y + ny));}
				else if(g.board[x.x + nx][x.y + ny] != null && g.board[x.x + nx][x.y + ny].team == false) {break;}
				else {
					listofMoves.add(new Move(x.x + nx, x.y + ny));
					break;
			}
		}
			nx++;ny++;
		}
		
		ny = 1; nx = 1;
		while(x.y - ny >= 0 && x.x - nx >= 0) {
			if(x.team == true) {
				if(g.board[x.x - nx][x.y - ny] == null) {listofMoves.add(new Move(x.x - nx, x.y - ny));}
				else if(g.board[x.x - nx][x.y - ny] != null && g.board[x.x - nx][x.y - ny].team == true) {break;}
				else {
					listofMoves.add(new Move(x.x - nx, x.y - ny));
					break;
				}
			}
			else {
				if(g.board[x.x - nx][x.y - ny] == null) {listofMoves.add(new Move(x.x - nx, x.y - ny));}
				else if(g.board[x.x - nx][x.y - ny] != null && g.board[x.x - nx][x.y - ny].team == false) {break;}
				else {
					listofMoves.add(new Move(x.x - nx, x.y - ny));
					break;
				}
		}
			nx++;ny++;
		}
		
		ny = 1; nx = 1;
		while(x.y + ny <= 7 && x.x - nx >= 0) {
			if(x.team == true) {
				if(g.board[x.x - nx][x.y + ny] == null) {listofMoves.add(new Move(x.x - nx, x.y + ny));}
				else if(g.board[x.x - nx][x.y + ny] != null && g.board[x.x - nx][x.y + ny].team == true) {break;}
				else {
					listofMoves.add(new Move(x.x - nx, x.y + ny));
					break;
				}
			}
			else {
				if(g.board[x.x - nx][x.y + ny] == null) {listofMoves.add(new Move(x.x - nx, x.y + ny));}
				else if(g.board[x.x - nx][x.y + ny] != null && g.board[x.x - nx][x.y + ny].team == false) {break;}
				else {
					listofMoves.add(new Move(x.x - nx, x.y + ny));
					break;
				}
		}
			nx++;ny++;
		}
		
		ny = 1; nx = 1;
		while(x.y - ny >= 0 && x.x + nx <= 7) {
			if(x.team == true) {
				if(g.board[x.x + nx][x.y - ny] == null) {listofMoves.add(new Move(x.x + nx, x.y - ny));}
				else if(g.board[x.x + nx][x.y - ny] != null && g.board[x.x + nx][x.y - ny].team == true) {break;}
				else {
					listofMoves.add(new Move(x.x + nx, x.y - ny));
					break;
				}
			}
			else {
				if(g.board[x.x + nx][x.y - ny] == null) {listofMoves.add(new Move(x.x + nx, x.y - ny));}
				else if(g.board[x.x + nx][x.y - ny] != null && g.board[x.x + nx][x.y - ny].team == false) {break;}
				else {
					listofMoves.add(new Move(x.x + nx, x.y - ny));
					break;
				}
		}
			nx++;ny++;
		}
		
		
		return listofMoves;
	}
	
	
	
	
	
	
	public ArrayList<Move> Search(KnightPiece x, game g){
		ArrayList<Move> listofMoves = new ArrayList<Move>();
		Integer[][] v = {{1,2},{-1,2},{1,-2},{-1,-2},{2,1},{-2,1},{2,-1},{-2,-1}};
		int nx, ny;
		for(int i = 0;i<=v.length-1;i++) {
			nx = v[i][0]; ny = v[i][1];
			if(x.x + nx <= 7 && x.x + nx >= 0 && x.y + ny <= 7 && x.y + ny >= 0){if(g.board[x.x+nx][x.y+ny] == null || (x.team != g.board[x.x+nx][x.y+ny].team)){listofMoves.add(new Move(x.x + nx,x.y + ny));}}
		}
		return listofMoves;
	}
	
	public ArrayList<Move> Search(RookPiece x, game g){
		int nx = 1;int ny = 1;
		ArrayList<Move> listofMoves = new ArrayList<Move>();
		while(x.x + nx <= 7) {
			if(x.team == true) {
				if(g.board[x.x + nx][x.y] == null) {listofMoves.add(new Move(x.x + nx, x.y));}
				else if(g.board[x.x + nx][x.y] != null && g.board[x.x + nx][x.y].team == true) {break;}
				else {
					listofMoves.add(new Move(x.x + nx, x.y));
					break;
				}
			}
			else {
				if(g.board[x.x + nx][x.y] == null) {listofMoves.add(new Move(x.x + nx, x.y));}
				else if(g.board[x.x + nx][x.y] != null && g.board[x.x + nx][x.y].team == false) {break;}
				else {
					listofMoves.add(new Move(x.x + nx, x.y));
					break;
				}
			}
			nx++;
		}
		nx = 1;ny = 1;
		while(x.x - nx >= 0) {
			if(x.team == true) {
				if(g.board[x.x - nx][x.y] == null) {listofMoves.add(new Move(x.x - nx, x.y));}
				else if(g.board[x.x - nx][x.y] != null && g.board[x.x - nx][x.y].team == true) {break;}
				else {
					listofMoves.add(new Move(x.x - nx, x.y));
					break;
				}
			}
			else {
				if(g.board[x.x - nx][x.y] == null) {listofMoves.add(new Move(x.x - nx, x.y));}
				else if(g.board[x.x - nx][x.y] != null && g.board[x.x - nx][x.y].team == false) {break;}
				else {
					listofMoves.add(new Move(x.x - nx, x.y));
					break;
				}
			}
			nx++;
		}
		
		nx = 1; ny = 1;
		while(x.y - ny >= 0) {
			if(x.team == true) {
				if(g.board[x.x][x.y - ny] == null) {listofMoves.add(new Move(x.x, x.y - ny));}
				else if(g.board[x.x][x.y-ny] != null && g.board[x.x][x.y-ny].team == true) {break;}
				else {
					listofMoves.add(new Move(x.x, x.y-ny));
					break;
				}
			}
			else {
				if(g.board[x.x][x.y-ny] == null) {listofMoves.add(new Move(x.x, x.y-ny));}
				else if(g.board[x.x][x.y-ny] != null && g.board[x.x][x.y-ny].team == false) {break;}
				else {
					listofMoves.add(new Move(x.x, x.y-ny));
					break;
				}
			}
			ny++;
		}
		
		nx = 1; ny = 1;
		while(x.y + ny <= 7) {
			if(x.team == true) {
				if(g.board[x.x][x.y + ny] == null) {listofMoves.add(new Move(x.x, x.y + ny));}
				else if(g.board[x.x][x.y + ny] != null && g.board[x.x][x.y + ny].team == true) {break;}
				else {
					listofMoves.add(new Move(x.x, x.y + ny));
					break;
				}
			}
			else {
				if(g.board[x.x][x.y+ny] == null) {listofMoves.add(new Move(x.x, x.y+ny));}
				else if(g.board[x.x][x.y+ny] != null && g.board[x.x][x.y+ny].team == false) {break;}
				else {
					listofMoves.add(new Move(x.x, x.y+ny));
					break;
				}
			}
			ny++;
		}
		

		
		
		return listofMoves;
	}
	public ArrayList<Move> Search(QueenPiece x, game g){
		ArrayList<Move> listofMoves = new ArrayList<Move>();
		int ny = 1;int nx = 1;
		while(x.y + ny <= 7 && x.x + nx <= 7) {
			if(x.team == true) {
				if(g.board[x.x + nx][x.y + ny] == null) {listofMoves.add(new Move(x.x + nx, x.y + ny));}
				else if(g.board[x.x + nx][x.y + ny] != null && g.board[x.x + nx][x.y + ny].team == true) {break;}
				else {
					listofMoves.add(new Move(x.x + nx, x.y + ny));
					break;
				}
			}
			else {
				if(g.board[x.x + nx][x.y + ny] == null) {listofMoves.add(new Move(x.x + nx, x.y + ny));}
				else if(g.board[x.x + nx][x.y + ny] != null && g.board[x.x + nx][x.y + ny].team == false) {break;}
				else {
					listofMoves.add(new Move(x.x + nx, x.y + ny));
					break;
			}
		}
			nx++;ny++;
		}
		
		ny = 1; nx = 1;
		while(x.y - ny >= 0 && x.x - nx >= 0) {
			if(x.team == true) {
				if(g.board[x.x - nx][x.y - ny] == null) {listofMoves.add(new Move(x.x - nx, x.y - ny));}
				else if(g.board[x.x - nx][x.y - ny] != null && g.board[x.x - nx][x.y - ny].team == true) {break;}
				else {
					listofMoves.add(new Move(x.x - nx, x.y - ny));
					break;
				}
			}
			else {
				if(g.board[x.x - nx][x.y - ny] == null) {listofMoves.add(new Move(x.x - nx, x.y - ny));}
				else if(g.board[x.x - nx][x.y - ny] != null && g.board[x.x - nx][x.y - ny].team == false) {break;}
				else {
					listofMoves.add(new Move(x.x - nx, x.y - ny));
					break;
				}
		}
			nx++;ny++;
		}
		
		ny = 1; nx = 1;
		while(x.y + ny <= 7 && x.x - nx >= 0) {
			if(x.team == true) {
				if(g.board[x.x - nx][x.y + ny] == null) {listofMoves.add(new Move(x.x - nx, x.y + ny));}
				else if(g.board[x.x - nx][x.y + ny] != null && g.board[x.x - nx][x.y + ny].team == true) {break;}
				else {
					listofMoves.add(new Move(x.x - nx, x.y + ny));
					break;
				}
			}
			else {
				if(g.board[x.x - nx][x.y + ny] == null) {listofMoves.add(new Move(x.x - nx, x.y + ny));}
				else if(g.board[x.x - nx][x.y + ny] != null && g.board[x.x - nx][x.y + ny].team == false) {break;}
				else {
					listofMoves.add(new Move(x.x - nx, x.y + ny));
					break;
				}
		}
			nx++;ny++;
		}
		
		ny = 1; nx = 1;
		while(x.y - ny >= 0 && x.x + nx <= 7) {
			if(x.team == true) {
				if(g.board[x.x + nx][x.y - ny] == null) {listofMoves.add(new Move(x.x + nx, x.y - ny));}
				else if(g.board[x.x + nx][x.y - ny] != null && g.board[x.x + nx][x.y - ny].team == true) {break;}
				else {
					listofMoves.add(new Move(x.x + nx, x.y - ny));
					break;
				}
			}
			else {
				if(g.board[x.x + nx][x.y - ny] == null) {listofMoves.add(new Move(x.x + nx, x.y - ny));}
				else if(g.board[x.x + nx][x.y - ny] != null && g.board[x.x + nx][x.y - ny].team == false) {break;}
				else {
					listofMoves.add(new Move(x.x + nx, x.y - ny));
					break;
				}
		}
			nx++;ny++;
		}
		
		nx = 1; ny = 1;
		while(x.x + nx <= 7) {
			if(x.team == true) {
				if(g.board[x.x + nx][x.y] == null) {listofMoves.add(new Move(x.x + nx, x.y));}
				else if(g.board[x.x + nx][x.y] != null && g.board[x.x + nx][x.y].team == true) {break;}
				else {
					listofMoves.add(new Move(x.x + nx, x.y));
					break;
				}
			}
			else {
				if(g.board[x.x + nx][x.y] == null) {listofMoves.add(new Move(x.x + nx, x.y));}
				else if(g.board[x.x + nx][x.y] != null && g.board[x.x + nx][x.y].team == false) {break;}
				else {
					listofMoves.add(new Move(x.x + nx, x.y));
					break;
				}
			}
			nx++;
		}
		nx = 1;ny = 1;
		while(x.x - nx >= 0) {
			if(x.team == true) {
				if(g.board[x.x - nx][x.y] == null) {listofMoves.add(new Move(x.x - nx, x.y));}
				else if(g.board[x.x - nx][x.y] != null && g.board[x.x - nx][x.y].team == true) {break;}
				else {
					listofMoves.add(new Move(x.x - nx, x.y));
					break;
				}
			}
			else {
				if(g.board[x.x - nx][x.y] == null) {listofMoves.add(new Move(x.x - nx, x.y));}
				else if(g.board[x.x - nx][x.y] != null && g.board[x.x - nx][x.y].team == false) {break;}
				else {
					listofMoves.add(new Move(x.x - nx, x.y));
					break;
				}
			}
			nx++;
		}
		
		nx = 1; ny = 1;
		while(x.y - ny >= 0) {
			if(x.team == true) {
				if(g.board[x.x][x.y - ny] == null) {listofMoves.add(new Move(x.x, x.y - ny));}
				else if(g.board[x.x][x.y-ny] != null && g.board[x.x][x.y-ny].team == true) {break;}
				else {
					listofMoves.add(new Move(x.x, x.y-ny));
					break;
				}
			}
			else {
				if(g.board[x.x][x.y-ny] == null) {listofMoves.add(new Move(x.x, x.y-ny));}
				else if(g.board[x.x][x.y-ny] != null && g.board[x.x][x.y-ny].team == false) {break;}
				else {
					listofMoves.add(new Move(x.x, x.y-ny));
					break;
				}
			}
			ny++;
		}
		
		nx = 1; ny = 1;
		while(x.y + ny <= 7) {
			if(x.team == true) {
				if(g.board[x.x][x.y + ny] == null) {listofMoves.add(new Move(x.x, x.y + ny));}
				else if(g.board[x.x][x.y + ny] != null && g.board[x.x][x.y + ny].team == true) {break;}
				else {
					listofMoves.add(new Move(x.x, x.y + ny));
					break;
				}
			}
			else {
				if(g.board[x.x][x.y+ny] == null) {listofMoves.add(new Move(x.x, x.y+ny));}
				else if(g.board[x.x][x.y+ny] != null && g.board[x.x][x.y+ny].team == false) {break;}
				else {
					listofMoves.add(new Move(x.x, x.y+ny));
					break;
				}
			}
			ny++;
		}
		
		return listofMoves;
	}
	public ArrayList<Move> Search(KingPiece x, game g){
		ArrayList<Move> listofMoves = new ArrayList<Move>();
		if(x.team == true) {
		if(x.x-1 >= 0)  if(x.y-1 >= 0 && g.board[x.x-1][x.y-1] == null || g.board[x.x-1][x.y-1].team == false) {listofMoves.add(new Move(x.x-1, x.y-1));}
		if(x.y-1 >= 0)  if(g.board[x.x][x.y-1] == null || g.board[x.x][x.y-1].team == false) {listofMoves.add(new Move(x.x, x.y-1));}
		if(x.x+1 <= 7)  if(x.y-1 >= 0 && g.board[x.x+1][x.y-1] == null || g.board[x.x+1][x.y-1].team == false) {listofMoves.add(new Move(x.x+1, x.y-1));}
		if(x.x-1 >= 0)  if(x.y+1 <= 7 && g.board[x.x-1][x.y+1] == null || g.board[x.x-1][x.y+1].team == false) {listofMoves.add(new Move(x.x-1, x.y+1));}
		if(x.y+1 <= 7)  if(g.board[x.x][x.y+1] == null || g.board[x.x][x.y+1].team == false) {listofMoves.add(new Move(x.x, x.y+1));}
		if(x.x+1 <= 7)  if(x.y+1 <= 7 && g.board[x.x+1][x.y+1] == null || g.board[x.x+1][x.y+1].team == false) {listofMoves.add(new Move(x.x+1, x.y+1));}
		if(x.x-1 >= 0)  if(g.board[x.x-1][x.y] == null || g.board[x.x-1][x.y].team == false) {listofMoves.add(new Move(x.x-1, x.y));}
		if(x.x+1 <= 7)  if(g.board[x.x+1][x.y] == null || g.board[x.x+1][x.y].team == false) {listofMoves.add(new Move(x.x+1, x.y));}
		}
		else {
			if(x.x-1 >= 0)  if(x.y-1 >= 0 && g.board[x.x-1][x.y-1] == null || g.board[x.x-1][x.y-1].team == true) {listofMoves.add(new Move(x.x-1, x.y-1));}
			if(x.y-1 >= 0)  if(g.board[x.x][x.y-1] == null || g.board[x.x][x.y-1].team == true) {listofMoves.add(new Move(x.x, x.y-1));}
			if(x.x+1 <= 7)  if(x.y-1 >= 0 && g.board[x.x+1][x.y-1] == null || g.board[x.x+1][x.y-1].team == true) {listofMoves.add(new Move(x.x+1, x.y-1));}
			if(x.x-1 >= 0)  if(x.y+1 <= 7 && g.board[x.x-1][x.y+1] == null || g.board[x.x-1][x.y+1].team == true) {listofMoves.add(new Move(x.x-1, x.y+1));}
			if(x.y+1 <= 7)  if(g.board[x.x][x.y+1] == null || g.board[x.x][x.y+1].team == true) {listofMoves.add(new Move(x.x, x.y+1));}
			if(x.x+1 <= 7)  if(x.y+1 <= 7 && g.board[x.x+1][x.y+1] == null || g.board[x.x+1][x.y+1].team == true) {listofMoves.add(new Move(x.x+1, x.y+1));}
			if(x.x-1 >= 0)  if(g.board[x.x-1][x.y] == null || g.board[x.x-1][x.y].team == true) {listofMoves.add(new Move(x.x-1, x.y));}
			if(x.x+1 <= 7)  if(g.board[x.x+1][x.y] == null || g.board[x.x+1][x.y].team == true) {listofMoves.add(new Move(x.x+1, x.y));}
		}
		return listofMoves;
	}







	public void Search(Piece piece, game g) {
		
	}


}
