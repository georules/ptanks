import java.util.ArrayList;


public class GameBoard {
	
	int x, y, size;
	
	Tile[] tiles;
	
	public GameBoard() {
		this(10);
	}
	public GameBoard(int l) {
		this(l,l);
	}
	public GameBoard(int x, int y) {
		this.x = x; this.y = y;
		this.size = this.x * this.y;
		tiles = new Tile[this.size];
	}
	
	private int translate(int x, int y) {
		return this.x * x + y;
	}
	
	private void fix_positions(ArrayList<Movable> objects)	{
		for (Movable m : objects) {
			Vec2D v = m.getVec();
			if (v.x > this.x) {
				v.x = this.x;
			}
			if (v.y > this.y) {
				v.y = this.y;
			}
		}
		
	}
	
	public String toString()	{
		String s = "";
		for(int i = 0; i < x; i++) {
			s += "| ";
			for(int j = 0; j < y; j++) {
				Object o;
				int p = this.translate(i, j);
				o = tiles[p];
				s += o + " | ";
			}
			s += "\n";
		}
		return s;
	}
}
