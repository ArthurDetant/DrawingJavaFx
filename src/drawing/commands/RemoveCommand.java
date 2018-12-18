package drawing.commands;

import drawing.Errors;
import drawing.ui.DrawingPane;
import drawing.shapes.IShape;

import java.util.ArrayList;

public class RemoveCommand implements ICommand {
    private DrawingPane drawingPane;
    private ArrayList<IShape> savedShapes;


    public RemoveCommand(DrawingPane dpane){
        drawingPane = dpane;
        savedShapes = new ArrayList<IShape>();

    }

    @Override
    public void execute() throws Errors {
        if (drawingPane.getSelection().size()<=0){
            drawingPane.giveError("Not possible to Del if you don't select 1 form or more");
            throw new Errors("Not possible to Del if you don't select 1 form or more");
        }
        savedShapes.clear();
        savedShapes.addAll(drawingPane.getSelection());
        drawingPane.removeSelection();
    }

    @Override
    public void undo() {
        for (int j = 0; j <  savedShapes.size(); j++) {
            drawingPane.addShape(savedShapes.get(j));
        }
    }

    @Override
    public ICommand clone(){
        ICommand copy = new RemoveCommand(drawingPane);
        ((RemoveCommand) copy).savedShapes.addAll(this.savedShapes);
        return copy;
    }


}
