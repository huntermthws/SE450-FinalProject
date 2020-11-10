package commands;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import model.Shape;
import model.ShapeList;
import model.interfaces.IShape;
import strategy.*;
import mouseListener.Point;
import view.interfaces.PaintCanvasBase;

public class OutlineShapeCommand implements ICommand {
	
	PaintCanvasBase paintCanvas;
	Point startPoint;
	Point endPoint;
	ArrayList<IShape> shapeList;
	private IShape newShape;
	Point triangePoint;
	int [] xPoints = new int[3];
	int [] yPoints = new int[3];
	private IStrategy shapeStrategy;
	
	
	//Should pass shape instead...
	//All these arguments are no good, but works for now..
	public OutlineShapeCommand(Point startPoint, Point endPoint,  ArrayList<IShape> shapeList, PaintCanvasBase paintCanvas)
	{
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.shapeList = shapeList;
		this.paintCanvas = paintCanvas;
	}

	//Create graphic
	//Loop  thru shapeList, call the respective strategy when the shape matches the Type
	@Override 
	public void run(){
		Graphics2D graphics2d = paintCanvas.getGraphics2D();
		
		for(IShape shape : shapeList)
		{
			IStrategy shapeStrategy = null;
			if(shape.getShape().toString() == "RECTANGLE")
			{
	
				shapeStrategy = new RectangleDecorator();
				shapeStrategy.draw(shape, graphics2d);
			}
			else if(shape.getShape().toString() == "ELLIPSE")
			{
				shapeStrategy = new EllipseDecorator();
				shapeStrategy.draw(shape, graphics2d);
			}
			else if(shape.getShape().toString() == "TRIANGLE")
			{
				shapeStrategy = new TriangleDecorator();
				shapeStrategy.draw(shape, graphics2d);
			}
				
		} 
		shapeList.clear();
		
	}
	
}