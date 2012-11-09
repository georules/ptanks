
public class GameObject implements Movable, ID {
	protected Vec2D v;
	protected long id;
	
	public GameObject(Vec2D v) {
		this(v, -1);
	}
	public GameObject(Vec2D v, long id) {
		putVec(v);
		setID(id);
	}

	public void putVec(Vec2D in) {
		this.v = in;
	}

	public Vec2D getVec() {
		return v;
	}

	public void move() {
		double radians = 1.0 * this.v.direction * Math.PI / 180.0;
		double ycom = Math.cos(radians);
		double xcom = Math.sin(radians);
		System.out.println(xcom + " " +ycom);
		this.v.x += this.v.speed * Math.round(xcom);
		this.v.y += this.v.speed * Math.round(ycom);
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
