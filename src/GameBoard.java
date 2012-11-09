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
		for (int i = 0; i < size; i++) {
			tiles[i] = new Tile();
		}
	}
	
	private int translate(int x, int y) {
		return this.x * x + y;
	}
	
	public void clear_board() {
		for (int i = 0; i < tiles.length; i++) {
			tiles[i] = new Tile();
		}
	}
	
	public void placeObjects(ArrayList<GameObject> objects) {
		clear_board();
		fix_positions(objects);
		for (GameObject o : objects) {
			int p = this.translate(o.v.x, o.v.y);
			tiles[p] = new Tile(o.getID());
		}
	}
	
	private void fix_positions(ArrayList<? extends Movable> objects)	{
		for (Movable m : objects) {
			Vec2D v = m.getVec();
			if (v.x >= this.x) {
				v.x = this.x-1;
			}
			if (v.y >= this.y) {
				v.y = this.y-1;
			}
			if(v.x < 0) {
				v.x = 0;
			}
			if(v.y < 0) {
				v.y = 0;
			}
		}
		
	}
	
	public String toString()	{
		String s = "";
		for(int i = 0; i < x; i++) {
			s += "| ";
			for(int j = 0; j < y; j++) {
				int p = this.translate(i, j);
				s += tiles[p].toString() + " | ";
			}
			s += "\n";
		}
		return s;
	}

}
