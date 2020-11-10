package commands;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;

import controller.ColorConvertor;
import model.Shape;
import model.ShapeList;
import model.interfaces.IShape;
import model.interfaces.IUndoable;
import model.persistence.ApplicationState;
import mouseListener.Point;
import view.interfaces.PaintCanvasBase;
import view.gui.PaintCanvas;

public class CreateShapeCommand implements ICommand, IUndoable {
	
	Point startPoint;
	Point endPoint;
	ApplicationState appState;
	ShapeList shapeList;
	private IShape newShape;
	
		
	public CreateShapeCommand( Point startPoint, Point endPoint, ShapeList shapeList, ApplicationState appState)
	{
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.shapeList = shapeList;
		this.appState = appState;
	}
		
	//Running creates a new shape and adds to shapeList
	@Override
	public void run() {
		newShape = new Shape(startPoint, endPoint, ColorConvertor.getColor(appState.getActivePrimaryColor()), 
		ColorConvertor.getColor(appState.getActiveSecondaryColor()), appState.getActiveShapeType(), appState.getActiveShapeShadingType()); 
		shapeList.add(newShape);
		CommandHistory.add(this);
	}

	@Override
	public void undo() {
		shapeList.remove(newShape);
	}

	@Override
	public void redo() {
		shapeList.add(newShape);	
	}

}
