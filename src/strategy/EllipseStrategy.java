//Ellipse Strategy
//Receives a shape and the graphic
//Checks the shading type of the shape and draws/fills accordingly

package strategy;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;

import model.interfaces.IShape;

public class EllipseStrategy implements IStrategy{
	@Override
	public void draw(IShape shape, Graphics2D graphics2d) {
		if(shape.getShading().toString() == "FILLED_IN")
		{
			//System.out.println("Ellipse, Filled");
			graphics2d.setColor(shape.getColor());
			graphics2d.fillOval(shape.getMinX(), shape.getMinY(), shape.getWidth(), shape.getHeight());
		}
		else if(shape.getShading().toString() == "OUTLINE")
		{
			//System.out.println("Ellipse, Outlined");
			graphics2d.setStroke(new BasicStroke(5));
			graphics2d.setColor(shape.getOutline());
			graphics2d.drawOval(shape.getMinX(), shape.getMinY(), shape.getWidth(), shape.getHeight());
		}
		else if(shape.getShading().toString() == "OUTLINE_AND_FILLED_IN")
		{
			//System.out.println("Ellipse, Out and Fill");
			graphics2d.setStroke(new BasicStroke(5));
			graphics2d.setColor(shape.getColor());
			graphics2d.fillOval(shape.getMinX(), shape.getMinY(), shape.getWidth(), shape.getHeight());
			graphics2d.setColor(shape.getOutline());
			graphics2d.drawOval(shape.getMinX(), shape.getMinY(), shape.getWidth(), shape.getHeight());
		}
	}
	
	/*public void drawOutline(IShape shape, Graphics2D graphics2d) {
		
		Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
        graphics2d.setStroke(stroke);
		graphics2d.setColor(Color.BLACK);
		graphics2d.drawOval(shape.getMinX()-5, shape.getMinY()-5, shape.getWidth()+10, shape.getHeight() + 10);
	
	}*/

}
