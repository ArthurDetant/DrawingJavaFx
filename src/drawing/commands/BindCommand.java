package drawing.commands;

import drawing.Errors;
import drawing.shapes.Droit;
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
        Droit d= new Droit();
        IShape line = new Edge(drawingPane.getSelection().get(0), drawingPane.getSelection().get(1), d);
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
