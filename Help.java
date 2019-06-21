package geometry;

import java.util.Scanner;

public class Help {
	public static Scanner sc=new Scanner(System.in);
	public static final double EPSILON = 1.0e-4;
	public static boolean equal(double x,double y) {
		if(Math.abs(x-y)<EPSILON) return true;
		else return false;
	}
	public static double quad(double x) {
		return x*x;
	}
	public static double signum(double x) {
		if(x>Help.EPSILON) return 1;
		else if(x<Help.EPSILON) return -1;
		else return 0;
	}
}
