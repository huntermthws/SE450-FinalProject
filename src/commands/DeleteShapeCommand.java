package commands;

import java.util.ArrayList;

import model.ShapeList;
import model.interfaces.IShape;
import model.interfaces.IUndoable;

public class DeleteShapeCommand implements ICommand, IUndoable{

	ShapeList shapeList;
	
	public DeleteShapeCommand(ShapeList shapeList)
	{
		this.shapeList = shapeList;
	}

	@Override
	//Iterate through selectedList and deletes them from the masterList
	public void run() {
		// TODO Auto-generated method stub
		for (IShape shape : shapeList.getSelectedList()) {
			/*if(shape.isGroup())
			{
				for (IShape s : shape.getShapes())
				{
					shapeList.remove(s);
				}
			}
			else 
			{*/
				shapeList.remove(shape);
			//}
		}
		CommandHistory.add(this);
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		//Iterate through selectedList and readds them from the masterList
		for (IShape shape : shapeList.getSelectedList()) {
			shapeList.add(shape);
		}
	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		//Iterate through selectedList and deletes them from the masterList again
		for (IShape shape : shapeList.getSelectedList()) {
			shapeList.remove(shape);
		}
	}
}