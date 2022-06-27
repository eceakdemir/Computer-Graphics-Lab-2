package lab_2_exercises;

public class CircleLineIntersection {
	public CircleLineIntersection() {
		
	}
	public boolean intersects(float x, float y, float r, float a, float b) {
		float B = 2*a*(b - y) - 2*x;
		float A = a*a + 1;
		float C = (b - y)*(b - y) + x*x - r*r;
		return (B*B - 4*A*C >= 0);
	}

}
