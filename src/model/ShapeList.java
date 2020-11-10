package model;

import java.util.ArrayList;

import commands.CreateShapeCommand;
import commands.DrawShapeCommand;
import commands.ICommand;
import commands.OutlineShapeCommand;
import view.interfaces.PaintCanvasBase;
import model.interfaces.IShape;

public class ShapeList {

	private ArrayList<IShape> masterShapeList;
	private ArrayList<IShape> selectedShapeList;
	private ArrayList<IShape> copiedShapeList;
	PaintCanvasBase paintCanvas;
	
	public ShapeList(PaintCanvasBase paintCanvas) {
		this.masterShapeList = new ArrayList<IShape>();
		this.selectedShapeList = new ArrayList<IShape>();
		this.copiedShapeList = new ArrayList<IShape>();
		this.paintCanvas = paintCanvas;
	}
	
	//Adds a new shape to the internal list
	//Calls DrawShape
	public void add(IShape Shape) {
		masterShapeList.add(Shape);
		ICommand shapeCommand = null;
		shapeCommand = new DrawShapeCommand(/*Shape.getStart(), Shape.getEnd(),*/ this, paintCanvas);
		shapeCommand.run();
	}
	
	//Removes a shape from the internal list
	//Calls DrawShape
	public void remove(IShape Shape) {
		masterShapeList.remove(Shape);
		ICommand shapeCommand = null;
		shapeCommand = new DrawShapeCommand(/*Shape.getStart(), Shape.getEnd(),*/ this, paintCanvas);
		shapeCommand.run();
		
	}
	
	//Adds a shape to the selectedList
	//Calls DrawShape so that the selected box will appear
	public void addSelected(IShape Shape) {
		selectedShapeList.add(Shape);
		ICommand shapeCommand = null;
		shapeCommand = new DrawShapeCommand(/*Shape.getStart(), Shape.getEnd(),*/ this, paintCanvas);
		shapeCommand.run();
	}
	
	//Empties the selectedList
	public void clearSelectedList() {
        selectedShapeList.clear();
    }
	
	
	//add the shape to the copied shape list
	public void addCopied(IShape Shape) {
			copiedShapeList.add(Shape);
	}
	
	public ArrayList<IShape> getList() {return masterShapeList;}
	
	public ArrayList<IShape> getSelectedList() {return selectedShapeList;}
	
	public PaintCanvasBase getCanvas() {return paintCanvas;}
}
