package model;

import java.awt.Color;

import controller.ColorConvertor;
import model.interfaces.IShape;
import mouseListener.Point;


public class Shape implements IShape {
	
	public Point startPoint;
	public Point endPoint;
	public ShapeType activeType;
	public int maxX, minX, minY, maxY, width, height;
	public Color shapeColor;
	public Color outlineColor;
	public ShapeShadingType shadingType;
	int [] xPoints = new int[3];
	int [] yPoints = new int[3];
	
	public Shape(Point startPoint, Point endPoint, Color shapeColor, Color outlineColor, ShapeType activeType, ShapeShadingType shadingType)
	{
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.shapeColor = shapeColor;
		this.outlineColor = outlineColor;
		this.activeType = activeType;
		this.shadingType = shadingType;
		
		minX = Math.min(startPoint.getX(), endPoint.getX());
        maxX = Math.max(startPoint.getX(), endPoint.getX());
        minY = Math.min(startPoint.getY(), endPoint.getY());
        maxY = Math.max(startPoint.getY(), endPoint.getY());
        
        width = maxX - minX;
        height = maxY - minY;
        
		xPoints[0] = startPoint.x;
		xPoints[1] = endPoint.x;
		xPoints[2] = startPoint.x;
		yPoints[0] = startPoint.y;
		yPoints[1] = endPoint.y;
		yPoints[2] = endPoint.y;
	}
	
	
	//Logic to check for collision...messy....
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
	
	//Logic to change the coordinate of the shape
	//MESSY
	public void moveCoodinates(int x, int y) {
		
		this.startPoint.x += x;
		this.endPoint.x += x;
		
		this.startPoint.y += y;
		this.endPoint.y += y;
		
		this.minX = Math.min(startPoint.getX(), endPoint.getX());
		this.maxX = Math.max(startPoint.getX(), endPoint.getX());
		this.minY = Math.min(startPoint.getY(), endPoint.getY());
		this.maxY = Math.max(startPoint.getY(), endPoint.getY());
        
		this.width = maxX - minX;
		this.height = maxY - minY;
		this.xPoints[0] = startPoint.x;
		this.xPoints[1] = endPoint.x;
		this.xPoints[2] = startPoint.x;
		this.yPoints[0] = startPoint.y;
		this.yPoints[1] = endPoint.y;
		this.yPoints[2] = endPoint.y;
	}
	
	//Undoing the previous logic....
	//Again, messy...
	public void removeCoodinates(int x, int y) {
		this.startPoint.x -= x;
		this.endPoint.x -= x;
		
		this.startPoint.y -= y;
		this.endPoint.y -= y;
		
		this.minX = Math.min(startPoint.getX(), endPoint.getX());
		this.maxX = Math.max(startPoint.getX(), endPoint.getX());
		this.minY = Math.min(startPoint.getY(), endPoint.getY());
		this.maxY = Math.max(startPoint.getY(), endPoint.getY());
        
		this.width = maxX - minX;
		this.height = maxY - minY;
		this.xPoints[0] = startPoint.x;
		this.xPoints[1] = endPoint.x;
		this.xPoints[2] = startPoint.x;
		this.yPoints[0] = startPoint.y;
		this.yPoints[1] = endPoint.y;
		this.yPoints[2] = endPoint.y;
	}
	
	//Getters for the shape
	public Point getStart() { return startPoint;}
	public Point getEnd() {return endPoint;}
	public Color getColor() {return shapeColor;}
	public Color getOutline() {return outlineColor;}
	public int[] getXPoints() {return xPoints;}
	public int[] getYPoints() {return yPoints;}
	public int getMaxX() {return maxX;}
	public int getMinX() {return minX;}
	public int getMaxY() {return maxY;}
	public int getMinY() {return minY;}
	public int getHeight() {return height;}
	public int getWidth() {return width;}
	public ShapeType getShape() {return activeType;}
	public ShapeShadingType getShading() {return shadingType;}
}
