package geometry;

public class Triangle {
	protected int numEdges = 3;
	protected Point[] angles;
	protected double[] sides;

	public Triangle() {
		angles = new Point[numEdges];
		sides = new double[numEdges];
		angles[0] = new Point(0, 0);
		angles[1] = new Point(0, 1);
		angles[2] = new Point(1, 0);
		sideCalc();
	}

	public Triangle(Point[] angle) {
		angles = new Point[numEdges];
		sides = new double[numEdges];
		for (int i = 0; i < angle.length; i++) {
			angles[i] = new Point(angle[i]);
		}
	}

	public Triangle(Triangle tr) {
		int newAngleLen = tr.angles.length, newSideLen = tr.sides.length;
		for (int i = 0; i < newAngleLen; i++) {
			this.angles[i] = new Point(tr.angles[i]);
		}
		for (int i = 0; i < newSideLen; i++) {
			this.sides[i] = tr.sides[i];
		}
	}

	public void sideCalc() {
		int i, j;
		int len = angles.length;
		for (i = 0; i < len; i++) {
			if (i < len - 1) {
				j = i + 1;
			} else {
				j = 0;
			}
			sides[i] = Line.distance(angles[i], angles[j]);
		}

	}

	public int check() {
		Point p1 = angles[0], p2 = angles[1], p3 = angles[2];
		if (p1.equal(p2)) {
			return 1;
			/*
			 * } else if (Math.abs(area(p1, p2, p3)) < 0) { return 2;
			 */
		} else {
			return 0;
		}
	}

	public void input() {
		do {
			System.out.println("Input for triangle: ");
			for (int i = 0; i < angles.length; i++) {
				System.out.println("coordinates for Point: " + (i + 1));
				angles[i].input();
			}
			if (check() > 0) {
				System.out.println("Wrong point: " + check());
			}
		} while (check() > 0);
		sideCalc();
	}

	public double circumference() {
		double cir = 0;
		for (int i = 0; i < sides.length; i++) {
			cir += sides[i];
		}
		return cir;
	}

	public double area() {
		double a = sides[0], b = sides[1], c = sides[2];
		double p = (a + b + c) / 2;
		return Math.sqrt(p * (p - a) * (p - b) * (p - c));
	}

	public static double area(Point t1, Point t2, Point t3) {
		double det = t1.x * (t2.y - t3.y) + t2.x * (t3.y - t1.y) + t3.x * (t1.y - t2.y);
		return 0.5 * det;
	}

	public String type() {
		String s;
		double a = sides[0], b = sides[1], c = sides[2];
		if (Help.equal(a, b) && Help.equal(b, c)) {
			s = "equilateral";
		} else if ((Help.equal(a, b) && Help.equal(b, c) == false) || (Help.equal(b, c) && Help.equal(b, a) == false)
				|| (Help.equal(a, c) && Help.equal(b, c) == false)) {
			s = "isosceles";
		} else {
			s = "versatile";
		}
		if (Help.equal(maxAngle(), Math.PI / 2)) {
			s = s + " rectangular";
		} else if (maxAngle() < Math.PI / 2) {
			s = s + " acute-angled";
		} else {
			s = s + " obtuse-angled";
		}
		return s;
	}

	public boolean equal(Triangle t) {
		double a1 = sides[0];
		double b1 = sides[1];
		double c1 = sides[2];
		double a2 = t.sides[0], b2 = t.sides[1], c2 = t.sides[2];
		if (Help.equal(a1, a2) && Help.equal(b1, b2) && Help.equal(c1, c2)) {
			return true;
		} else {
			return false;

		}
	}

	public static double angle(double a, double b, double c) {
		return Math.acos((b * b + c * c - a * a) / 2 * b * c);
	}

	double maxAngle() {
		double alfa = angle(sides[0], sides[1], sides[2]);
		double beta = angle(sides[1], sides[2], sides[0]);
		double gama = angle(sides[2], sides[0], sides[1]);
		if (alfa > beta && alfa > gama)
			return alfa;
		if (beta > alfa && beta > gama)
			return beta;
		return gama;
	}

	public String toString() {
		return "Triangle with: " + angles[0] + "-" + angles[1] + "-" + angles[2];
	}

	public void output() {
		System.out.println(toString());
		System.out.println("Circumference: " + circumference());
		System.out.println("Area: " + area());
		System.out.println("Type " + type());
	}
}
