package drawing.ui;

import drawing.Errors;
import drawing.Observer;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;

public class Bottombothbars extends VBox implements Observer {
    private StatutBar statutBar;
    private ErrorsBar errorsBar;

    public Bottombothbars(DrawingPane drawingPane){
        statutBar = new StatutBar(drawingPane);
        errorsBar = new ErrorsBar(drawingPane);
        this.statutBar.setPadding(new Insets(7));
        this.statutBar.getStyleClass().add("statutbar");
        this.errorsBar.setPadding(new Insets(7));
        this.errorsBar.getStyleClass().add("errorsbar");

        getChildren().addAll(statutBar,errorsBar);
    }
    @Override
    public void update() {
        statutBar.update();
        errorsBar.update();

    }
}
