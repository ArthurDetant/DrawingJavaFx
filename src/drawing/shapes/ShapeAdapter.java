package drawing.shapes;


import javafx.beans.value.ObservableValue;
import javafx.geometry.Bounds;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;

public class ShapeAdapter implements IShape {
    private Shape shape;
    private boolean isSelected;

    public ShapeAdapter (Shape shape) {

        this.shape = shape;
        this.isSelected = false;
    }

    @Override
    public void addShapeToPane(Pane dp) {
        dp.getChildren().add(this.shape);
    }

    @Override
    public boolean isSelected(){
        return isSelected;
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
    public boolean isOn(double x, double y){
        return shape.getBoundsInParent().contains(x, y);
    }

    @Override
    public void offset(double x, double y) {
        shape.setTranslateX(shape.getTranslateX()+x);
        shape.setTranslateY(shape.getTranslateY()+y);
    }

    @Override
    public void removeShapeFromPane(Pane pane) {
        pane.getChildren().remove(shape);
    }

    @Override
    public IShape clone() {
        Shape s =Shape.union(this.shape, this.shape);
        s.getStyleClass().addAll(this.shape.getStyleClass());
        s.getStyleClass().remove("selected");
        IShape copy = new ShapeAdapter(s);
        copy.offset(10,10);
        return copy;
    }

    @Override
    public Bounds getBoundsInParent() {
        return shape.getBoundsInParent();
    }

    @Override
    public ObservableValue translateXPorperty() {
        return shape.translateXProperty().add(this.shape.getBoundsInParent().getMinX()+this.getBoundsInParent().getWidth()/2);
    }

    @Override
    public ObservableValue translateYPorperty() {

        return shape.translateYProperty().add(this.shape.getBoundsInParent().getMinY()+this.getBoundsInParent().getHeight()/2);
    }
}
