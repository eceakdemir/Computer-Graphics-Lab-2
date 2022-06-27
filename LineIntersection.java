package lab_2_exercises;

import java.awt.geom.Point2D;

public class LineIntersection {
	public LineIntersection() {
		
	}
	public Point2D.Float find(int a, int b, int a1, int b1){
		Point2D.Float ret_val = null;
		if(a != a1) {
			float x = ((float) b1 - b)/(a - a1);
			float y = a*x + b;
			ret_val = new Point2D.Float(x, y);
		}
		return ret_val;
		
	}

}
