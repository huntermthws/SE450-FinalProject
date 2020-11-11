package commands;

import java.util.ArrayList;

import model.ShapeGroup;
import model.ShapeList;
import model.interfaces.IShape;
import model.interfaces.IUndoable;

public class GroupShapeCommand implements ICommand, IUndoable{
	ShapeList shapeList;
	private IShape groupedShape;

	public GroupShapeCommand(ShapeList shapeList)
	{
		this.shapeList = shapeList;
	}
	
	@Override
	public void run() {
		ArrayList<IShape> tempList = new ArrayList<IShape>();
		tempList.addAll(shapeList.getSelectedList());
		groupedShape = new ShapeGroup(tempList);
		//IShape group = new ShapeGroup(tempList);
		for (IShape shape : shapeList.getSelectedList()) {
			shapeList.remove(shape);
		}
		shapeList.add(groupedShape);
		shapeList.clearSelectedList();
		shapeList.addSelected(groupedShape);
		CommandHistory.add(this);
	}
	
	@Override
	public void undo() {
		// TODO Auto-generated method stub
		shapeList.remove(groupedShape);
		shapeList.clearSelectedList();
		for(IShape shape: groupedShape.getShapes())
		{
			shapeList.add(shape);
			shapeList.addSelected(shape);
		}
	}

	@Override
	public void redo() {
		for (IShape shape : shapeList.getSelectedList()) {
			shapeList.remove(shape);
		}
		shapeList.add(groupedShape);
		shapeList.clearSelectedList();
		shapeList.addSelected(groupedShape);
	}

	
}
