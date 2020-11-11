package commands;

import java.util.ArrayList;

import model.ShapeList;
import model.interfaces.IShape;
import model.interfaces.IUndoable;
import model.persistence.ApplicationState;
import mouseListener.Point;
import view.interfaces.PaintCanvasBase;

public class SelectShapeCommand implements ICommand{

	Point startPoint;
	Point endPoint;
	ShapeList shapeList;

	public SelectShapeCommand( Point startPoint, Point endPoint, ShapeList shapeList)
	{
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.shapeList = shapeList;
	}
	
	@Override
	public void run() {
		
		//Make sure selectedList is empty
		shapeList.clearSelectedList();

		//Loop through all shapes from the masterList
		//Check to see if there is collision from the "select" box
		//If collision, add to selectedList
		for(IShape shape : shapeList.getList())
		{
			if(shape.checkCollision(startPoint, endPoint))
			{
		
				shapeList.addSelected(shape);
			}
				//System.out.println(shapeList.getSelectedList().toString());
		}
	}
	
}
