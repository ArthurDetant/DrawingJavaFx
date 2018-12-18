package drawing.handlers;

import drawing.commands.BindCommand;
import drawing.commands.CommandHistory;
import drawing.commands.ICommand;
import drawing.ui.DrawingPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.EventListener;

public class BindButtonHandler implements EventHandler<ActionEvent> {
    private CommandHistory history = new CommandHistory();
    private DrawingPane drawingPane;
    private ICommand bind;

    public BindButtonHandler(ICommand b,DrawingPane dpane)
    {
                drawingPane = dpane;
                bind =b;
    }




    @Override
    public void handle(ActionEvent event) {
        drawingPane.getHistory().exec(bind);

    }
}
