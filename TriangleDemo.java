package geometry;

public class TriangleDemo {
	public static void main(String[] args) {
		Triangle tr1, tr2, tr3, tr4;
		tr1 = new Triangle();
		Point[] points = new Point[3];
		points[0] = new Point(2, 0);
		points[1] = new Point(3, 0);
		points[2] = new Point(4, 1);
		tr2=new Triangle(points);
		tr3=new Triangle();
		System.out.println("Input for triangle: ");
		tr3.input();
		tr4=new Triangle(tr3);
		System.out.println("Output for onject 1: ");
		tr1.output();
		System.out.println("Output for onject 2: ");
		tr2.output();
		System.out.println("Output for onject 3: ");
		tr3.output();
		System.out.println("Output for onject 4: ");
		tr4.output();
	}

}
