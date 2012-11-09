
public class Vec2D implements Cloneable {
	
	public int x;
	public int y;
	public int direction;
	public int speed;
	
	public Vec2D(int x, int y) {
		this.x = x; this.y = y;
	}
	public Vec2D(int x, int y, int direction, int speed) {
		this(x,y);
		this.direction = direction;
		this.speed = speed;
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
