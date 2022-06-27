package lab_2_exercises;

import java.awt.geom.Point2D;

public class Circle {
	private int x;
	private int y;
	private int radius;
	public Circle(int x, int y, int radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	public void setCenter(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	public int getRadius() {
		return radius;
	}
	
	public boolean contains(int x, int y) {
		int diff_0 = x - this.x;
		int diff_1 = y - this.y;
		return ((diff_0*diff_0 + diff_1*diff_1) <= radius*radius);
	}
	public Square enclosingSquare() {
		int x = this.x - radius;
		int y = this.y - radius;
		return new Square(x, y, 2*radius);
	}

}
