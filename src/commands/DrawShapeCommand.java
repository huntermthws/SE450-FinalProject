package commands;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import model.Shape;
import model.ShapeList;
import model.ShapeType;
import model.interfaces.IShape;
import strategy.*;
import mouseListener.Point;
import view.interfaces.PaintCanvasBase;

public class DrawShapeCommand implements IDrawShapeCommand {
	
	PaintCanvasBase paintCanvas;
	ShapeList shapeList;
	private IStrategy shapeStrategy;

	
	
	//Should pass shape instead...
	//All these arguments are no good, but works for now..
	public DrawShapeCommand(ShapeList shapeList, PaintCanvasBase paintCanvas)
	{
		this.shapeList = shapeList;
		this.paintCanvas = paintCanvas;
	}
	
	

	//Create graphic
	//Wipe canvas
	//Loop  thru shapeList, call the respective strategy when the shape matches the Type
	//Added logic to see if the decorator or strategy should be called
	//Decorator is called if the shape needs to be outlined for selections
	@Override 
	public void run(){
		Graphics2D graphics2d = paintCanvas.getGraphics2D();
		graphics2d.setColor(Color.WHITE);
		graphics2d.fillRect(0, 0, 9000, 9000);
		
		
		for(IShape shape : shapeList.getList())
		//for(IShape shape : drawShapeList)
		{
			draw(shape, graphics2d);
		} 
		
	}



	@Override
	public void draw(IShape shape, Graphics2D graphics2d) {
		// TODO Auto-generated method stub
		IStrategy shapeStrategy = null;
		if(shape.isGroup())
		{
			if(shapeList.getSelectedList().contains(shape))
			{
				//System.out.println("Contains");
				shapeStrategy = new RectangleDecorator();
				shapeStrategy.draw(shape, graphics2d);
			}
			for (IShape s : shape.getShapes()) 
			{
				System.out.println("Group print");
				draw(s, graphics2d);
			}
		}
		else if(shape.getShape() == ShapeType.RECTANGLE)
		{
			if(shapeList.getSelectedList().contains(shape))
			{
				//System.out.println("Contains");
				shapeStrategy = new RectangleDecorator();
				shapeStrategy.draw(shape, graphics2d);
			}
			else
			{
				shapeStrategy = new RectangleStrategy();
				shapeStrategy.draw(shape, graphics2d);
			}
		}
		else if(shape.getShape() == ShapeType.ELLIPSE)
		{
			if(shapeList.getSelectedList().contains(shape))
			{
				//System.out.println("Contains");
				shapeStrategy = new EllipseDecorator();
				shapeStrategy.draw(shape, graphics2d);
			}
			else
			{
				shapeStrategy = new EllipseStrategy();
				shapeStrategy.draw(shape, graphics2d);
			}
		}
		else if(shape.getShape() == ShapeType.TRIANGLE)
		{
			if(shapeList.getSelectedList().contains(shape))
			{
				//System.out.println("Contains");
				shapeStrategy = new TriangleDecorator();
				shapeStrategy.draw(shape, graphics2d);
			}
			else
			{
				shapeStrategy = new TriangleStrategy();
				shapeStrategy.draw(shape, graphics2d);
			}
		}
	}
	
}
