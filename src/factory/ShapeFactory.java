package factory;

import model.interfaces.IShape;
import model.persistence.ApplicationState;
import mouseListener.Point;

//NOT USED YET
public class ShapeFactory {
	/*public IShape createShape(Point startPoint, Point endPoint, ApplicationState appState)
	{
		IShape shape = null;
		
		if((appState.getActiveShapeType().toString() == "RECTANGLE")) {
            shape = new DrawRectangle(shapeConfig);
        }
        if((appState.getActiveShapeType().toString() == "ELLIPSE")) {
            shape = new DrawEllipse(shapeConfig);
        }
        if((appState.getActiveShapeType().toString() == "TRIANGLE")) {
            shape = new DrawTriangle(shapeConfig);
        }
		
		return shape;
		
	}*/
}
