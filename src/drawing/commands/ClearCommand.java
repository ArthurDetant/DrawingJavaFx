package drawing.commands;

import drawing.Errors;
import drawing.ui.DrawingPane;
import drawing.shapes.IShape;

import java.util.ArrayList;

public class ClearCommand implements ICommand {

    private DrawingPane drawingPane;
    private ArrayList <IShape> savedShapes;


    public ClearCommand(DrawingPane dpane){
        drawingPane = dpane;
        savedShapes = new ArrayList<IShape>();
    }

    @Override
    public void execute() throws Errors {
        if(drawingPane.getShapes().size()==0){
            drawingPane.giveError("Nothing to clear");
            throw new Errors("Nothing to clear");
        }
        savedShapes.addAll(drawingPane.getShapes());
        drawingPane.clear();
    }

    @Override
    public void undo() {
        for (int j = 0; j <  savedShapes.size(); j++) {
            drawingPane.addShape(savedShapes.get(j));
        }
    }

    @Override
    public ICommand clone(){
        ICommand copy = new ClearCommand(drawingPane);
        ((ClearCommand) copy).savedShapes.addAll(this.savedShapes);
        return copy;
    }
}