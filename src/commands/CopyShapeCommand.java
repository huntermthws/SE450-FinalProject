package commands;

import model.ShapeList;
import model.interfaces.IShape;

public class CopyShapeCommand implements ICommand{

	ShapeList shapeList;

	public CopyShapeCommand(ShapeList shapeList)
	{
		this.shapeList = shapeList;
	}

	@Override
	//adds the shape from selectedList to copiedList
	public void run() {
		for (IShape shape : shapeList.getSelectedList()) {
            shapeList.addCopied(shape);
        }
	}
	
}
