package controller;

import commands.CopyShapeCommand;
import commands.DeleteShapeCommand;
import commands.GroupShapeCommand;
import commands.PasteShapeCommand;
import commands.RedoCommand;
import commands.UnGroupShapeCommand;
import commands.UndoCommand;
import model.ShapeList;
import model.interfaces.IApplicationState;
import model.persistence.ApplicationState;
import view.EventName;
import view.interfaces.IUiModule;

public class JPaintController implements IJPaintController {
    private final IUiModule uiModule;
    private final IApplicationState applicationState;
    private final ShapeList shapeList;

    public JPaintController(IUiModule uiModule, IApplicationState applicationState, ShapeList shapeList) {
        this.uiModule = uiModule;
        this.applicationState = applicationState;
        this.shapeList = shapeList;
    }

    @Override
    public void setup() {
        setupEvents();
    }

    private void setupEvents() {
        uiModule.addEvent(EventName.CHOOSE_SHAPE, () -> applicationState.setActiveShape());
        uiModule.addEvent(EventName.CHOOSE_PRIMARY_COLOR, () -> applicationState.setActivePrimaryColor());
        uiModule.addEvent(EventName.CHOOSE_SECONDARY_COLOR, () -> applicationState.setActiveSecondaryColor());
        uiModule.addEvent(EventName.CHOOSE_SHADING_TYPE, () -> applicationState.setActiveShadingType());
        uiModule.addEvent(EventName.CHOOSE_MOUSE_MODE, () -> applicationState.setActiveStartAndEndPointMode());
        uiModule.addEvent(EventName.UNDO, () -> new UndoCommand().run());
        uiModule.addEvent(EventName.REDO, () -> new RedoCommand().run());
        uiModule.addEvent(EventName.COPY, () -> new CopyShapeCommand(shapeList).run());
        uiModule.addEvent(EventName.PASTE, () -> new PasteShapeCommand(shapeList, (ApplicationState)applicationState).run());
        uiModule.addEvent(EventName.DELETE, () -> new DeleteShapeCommand(shapeList).run());
        uiModule.addEvent(EventName.GROUP, () -> new GroupShapeCommand(shapeList).run());
        uiModule.addEvent(EventName.UNGROUP, () -> new UnGroupShapeCommand(shapeList).run());
    }
}
