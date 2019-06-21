package geometry;

public class Line {
	protected Point p1, p2;

	public Line() {
		p1 = new Point(0, 0);
		p2 = new Point(1, 1);
	}

	public Line(Point t1, Point t2) {
		p1 = new Point(t1);
		p2 = new Point(t2);
	}

	public Line(Line l) {
		p1 = new Point(l.p1);
		p2 = new Point(l.p2);
	}

	public int check() {
		if (p1.equal(p2))
			return 1;
		else
			return 0;
	}

	public void input() {
		do {
			p1.input();
			p2.input();
			if (check() == 1) {
				System.out.println("The points are the same. Please set new values.");
			}
		} while (check() > 0);
	}

	public String toString() {
		return "Line, defined by: (" + p1 + ", " + p2 + ")";
	}

	public void output() {
		System.out.println("Line: " + this);
		System.out.println("Distance: " + distance());
		System.out.println("Slope: " + slope());
	}

	public double distance() {
		double dist = Math.sqrt(Help.quad(p2.x - p1.x) * Help.quad(p2.y - p1.y));
		return dist;
	}

	public double slope() {
		double s, delx = p2.x - p1.x;
		if (Math.abs(delx) > Help.EPSILON) {
			s = (p2.y - p1.y) / (delx);
		} else {
			s = 1e8;
		}
		return s;
	}

	public static double distance(Point t1, Point t2) {
		double dist1 = Math.sqrt(Help.quad(t2.x - t1.x) * Help.quad(t2.y - t1.y));
		return dist1;
	}

	public static double slope(Point t1, Point t2) {
		double s, delx = t2.x - t1.x;
		if (Math.abs(delx) > Help.EPSILON) {
			s = (t2.y - t1.y) / (delx);
		} else {
			s = 1e8;
		}
		return s;
	}
	
}
