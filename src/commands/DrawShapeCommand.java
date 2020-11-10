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

public class DrawShapeCommand implements ICommand {
	
	PaintCanvasBase paintCanvas;
	/*Point startPoint;
	Point endPoint;
	/*ArrayList<IShape>*/ ShapeList shapeList;
	private IShape newShape;
	Point triangePoint;
	int [] xPoints = new int[3];
	int [] yPoints = new int[3];
	private IStrategy shapeStrategy;
	
	
	//Should pass shape instead...
	//All these arguments are no good, but works for now..
	public DrawShapeCommand(/*Point startPoint, Point endPoint,  ArrayList<IShape>*/ShapeList shapeList, PaintCanvasBase paintCanvas)
	{
		/*this.startPoint = startPoint;
		this.endPoint = endPoint;*/
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
		{
			IStrategy shapeStrategy = null;
			if(shape.getShape().toString() == "RECTANGLE")
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
			else if(shape.getShape().toString() == "ELLIPSE")
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
			else if(shape.getShape().toString() == "TRIANGLE")
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
	
}
