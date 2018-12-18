package drawing.commands;

import drawing.Errors;
import drawing.shapes.Composite;
import drawing.ui.DrawingPane;
import drawing.shapes.IShape;

import java.util.ArrayList;

public class DegroupCommand implements ICommand{
    private DrawingPane drawingPane;

    public DegroupCommand(DrawingPane dpane){
        drawingPane = dpane;
    }
    Composite c = new Composite();

    @Override
    public void execute() throws Errors {

        ArrayList<IShape> list = new ArrayList<IShape>();
        for (int i = 0; i < drawingPane.getSelection().size(); i++) {
            if(drawingPane.getSelection().get(i) instanceof Composite){

                Composite c = (Composite)drawingPane.getSelection().get(i);
                list = c.getList();
                drawingPane.removeShape(c);

                for (int j = 0; j < list.size(); j++) {
                    drawingPane.addShape(list.get(j));
                }
            }else {

                    drawingPane.giveError("It is not a group ");
                    throw new Errors("It is not a group ");

            }

        }

        drawingPane.getSelection().clear();

    }

    @Override
    public void undo() {
        for (int i = 0; i < drawingPane.getSelection().size(); i++) {
            c.add(drawingPane.getSelection().get(i));
        }

        drawingPane.removeSelection();

        drawingPane.addShape(c);
    }

    @Override
    public ICommand clone(){
        ICommand copy = new DegroupCommand(drawingPane);
        ((DegroupCommand) copy).c = this.c;
        return copy;
    }
}
