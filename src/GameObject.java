
public class GameObject implements Movable, ID {
	protected Vec2D v;
	protected long id;
	
	public GameObject(Vec2D v) {
		this.v = v;
	}

	public void putVec(Vec2D in) {
		
	}

	public Vec2D getVec() {
		return v;
	}

	public void move() {

	}
	
	
	public long getID() {
		return id;
	}

	public void setID(long id) {
		this.id = id;
	}

	public String toString() {
		Long l = new Long(id);
		return l.toString();
	}
}
