package graph;

public class Vector {
	
	private Point p1, p2;
	
	public Vector (Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;
	}
	
	public void add(Vector v) {
		setP2(new Point(getDifferenceX() + v.getDifferenceX(), getDifferenceY() + v.getDifferenceY()));
	}
	
	public void multiply(double f) {
		setP2(new Point(getP1().getX() + f * getDifferenceX(), getP1().getY() + f * getDifferenceY()));
	}
	
	public double getDifferenceX() {
		return getP1().getX() - getP2().getX();
	}
	
	public double getDifferenceY() {
		return getP1().getY() - getP2().getY();
	}
	
	public static Vector add(Vector v1, Vector v2) {
		v1.add(v2);
		return v1;
	}
	
	public boolean isSimilar(Vector v) {
		if (getP1() == v.getP1() || getP1() == v.getP2() || getP2() == v.getP1() || getP2() == v.getP2()) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean contains(Point p) {
		return (getP1() == p || getP2() == p ? true : false);
	}

	public Point getP1() {
		return p1;
	}

	public void setP1(Point p1) {
		this.p1 = p1;
	}

	public Point getP2() {
		return p2;
	}

	public void setP2(Point p2) {
		this.p2 = p2;
	}
	
	public String toString() {
		return "[(" + getP1().getX() + "," + getP1().getY() + "),(" + getP2().getX() + "," + getP2().getY() + ")]";
	}

}
