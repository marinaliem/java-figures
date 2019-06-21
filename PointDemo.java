package geometry;
public class PointDemo {
	public static void main(String[] args) {
		Point p1,p2,p3,p4,p5,p6;
		p1=new Point();
		p2=new Point(2.5,2.5);
		p3=new Point();
		System.out.println("Input for point 3: ");
		p3.input();
		p4=new Point(p3);
		p5=p2.moveNew(1, 1);
		p6=p2;
		System.out.println("Object 1: ");
		p1.output();
		System.out.println("Object 2: ");
		p2.output();
		System.out.println("Object 3: ");
		p3.output();
		System.out.println("Object 4: ");
		p4.output();
		System.out.println("Object 5: ");
		p5.output();
		System.out.println("Object 6: ");
		p6.output();
	}
}
