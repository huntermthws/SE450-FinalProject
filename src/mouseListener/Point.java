package mouseListener;

public class Point
{
	//Need to make private and switch to setters
	public int x;
	public int y;
	
	//Default Constructor
	public Point() {
        this.x=0;
        this.y=0;
    }
	
	//Constructor with X and Y passed
	public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
	
	//Setters for X and Y
	public void setX(int x) {this.x = x;}
	public void setY(int y) {this.y = y;}
	
	//Getters for X and Y
	public int getX() { return x;}
	public int getY() { return y;}
}
