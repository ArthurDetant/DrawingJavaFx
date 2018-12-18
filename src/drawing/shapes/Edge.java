package drawing.shapes;

import javafx.beans.value.ObservableValue;
import javafx.geometry.Bounds;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

public class Edge implements IShape  {

    private IShape from;
    private IShape to;
    private Line shape;
    private boolean isSelected;

    public Edge(IShape f, IShape t) {
       from=f;
       to = t;
       shape = new Line();
       shape.startXProperty().bind(from.translateXPorperty());
       shape.startYProperty().bind(from.translateYPorperty());
       shape.endXProperty().bind(to.translateXPorperty());
       shape.endYProperty().bind(to.translateYPorperty());
    }

    @Override
    public boolean isSelected() {
        return this.isSelected;
    }

    @Override
    public void setSelected(boolean selected) {
        this.isSelected = selected;
        if (selected)
            shape.getStyleClass().add("selected");
        else
            shape.getStyleClass().remove("selected");
    }

    @Override
    public boolean isOn(double x, double y) {
        return shape.getBoundsInParent().contains(x,y);
    }

    @Override
    public void offset(double x, double y) {

    }

    @Override
    public void addShapeToPane(Pane pane) {
        pane.getChildren().add(shape);
        shape.toBack();

    }

    @Override
    public void removeShapeFromPane(Pane pane) {
        pane.getChildren().remove(shape);
    }

    @Override
    public IShape clone() {
        return null;
    }

    @Override
    public Bounds getBoundsInParent() {
        return null;
    }

    @Override
    public ObservableValue translateXPorperty() {
        return shape.startXProperty().add(shape.endXProperty()).divide(2);

    }

    @Override
    public ObservableValue translateYPorperty() {
        return shape.startYProperty().add(shape.endYProperty()).divide(2);
    }
}
