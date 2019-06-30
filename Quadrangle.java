package geometry;

public class Quadrangle {
	protected int numEdges = 4;
	protected Point[] angles;
	protected double[] sides;

	public Quadrangle() {
		angles = new Point[numEdges];
		angles[0] = new Point(0, 0);
		angles[1] = new Point(0, 1);
		angles[2] = new Point(1, 0);
		angles[3] = new Point(1, 1);
	}

	public Quadrangle(Point[] angle) {
		angles = new Point[numEdges];
		sides = new double[numEdges];
		for (int i = 0; i < angle.length; i++) {
			angles[i] = new Point(angle[i]);
		}
	}

	public Quadrangle(Quadrangle quad) {
		angles = new Point[numEdges];
		sides = new double[numEdges];
		for (int i = 0; i < quad.angles.length; i++) {
			angles[i] = new Point(quad.angles[i]);
		}
		for (int i = 0; i < quad.sides.length; i++) {
			this.sides[i] = quad.sides[i];
		}
		sideCalc();
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
		Point p1 = angles[0], p2 = angles[1], p3 = angles[2], p4 = angles[3];
		if (Help.equal(p1.x, p2.x) && Help.equal(p1.y, p2.y)) {
			return 1;
		} else if (Math.abs(Triangle.area(p1, p2, p3)) < Help.EPSILON) {
			return 2;
		} else {
			double ar1, ar2, ar3;
			ar1 = Triangle.area(p1, p2, p4);
			ar2 = Triangle.area(p1, p3, p4);
			ar3 = Triangle.area(p2, p3, p4);
			if ((Help.signum(ar1) != Help.signum(ar2)) || (Help.signum(ar1) != Help.signum(ar3))
					|| (Help.signum(ar2) != Help.signum(ar3)))
				return 3;
			else
				return 0;
		}
	}

	public void input() {
		do {
			System.out.println("Input for quadrangle: ");
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
		Point[] tr1p = { angles[0], angles[1], angles[3] };
		Point[] tr2p = { angles[1], angles[2], angles[3] };
		Triangle tr1 = new Triangle(tr1p), tr2 = new Triangle(tr2p);
		return tr1.area() + tr2.area();
	}

	public String type() {
		Line l1 = new Line(angles[0], angles[1]);
		Line l2 = new Line(angles[2], angles[3]);
		Line l3 = new Line(angles[0], angles[3]);
		Line l4 = new Line(angles[2], angles[1]);
		if ((l1.slope() == 0 && l2.slope() == 0) || (l3.slope() == 0 && l4.slope() == 0)) {
			return "Trapezoid";
		}
		if ((l1.slope() == 0 && l2.slope() == 0) && (l3.slope() == 0 && l4.slope() == 0)) {
			return "Parallelogram";
		}
		return "Ordinary Quadrangle";
	}
	public boolean equal(Quadrangle q) {
		Triangle t1,t2,t11,t22;
		Point[] p1= {angles[0],angles[1],angles[2]};
		Point[] p2= {angles[3],angles[1],angles[2]};
		Point[] p11= {q.angles[0],q.angles[1],q.angles[2]};
		Point[] p22= {q.angles[3],q.angles[1],q.angles[2]};
		t1=new Triangle(p1);
		t2=new Triangle(p2);
		t11=new Triangle(p11);
		t22=new Triangle(p22);
		if(t1.equal(t11) && t2.equal(t22)) return true;
		return false;
	}

}
