package strategy;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;

import model.interfaces.IShape;

//This works the same as the TriangleDecorator, but has an extra function on the end to add outline
public class TriangleDecorator extends TriangleStrategy {
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
		DrawOutline(shape, graphics2d);
	}
	
	public void DrawOutline(IShape shape, Graphics2D graphics2d) {
		Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
        graphics2d.setStroke(stroke);
        
		graphics2d.setColor(Color.BLACK);
		graphics2d.drawPolygon(new int [] {shape.getStart().getX()-5, shape.getEnd().getX()+15, shape.getStart().getX()-5},
				new int [] {shape.getStart().getY()-15, shape.getEnd().getY()+5, shape.getEnd().getY()+5}, 3);
	
	}
}
