package strategy;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;

import model.ShapeShadingType;
import model.interfaces.IShape;

//This works the same as the EllipseStrategy, but has an extra function on the end to add outline
public class EllipseDecorator extends EllipseStrategy{
	public void draw(IShape shape, Graphics2D graphics2d) {
		if(shape.getShading() == ShapeShadingType.FILLED_IN)
		{
			//System.out.println("Ellipse, Filled");
			graphics2d.setColor(shape.getColor());
			graphics2d.fillOval(shape.getMinX(), shape.getMinY(), shape.getWidth(), shape.getHeight());
		}
		else if(shape.getShading() == ShapeShadingType.OUTLINE)
		{
			//System.out.println("Ellipse, Outlined");
			graphics2d.setStroke(new BasicStroke(5));
			graphics2d.setColor(shape.getOutline());
			graphics2d.drawOval(shape.getMinX(), shape.getMinY(), shape.getWidth(), shape.getHeight());
		}
		else if(shape.getShading() == ShapeShadingType.OUTLINE_AND_FILLED_IN)
		{
			//System.out.println("Ellipse, Out and Fill");
			graphics2d.setStroke(new BasicStroke(5));
			graphics2d.setColor(shape.getColor());
			graphics2d.fillOval(shape.getMinX(), shape.getMinY(), shape.getWidth(), shape.getHeight());
			graphics2d.setColor(shape.getOutline());
			graphics2d.drawOval(shape.getMinX(), shape.getMinY(), shape.getWidth(), shape.getHeight());
		}
		DrawOutline(shape, graphics2d);
	}
	
	private void DrawOutline(IShape shape, Graphics2D graphics2d) {
		
		Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
        graphics2d.setStroke(stroke);
		graphics2d.setColor(Color.BLACK);
		graphics2d.drawOval(shape.getMinX()-5, shape.getMinY()-5, shape.getWidth()+10, shape.getHeight() + 10);
	
	}
}
