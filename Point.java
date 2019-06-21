package geometry;

public class Point {
	protected double x, y;
	//protected - available to classes of this package
	//constructors - have same name as class
	//creates new instances of the class, objects
	public Point() {
		x=0;
		y=0;
	}
	public Point(double xN,double yN) {
		x=xN;
		y=yN;
	}
	public Point(Point d) {
		x=d.x; //d.x - the x-variable of object d
		y=d.y;
	}
	//methods
	public void input() {
		//input for the attributes of an object with attributes x and y, point coordinates
		//therefore not static - works with the attributes of the object
		System.out.println("Points x-coordinate: ");
		x=Help.sc.nextDouble();
		System.out.println("Points y-coordinate: ");
		y=Help.sc.nextDouble();
		//scan variable defined in Help class
	}
	// move method
	public void move(double delx, double dely) { // parameters are x2-x1 y2-y1
		x+=delx;
		y+=dely;
	}
	public Point moveNew(double delx,double dely) {
		//create a new object from an existing one
		double xp=x+delx;
		double yp=y+dely;
		return new Point(xp,yp);
	}
	public boolean equal(Point p) {
		if(Help.equal(this.x,p.x)&&Help.equal(this.y,p.y)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String toString() {
		//gives out information about object
		return "(" + x + "," + y + ")";
	}
	
	public void output() {
		//output info about object
		System.out.println(this);
		
	}
}
