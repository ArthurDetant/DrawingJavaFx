package drawing.commands;


import drawing.Errors;
import drawing.shapes.Courbes;
import drawing.shapes.Edge;
import drawing.shapes.IShape;
import drawing.shapes.QuadCurve;
import drawing.ui.DrawingPane;

public class QuadCommand  implements ICommand {
    private DrawingPane drawingPane;

    public QuadCommand(DrawingPane dpane){
        this.drawingPane = dpane;
    }
    @Override
    public void execute() throws Errors {
        if(drawingPane.getSelection().size() !=2){
            drawingPane.giveError("Need 2 forms!");
            throw new Errors("Need 2 forms!");
        }
        QuadCurve q= new QuadCurve();
        IShape line = new Edge(drawingPane.getSelection().get(0), drawingPane.getSelection().get(1), q);
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
