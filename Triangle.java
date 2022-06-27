package lab_2_exercises;

import java.awt.geom.Point2D;

public class Triangle {
	public int x1;
	public int y1;
	public int x2;
	public int y2;
	public int x3;
	public int y3;
	public Triangle(int x1, int y1, int x2, int y2, int x3, int y3) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.x3 = x3;
		this.y3 = y3;
	}
	private float distance(int x1, int y1, int x2, int y2) {
		int diff_x = x1 - x2;
		int diff_y = y1 - y2;
		return (float) Math.sqrt(diff_x*diff_x + diff_y*diff_y);	
		
	}
	private float det(int a, int b, int c, int d) {
		return a*d - b*c;
	}
	public float circumference() {
		float s = distance(x1, y1, x2, y2);
		s += distance(x1, y1, x3, y3);
		s += distance(x2, y2, x3, y3);
		return s;
	}
	//https://math.stackexchange.com/questions/299352/show-that-the-area-of-a-triangle-is-given-by-this-determinant
	public float area() {
		float s = det(x2, x3, y2, y3);
		s -= det(x1, x3, y1, y3);
		s += det(x1, x2, y1, y2);
		return s/2.0f;
		
	}
	public boolean contains(int x, int y) {
		Triangle tri_0 = new Triangle(x, y, x1, y1, x2, y2);
		Triangle tri_1 = new Triangle(x, y, x2, y2, x3, y3);
		Triangle tri_2 = new Triangle(x, y, x1, y1, x3, y3);
		return (tri_0.area() + tri_1.area() + tri_2.area() == this.area());
	}
	public Point2D.Float[] vertices() {
		Point2D.Float point_0 = new Point2D.Float(x1, y1);
		Point2D.Float point_1 = new Point2D.Float(x2, y2);
		Point2D.Float point_2 = new Point2D.Float(x3, y3);
		Point2D.Float[] points = {point_0, point_1, point_2};
		return points;
		
		
	}
	public boolean isEqualTo(Triangle other) {
		Point2D.Float[] other_vertices = other.vertices();
		Point2D.Float[] vertices = vertices();
		boolean is_equal = true;
		for(int i = 0; i < vertices.length; i++) {
			
			if(!vertices[i].equals(other_vertices[i])) {
				is_equal = false;
				break;
			}
		}
			
		return is_equal;
	}
	Point2D.Float centerOfMass() {
		float x = (x1 + x2 + x3)/3.0f;
		float y = (y1 + y2 + y3)/3.0f;
		return new Point2D.Float(x, y);
	}
	
	 private float sideToAngle(float a, float b, float c) {
		 return (float) Math.acos((double)(a*a + b*b - c*c)/(2*a*b));
	 }
	 public float angle(int idx) {
		float a = distance(x2, y2, x3, y3);
		float b = distance(x1, y1, x3, y3);
		float c = distance(x1, y1, x2, y2);
		float ret_val = 0.0f;
		if(idx == 0) 
			ret_val = sideToAngle(b, c, a);
		else if(idx == 1) 
			ret_val = sideToAngle(a, c, b);
		else if(idx == 2) 
			ret_val = sideToAngle(a, b, c);
		return ret_val;
	 }
	
	

}
