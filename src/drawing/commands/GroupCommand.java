package drawing.commands;

import drawing.Errors;
import drawing.shapes.Composite;
import drawing.ui.DrawingPane;
import drawing.shapes.IShape;

import java.util.ArrayList;

public class GroupCommand implements ICommand{
    private DrawingPane drawingPane;

    public GroupCommand(DrawingPane dpane){
        drawingPane = dpane;
    }
    Composite c = new Composite();

    @Override
    public void execute() throws Errors {

        for (int i = 0; i < drawingPane.getSelection().size(); i++) {
            if (drawingPane.getSelection().size()<2){
                drawingPane.giveError("Group not possible with less than 2 forms");
                throw new Errors("Group not possible with less than 2 forms");
            }
            c.add(drawingPane.getSelection().get(i));
        }

        drawingPane.removeSelection();

        drawingPane.addShape(c);

    }

    @Override
    public void undo() {
        ArrayList<IShape> list = new ArrayList<IShape>();
        for (int i = 0; i < drawingPane.getSelection().size(); i++) {
            if(drawingPane.getSelection().get(i) instanceof Composite){
                Composite c = (Composite)drawingPane.getSelection().get(i);
                list = c.getList();
                System.out.println(list);
                drawingPane.removeShape(c);

                for (int j = 0; j < list.size(); j++) {
                    drawingPane.addShape(list.get(j));
                }
            }

        }

        drawingPane.getSelection().clear();
    }

    @Override
    public ICommand clone(){
        ICommand copy = new GroupCommand(drawingPane);
        ((GroupCommand) copy).c = this.c;
        return copy;
    }
}
