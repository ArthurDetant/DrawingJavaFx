package drawing.ui;

import drawing.Errors;
import drawing.Observer;
import drawing.commands.CommandHistory;
import drawing.shapes.IShape;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.util.List;

public class ErrorsBar extends HBox implements Observer {
    private Label labelForm;
    private DrawingPane dp;

    public ErrorsBar(DrawingPane drawingPane) {
        this.dp = drawingPane;

        this.labelForm = new Label("Exceptions : 0");
        this.getChildren().addAll(this.labelForm);

    }

    @Override
    public void update() {
        this.labelForm.setText("Exceptions : "+dp.getError());
        this.dp.giveError("0");

    }
}
