package model;

import java.awt.Color;
import java.util.ArrayList;

import model.interfaces.IShape;
import mouseListener.Point;

public class ShapeGroup implements IShape{

	public ArrayList<IShape> groupedShapes;
	public int maxX, minX = -1, minY = -1, maxY, width, height;
	
	public ShapeGroup()
	{
		this.groupedShapes = new ArrayList<IShape>();
	}
	public ShapeGroup(ArrayList<IShape> selectedShapes)
	{
		this.groupedShapes = selectedShapes;
		
		for(IShape shape : selectedShapes)
		{
			if(shape.getMinX() < minX || minX == -1)
			{
				minX = shape.getMinX();
			}
			if(shape.getMinY() < minY || minY == -1)
			{
				minY = shape.getMinY();
			}
			if(shape.getMaxX() > maxX)
			{
				maxX = shape.getMaxX();
			}
			if(shape.getMaxY() > maxY)
			{
				maxY = shape.getMaxY();
			}
		}
		
		width = maxX - minX;
        height = maxY - minY;
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
	public int getMaxX() {return maxX;}

	@Override
	public int getMinX() {return minX;}

	@Override
	public int getMaxY() {return maxY;}

	@Override
	public int getMinY() {return minY;}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return height;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return width;
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
		int selectMinX = Math.min(selectedStart.getX(), selectedEnd.getX());
		int selectMaxX = Math.max(selectedStart.getX(), selectedEnd.getX());
		int selectMinY = Math.min(selectedStart.getY(), selectedEnd.getY());
		int selectMaxY = Math.max(selectedStart.getY(), selectedEnd.getY());
        
		int selectedWidth = selectMaxX - selectMinX;
        int selectedHeight = selectMaxY - selectMinY;
        
        if(minX < selectMinX + selectedWidth && 
        		minX + width > selectMinX && 
        		minY < selectMinY + selectedHeight && 
        		minY + height > selectMinY)
        {
        	return true;
        }
        else
        {
        	return false;
        }
	}

	@Override
	public void moveCoodinates(int x, int y) {
		// TODO Auto-generated method stub
		minX += x;
		minY += y;
		maxX += x;
		maxY += y;
		for(IShape shape: groupedShapes)
		{
			shape.moveCoodinates(x, y);
		}
	}

	@Override
	public void removeCoodinates(int x, int y) {
		// TODO Auto-generated method stub
		minX -= x;
		minY -= y;
		maxX -= x;
		maxY -= y;
		for(IShape shape: groupedShapes)
		{
			shape.removeCoodinates(x, y);
		}
	}
	
	public void add(IShape shape)
	{
		groupedShapes.add(shape);
	}
	
	@Override
	public ArrayList<IShape> getShapes()
	{
		return groupedShapes;
	}
	
	@Override
	public boolean isGroup() {
		// TODO Auto-generated method stub
		return true;
	}

}
