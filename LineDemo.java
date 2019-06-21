package geometry;

public class LineDemo {
	public static void main(String[] args) {
		Line line1, line2, line3, line4;
		line1=new Line();
		Point t1=new Point(0,0),
				t2=new Point(2.3,3.4);
		line2=new Line(t1,t2);
		line3=new Line();
		System.out.println();
		System.out.println("Input for object 3: ");;
		line3.input();
		line4=new Line(line3);
		System.out.println();
		System.out.println("Output for object 1: ");
		line1.output();
		System.out.println();
		System.out.println("Output for object 2: ");
		line2.output();
		System.out.println();
		System.out.println("Output for object 3: ");
		line3.output();
		System.out.println();
		System.out.println("Output for object 4: ");
		line4.output();
		Point z1=new Point(2,3), z2=new Point(5,6);
		double dist=Line.distance(z1, z2);
		double slo=Line.slope(z1, z2);
		System.out.println("The distance between the points " 
		+ z1 + " and " + z2 + " is " +dist);
		System.out.println("The slope of the line, defined by the points is: " + slo);
		
	}
}
