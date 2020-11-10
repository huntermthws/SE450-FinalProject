 package commands;

import java.util.ArrayList;

import controller.ColorConvertor;
import model.Shape;
import model.ShapeList;
import model.interfaces.IApplicationState;
import model.interfaces.IShape;
import model.interfaces.IUndoable;
import model.persistence.ApplicationState;
import mouseListener.Point;

public class PasteShapeCommand implements ICommand, IUndoable {
	ShapeList shapeList;
	IShape newShape;
	ICommand shapeCommand;
	ApplicationState appState;
	Point newStart, newEnd;
	private ArrayList<IShape> tempList;
	
	public PasteShapeCommand(ShapeList shapeList, ApplicationState applicationState)
	{
		this.tempList = new ArrayList<IShape>();
		this.shapeList = shapeList;
		this.appState = applicationState;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(IShape shape : shapeList.getSelectedList())
		{
			//Create the new start positions for the shape which is offset from the start position of selected shape
			newStart = shape.getStart();
			newEnd = shape.getEnd();
			newStart.setX(newStart.getX() + 100);
			newEnd.setX(newEnd.getX() + 100);
			newStart.setY(newStart.getY() + 100);
			newEnd.setY(newEnd.getY() + 100);
			
			//Create a new shape and add it to shapeList
			//add to tempList as well for undo/redo function
			newShape = new Shape(newStart, newEnd, shape.getColor(), shape.getOutline(), shape.getShape(), shape.getShading()); 
			shapeList.add(newShape);
			tempList.add(newShape);
		}
		CommandHistory.add(this);

	}
	
	@Override
	public void undo() {
		// TODO Auto-generated method stub
		for(IShape shape : tempList)
			shapeList.remove(shape);
	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		for(IShape shape : tempList)
			shapeList.add(shape);
	}
}
