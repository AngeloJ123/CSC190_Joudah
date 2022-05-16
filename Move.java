package application;

public class Move {
	int x, y;
	public Move(int gx, int gy) {
		x = gx;
		y = gy;
	}
	protected boolean compareTo(Move t) {
		if(this.x == t.x && this.y == t.y) {
			return true;
		}
		return false;
	}
}
