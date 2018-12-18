package drawing.commands;

import drawing.ui.DrawingPane;
import drawing.shapes.IShape;

public class CloneCommand implements ICommand {
    private DrawingPane drawingPane;
    private IShape ishape;

    public CloneCommand(DrawingPane dpane){
        drawingPane = dpane;
    }

    @Override
    public void execute() {
        for (int i = 0; i < drawingPane.getSelection().size(); i++) {
            drawingPane.addShape(drawingPane.getSelection().get(i).clone());
        }
    }

    @Override
    public void undo() {
        drawingPane.removeShape(ishape);
    }

    @Override
    public ICommand clone() {
        ICommand copy = new CloneCommand(drawingPane);
        ((CloneCommand)copy).ishape = this.ishape;
        return copy;
    }
}
