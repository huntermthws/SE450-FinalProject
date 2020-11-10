package model.interfaces;

import java.awt.Color;

import model.ShapeShadingType;
import model.ShapeType;
import mouseListener.Point;

public interface IShape {
	public Point getStart();
	public Point getEnd();
	public Color getColor();
	public Color getOutline();
	public int[] getXPoints();
	public int[] getYPoints();
	public int getMaxX();
	public int getMinX();
	public int getMaxY();
	public int getMinY();
	public int getHeight();
	public int getWidth();
	public ShapeType getShape();
	public ShapeShadingType getShading();
	public boolean checkCollision(Point selectedStart, Point selectedEnd);
	public void moveCoodinates(int x, int y);
	public void removeCoodinates(int x, int y);
}
