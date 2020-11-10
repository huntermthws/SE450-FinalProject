package model;

import java.awt.Color;
import java.util.ArrayList;

import model.interfaces.IShape;
import mouseListener.Point;

public class ShapeGroup implements IShape{

	private ArrayList<IShape> groupedShapes = new ArrayList<>();
	
	public ShapeGroup(ArrayList<IShape> selectedShapes)
	{
		this.groupedShapes = selectedShapes;
	}
	@Override
	public Point getStart() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Point getEnd() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Color getOutline() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] getXPoints() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] getYPoints() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getMaxX() {
		int maxX = 0;
		for(IShape shape : groupedShapes)
		{
			maxX = shape.getMaxX();
		}
		return maxX;
	}

	@Override
	public int getMinX() {
		int minX = 0;
		for(IShape shape : groupedShapes)
		{
			minX = shape.getMinX();
		}
		return minX;
	}

	@Override
	public int getMaxY() {
		int maxY = 0;
		for(IShape shape : groupedShapes)
		{
			maxY = shape.getMaxY();
		}
		return maxY;
	}

	@Override
	public int getMinY() {
		int minY = 0;
		for(IShape shape : groupedShapes)
		{
			minY = shape.getMinX();
		}
		return minY;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ShapeType getShape() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShapeShadingType getShading() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkCollision(Point selectedStart, Point selectedEnd) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void moveCoodinates(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeCoodinates(int x, int y) {
		// TODO Auto-generated method stub
		
	}
	
	public void add(IShape shape)
	{
		groupedShapes.add(shape);
	}
	
	public ArrayList<IShape> getShapes()
	{
		return groupedShapes;
	}

}
