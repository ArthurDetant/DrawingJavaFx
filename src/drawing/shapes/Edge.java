package drawing.shapes;

import drawing.IEdgeStrategy;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Bounds;
import javafx.scene.layout.Pane;
import javafx.scene.shape.*;

public class Edge implements IShape  {

    private IShape from;
    private IShape to;
    private Path shape;
    private boolean isSelected;
    private IEdgeStrategy iEdgeStrategy;

    public Edge(IShape f, IShape t, IEdgeStrategy ies) {

       shape = new Path();
       from=f;
       to = t;
       iEdgeStrategy =ies;
       ies.buildPath(f,t,shape);

    }
    public void setEdgeStrategy(IEdgeStrategy strategy){ // pas bien et pas fini
        iEdgeStrategy = strategy;
        iEdgeStrategy.buildPath(this.from,this.to,this.shape);
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
        return shape.translateXProperty();

    }

    @Override
    public ObservableValue translateYPorperty() {
        return shape.translateYProperty();
    }
}
