package commands;

import java.awt.Graphics2D;

import model.interfaces.IShape;

public interface IDrawShapeCommand {
	void run();
	void draw(IShape shape, Graphics2D graphics2d);
}
