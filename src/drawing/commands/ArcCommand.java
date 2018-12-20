package drawing.commands;

import drawing.Errors;
import drawing.IEdgeStrategy;
import drawing.shapes.Courbes;
import drawing.shapes.Droit;
import drawing.shapes.Edge;
import drawing.shapes.IShape;
import drawing.ui.DrawingPane;

public class ArcCommand implements ICommand {
    private DrawingPane drawingPane;

    public ArcCommand(DrawingPane dpane){
        this.drawingPane = dpane;
    }
    @Override
    public void execute() throws Errors {

        if(drawingPane.getSelection().size() !=2){
            drawingPane.giveError("Need 2 forms!");
            throw new Errors("Need 2 forms!");
        }
        Courbes c= new Courbes();
        IShape line = new Edge(drawingPane.getSelection().get(0), drawingPane.getSelection().get(1), c);
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
