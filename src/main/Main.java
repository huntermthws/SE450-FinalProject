package main;

import controller.IJPaintController;
import controller.JPaintController;
import model.ShapeList;
import model.interfaces.IShape;
import model.persistence.ApplicationState;
import mouseListener.MouseListener;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.PaintCanvasBase;
import view.interfaces.IUiModule;

import java.awt.*;

public class Main {
    public static void main(String[] args){
    	
    	//Only 1 instance of PaintCanvas()
        PaintCanvasBase paintCanvas = new PaintCanvas();
        ShapeList shapeList = new ShapeList(paintCanvas);
        IGuiWindow guiWindow = new GuiWindow(paintCanvas);
        IUiModule uiModule = new Gui(guiWindow);
        
        
        
        //Only 1 instance of ApplicationState() and JPaintController()
        ApplicationState appState = new ApplicationState(uiModule);
        IJPaintController controller = new JPaintController(uiModule, appState, shapeList);
        controller.setup();
        
        //Initialize ShapeList
        
        
        //Create and Add a MouseListener
        MouseListener jPaintListener = new MouseListener(paintCanvas, appState, shapeList);   
        paintCanvas.addMouseListener(jPaintListener);
        
        /*Graphics2D graphics2d = paintCanvas.getGraphics2D();
        graphics2d.setColor(Color.black);
        graphics2d.fillPolygon(xPoints, yPoints, nPoints);
    */

    }
}
