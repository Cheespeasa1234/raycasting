import java.awt.Point;

public class Line {
	public Point a,b;
	public Line(Point a, int length, int angle) {
		this.a=a;
		int A = (int) (angle*Math.PI/180);
		Point p = new Point(0,0);
		p.x = (int) (a.x+length * Math.cos(A));
		p.y = (int) (a.y+length * Math.sin(A));
		this.b = p;
	}
	
	public void setB(int length, int angle) {
		int A = (int) (angle*Math.PI/180);
		Point p = new Point(0,0);
		p.x = (int) (a.x+length * Math.cos(A));
		p.y = (int) (a.y+length * Math.sin(A));
		this.b = p;
	}
}
