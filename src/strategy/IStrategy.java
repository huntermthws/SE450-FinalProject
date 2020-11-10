package strategy;

import java.awt.Graphics2D;
import model.interfaces.IShape;

public interface IStrategy {
	void draw(IShape shape, Graphics2D graphics2d);
}
