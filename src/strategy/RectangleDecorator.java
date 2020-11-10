package strategy;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;

import model.interfaces.IShape;

//This works the same as the RectangleDecorator, but has an extra function on the end to add outline
public class RectangleDecorator extends RectangleStrategy {
	public void draw(IShape shape, Graphics2D graphics2d) {
		if(shape.getShading().toString() == "FILLED_IN")
		{
			//System.out.println("Rect, Filled");
			graphics2d.setColor(shape.getColor());
			graphics2d.fillRect(shape.getMinX(), shape.getMinY(), shape.getWidth(), shape.getHeight());
		}
		else if(shape.getShading().toString() == "OUTLINE")
		{
			//System.out.println("Rect, Outlined");
			graphics2d.setColor(shape.getOutline());
			graphics2d.drawRect(shape.getMinX(), shape.getMinY(), shape.getWidth(), shape.getHeight());
		}
		else if(shape.getShading().toString() == "OUTLINE_AND_FILLED_IN")
		{
			//System.out.println("Rect, Out and Fill");
			graphics2d.setColor(shape.getColor());
			graphics2d.fillRect(shape.getMinX(), shape.getMinY(), shape.getWidth(), shape.getHeight());
			graphics2d.setColor(shape.getOutline());
			graphics2d.drawRect(shape.getMinX(), shape.getMinY(), shape.getWidth(), shape.getHeight());
		}
		DrawOutline(shape, graphics2d);
		
	}
	
	private void DrawOutline(IShape shape, Graphics2D graphics2d) {
		
		Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
        graphics2d.setStroke(stroke);
		graphics2d.setColor(Color.BLACK);
		graphics2d.drawRect(shape.getMinX()-5, shape.getMinY()-5, shape.getWidth()+10, shape.getHeight() + 10);
	
	}
}
