package commands;

import model.ShapeGroup;
import model.ShapeList;
import model.interfaces.IShape;
import model.interfaces.IUndoable;

public class GroupShapeCommand implements ICommand, IUndoable{
	ShapeList shapeList;

	public GroupShapeCommand(ShapeList shapeList)
	{
		this.shapeList = shapeList;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		ShapeGroup group = new ShapeGroup(shapeList.getSelectedList());
		for (IShape shape : shapeList.getSelectedList()) {
			//group.add(shape);
			shapeList.remove(shape);
		}
		shapeList.add(group);
	}
	
	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		
	}

	
}
