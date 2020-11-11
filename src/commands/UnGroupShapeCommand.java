package commands;

import java.util.ArrayList;

import model.ShapeGroup;
import model.ShapeList;
import model.interfaces.IShape;
import model.interfaces.IUndoable;

public class UnGroupShapeCommand implements ICommand, IUndoable{
	ShapeList shapeList;
	private ArrayList<IShape> groupedShape = new ArrayList<IShape>();

	public UnGroupShapeCommand(ShapeList shapeList)
	{
		this.shapeList = shapeList;
	}
	
	@Override
	public void run() {
		for(IShape shape: shapeList.getSelectedList())
		{
			if(shape.isGroup())
			{
				groupedShape.add(shape);
				shapeList.remove(shape);
				for(IShape s: shape.getShapes())
				{
					shapeList.add(s);
				}
			}
		}
		shapeList.clearSelectedList();
		for(IShape shape: groupedShape)
		{
			for(IShape s: shape.getShapes())
			{
				shapeList.addSelected(s);
			}
		}
		CommandHistory.add(this);
	}
	
	@Override
	public void undo() {
		for (IShape shape : shapeList.getSelectedList()) {
			shapeList.remove(shape);
		}
		shapeList.clearSelectedList();
		for (IShape shape : groupedShape) {
			shapeList.add(shape);
			shapeList.addSelected(shape);
		}
	}

	@Override
	public void redo() {
		for(IShape shape: shapeList.getSelectedList())
		{
			if(shape.isGroup())
			{
				shapeList.remove(shape);
				shapeList.clearSelectedList();
				for(IShape s: shape.getShapes())
				{
					shapeList.add(s);
					shapeList.addSelected(s);
				}
			}
		}
	}
}
