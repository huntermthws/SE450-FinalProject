package commands;

import controller.ColorConvertor;
import model.Shape;
import model.ShapeList;
import model.interfaces.IShape;
import model.interfaces.IUndoable;
import model.persistence.ApplicationState;
import mouseListener.Point;

public class MoveShapeCommand implements ICommand, IUndoable{

	Point startPoint;
	Point endPoint;
	ShapeList shapeList;
	public int deltaX, deltaY;
	ApplicationState appState;
	
	public MoveShapeCommand( Point startPoint, Point endPoint, ShapeList shapeList, ApplicationState appState)
	{
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.shapeList = shapeList;
		this.appState = appState;
	}
	
	@Override
	//Calculates the delta of where the moved shapes will go
	//Starts iterating through the selected shapes, removing it from masterList
	//Modifies the shapes coordinates
	//adds the new shape to the list
	//**Could change by changing how drawing works from shapes/shapelist?**
	public void run() {
		deltaX = endPoint.getX() - startPoint.getX();
        deltaY = endPoint.getY() - startPoint.getY();
        
        //System.out.println("In moving: " + shapeList.getSelectedList().toString());
        for(IShape shape: shapeList.getSelectedList()) {
        	//System.out.println("Attempting to move.. " + shape.toString());
            shapeList.remove(shape);
            shape.moveCoodinates(deltaX, deltaY);
			shapeList.add(shape);
        }
        CommandHistory.add(this);
    }
	
	@Override
	public void undo() {
		// TODO Auto-generated method stub
		for(IShape shape: shapeList.getSelectedList()) {
            shapeList.remove(shape);
            shape.removeCoodinates(deltaX, deltaY);
            shapeList.add(shape );
		}
	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		 for(IShape shape: shapeList.getSelectedList()) {
	        	System.out.println("Attempting to move.. " + shape.toString());
	            shapeList.remove(shape);
	            shape.moveCoodinates(deltaX, deltaY);
				shapeList.add(shape);
            
        }
		
	}
}
