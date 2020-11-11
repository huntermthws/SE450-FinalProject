package mouseListener;

//import java.awt.Point;
//import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import commands.CreateShapeCommand;
import commands.ICommand;
import commands.MoveShapeCommand;
import commands.SelectShapeCommand;
import model.MouseMode;
import model.ShapeList;
import model.persistence.ApplicationState;
import view.interfaces.PaintCanvasBase;
import view.gui.PaintCanvas;

public class MouseListener extends MouseAdapter {

		public Point startPoint;
		public Point endPoint;
		PaintCanvasBase paintCanvas;
		ApplicationState appState;
		ShapeList shapeList;
		
		//MouseListener Constructor
		public MouseListener(PaintCanvasBase paintCanvas, ApplicationState appState, ShapeList shapeList)
		{
			this.paintCanvas = paintCanvas;
			this.appState = appState;
			this.shapeList = shapeList;
		}
		
		//When mouse is pressed, record location
		@Override
		public void mousePressed(MouseEvent e)
		{
			startPoint = new Point (e.getX(), e.getY());

		}
		
		//When released, record  location
		//Check the appState ActiveMouseMode
		//Call the respective commands for the mode
		@Override
		public void mouseReleased(MouseEvent e)
		{
			endPoint = new Point (e.getX(), e.getY());
			ICommand shapeCommand = null;
			if(appState.getActiveMouseMode() == MouseMode.DRAW)
			{
				//System.out.println("Creating..");
				//shapeList.clearSelectedList();
				shapeCommand = new CreateShapeCommand(startPoint, endPoint, shapeList, appState);
				shapeCommand.run();
			}
			else if(appState.getActiveMouseMode()== MouseMode.SELECT)
			{
				//System.out.println("Selecting..");
				shapeList.clearSelectedList();
				shapeCommand = new SelectShapeCommand(startPoint, endPoint, shapeList);
				shapeCommand.run();
			}
			else
			{
				//System.out.println("Moving..");
				shapeCommand = new MoveShapeCommand(startPoint, endPoint, shapeList, appState);
				shapeCommand.run();
			}

		}
		

}
