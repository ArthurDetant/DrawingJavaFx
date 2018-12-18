package drawing.commands;

import drawing.Errors;
import drawing.shapes.Edge;
import drawing.shapes.IShape;
import drawing.ui.DrawingPane;

public class BindCommand implements ICommand {
    private DrawingPane drawingPane;

    public BindCommand(DrawingPane dpane){
        this.drawingPane = dpane;
    }
    @Override
    public void execute() throws Errors {
        if(drawingPane.getSelection().size() !=2){
            drawingPane.giveError("Need 2 forms!");
            throw new Errors("Need 2 forms!");
        }
        IShape line = new Edge(drawingPane.getSelection().get(0), drawingPane.getSelection().get(1));
        drawingPane.addShape(line);
    }

    @Override
    public void undo() {

    }

    @Override
    public ICommand clone() {
        return null;
    }
}
