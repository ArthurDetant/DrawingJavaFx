package drawing.commands;

import drawing.Errors;
import drawing.shapes.Composite;
import drawing.shapes.Decorator;
import drawing.ui.DrawingPane;
import drawing.shapes.IShape;

import java.util.ArrayList;

public class TextCommand implements ICommand {

    private DrawingPane drawingPane;
    private ArrayList<IShape> saved;
    private ArrayList<IShape> saved2;

    public TextCommand(DrawingPane dpane){
        drawingPane = dpane;
        saved = new ArrayList<IShape>();
        saved2 = new ArrayList<IShape>();
    }

    @Override
    public void execute() throws Errors {
        for (int i = 0; i < drawingPane.getSelection().size(); i++) {
            if(drawingPane.getSelection().get(i) instanceof Composite){
                drawingPane.giveError("Can't Text a group ");
                throw new Errors("Can't Text a group ");
            }
            saved.add(drawingPane.getSelection().get(i));
            saved2.add(drawingPane.getSelection().get(i));
            drawingPane.removeShape(drawingPane.getSelection().get(i));
        }
        for (int i = 0; i < drawingPane.getSelection().size(); i++) {
            Decorator deco = new Decorator(this.saved.get(i));
            drawingPane.addShape(deco);
        }
        drawingPane.getSelection().clear();
        saved.clear();

    }

    @Override
    public void undo() {

    }

    @Override
    public ICommand clone(){
        ICommand copy = new TextCommand(drawingPane);
        ((TextCommand) copy).saved.addAll(this.saved);
        return copy;
    }
}