
public class GameObject implements Movable{
	protected Vec2D v;
	public int speed;
	
	public GameObject(Vec2D v) {
		this(v, -1);
	}
	public GameObject(Vec2D v, int speed) {
		putVec(v);
		this.speed = speed;
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
		this.v.x += this.speed * Math.round(xcom);
		this.v.y += this.speed * Math.round(ycom);
	}

	public String toString() {
		return ID.getID(this);
	}
}
