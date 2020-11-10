//Triangle Strategy
//Receives a shape and the graphic
//Checks the shading type of the shape and draws/fills accordingly

package strategy;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;

import model.interfaces.IShape;

public class TriangleStrategy implements IStrategy {
	@Override
	public void draw(IShape shape, Graphics2D graphics2d) {

		if(shape.getShading().toString() == "FILLED_IN")
		{
			//System.out.println("Triange, Filled");
			graphics2d.setColor(shape.getColor());
			graphics2d.fillPolygon(shape.getXPoints(), shape.getYPoints(), 3);
		}
		else if(shape.getShading().toString() == "OUTLINE")
		{
			//System.out.println("Triangle, Outlined");
			graphics2d.setColor(shape.getOutline());
			graphics2d.drawPolygon(shape.getXPoints(), shape.getYPoints(), 3);
		}
		else if(shape.getShading().toString() == "OUTLINE_AND_FILLED_IN")
		{
			//System.out.println("Triangle, Out and Fill");
			graphics2d.setColor(shape.getColor());
			graphics2d.fillPolygon(shape.getXPoints(), shape.getYPoints(), 3);
			graphics2d.setColor(shape.getOutline());
			graphics2d.drawPolygon(shape.getXPoints(), shape.getYPoints(), 3);
		}
	}

}
