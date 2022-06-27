package lab_2_exercises;

import java.awt.geom.Point2D;

public class Square {
	private int x;
	private int y;
	private int width;
	public Square(int x, int y, int width) {
		 this.x = x;
		 this.y = y;
		 this.width = width;
	 }
	 public Square(int width) {
		 x = 0;
		 y = 0;
		 this.width = width;
	}
	 public int getX() {
		 return x;

	 }
	 // returns left-bottom corner's y coordinate
	 public int getY() {
		 return y;
	 }
	 // returns width of the rectangle
	 public int getWidth() {
		 return width;
	 }	 
	 
	 public void reshape(int x, int y, int width) {
		 this.x = x;
		 this.y = y;
		 this.width = width;
	 }
	 public void resize(int width) {
		 this.width = width;
	 }	
	 public void setLocation(int px, int py) {
		 x = px;
		 y = py;
	 }

	 // prints the coordinates of the left-bottom corner's coordinates (x,y)
	 public void printLocation() {
		 printCoord(x, y);
		 
	 }	
	 private void printCoord(int px, int py) {
		 System.out.print("(");
		 System.out.print(px);
		 System.out.print(", ");
		 System.out.print(py);
		 System.out.print(")");
		 
	 }
	 public void printCoordinates() {
		 System.out.print("Left-Bottom: ");
		 printCoord(x, y);
		 System.out.print("\nLeft-Top: ");
		 printCoord(x, y + width);
		 System.out.print("\nRight-Top: ");
		 printCoord(x + width, y + width);
		 System.out.print("\nRight-Bottom: ");
		 printCoord(x + width, y);
		 System.out.println("");
		 
	 }
	 public void translate(int dx, int dy) {
		 x += dx;
		 y += dy;
	 }
	 // rotates the rectangle 90 degrees clockwise around its left-bottom corner
	 public void rotateClockwise() {
		 y -= width;
		 
	 }
	 // rotates the rectangle 90 degrees counter-clockwise around its left-bottom corner
	 public void rotateCounterClockwise() {
		 x -= width;
	 }
	 public boolean contains(int x, int y) {
		 boolean ret_val;
		 if(x >= this.x && x < this.x + width && y > this.y && y < this.y + width)
			 ret_val = true;
		 else
			 ret_val = false;
		 return ret_val;
	 }	 
	 public int circumference() {
		 return 4*width;
	 }
	 public int area() {
		 return width*width;
	 }
	 public boolean isEqualTo(Square other) {
		 return (x == other.getX() && y == other.getY() && width == other.getWidth());
	 }
	 public Point2D.Float center() {
		 Point2D.Float point = new Point2D.Float(x + width/2, y + width/2);
		 return point;
	 }
	 public boolean contains(Square other) {
		 Point2D.Float point_lb = new Point2D.Float(other.getX(), other.getY());
		 Point2D.Float point_rb = new Point2D.Float(other.getX() + other.getWidth(), other.getY());
		 Point2D.Float point_rt = new Point2D.Float(other.getX() + other.getWidth(), other.getY() + other.getWidth());
		 Point2D.Float point_lt = new Point2D.Float(other.getX(), other.getY() + other.getWidth());
		 return contains((int)point_lb.x, (int) point_lb.y) && contains( (int)point_rb.x, (int) point_rb.y) && 
				 contains((int) point_rt.x, (int) point_rt.y) && contains((int) point_lt.x, (int) point_lt.y); 
		 
	 }

	 
	
	

}
