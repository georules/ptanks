
public class Vec2D implements Cloneable {
	
	public int x;
	public int y;
	public int direction;
	
	public Vec2D(int x, int y) {
		this.x = x; this.y = y;
	}
	public Vec2D(int x, int y, int direction) {
		this(x,y);
		this.direction = direction;
	}
	
	public Object clone()	{
		try{
			return super.clone();
		}
		catch(CloneNotSupportedException e) {
			throw new InternalError(e.toString());
		}
		
	}

}
