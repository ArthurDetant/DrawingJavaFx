package drawing.shapes;

import javafx.beans.value.ObservableValue;
import javafx.geometry.Bounds;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class Decorator implements IShape {

    private IShape ishape;
    private boolean isSelected;
    private Text text;

    public Decorator (IShape iShape){

        this.ishape = iShape;
        this.text = new Text("texte");
        this.text.translateXProperty().bind(ishape.translateXPorperty());
        this.text.translateYProperty().bind(ishape.translateYPorperty());
        //this.text.setX(this.ishape.getBoundsInParent().getMinX()+this.getBoundsInParent().getWidth()/2);
        //this.text.setY(this.ishape.getBoundsInParent().getMinY()+this.getBoundsInParent().getHeight()/2);
    }

    @Override
    public boolean isSelected() {
        return this.ishape.isSelected();
    }

    @Override
    public void setSelected(boolean selected) {
        this.ishape.setSelected(selected);
    }

    @Override
    public boolean isOn(double x, double y) {
        return this.ishape.isOn(x,y);
    }

    @Override
    public void offset(double x, double y) {
        this.ishape.offset(x,y);
        //this.text.setX(this.text.getX()+x );
        //this.text.setY(this.text.getY()+y );
    }

    @Override
    public void addShapeToPane(Pane pane) {
        this.ishape.addShapeToPane(pane);
        pane.getChildren().add(this.text);

    }

    @Override
    public void removeShapeFromPane(Pane pane) {
        this.ishape.removeShapeFromPane(pane);
        pane.getChildren().remove(text);
    }

    @Override
    public IShape clone() {
        Decorator copy = new Decorator(this.ishape.clone());
        return copy;
    }

    @Override
    public Bounds getBoundsInParent() {
        return ishape.getBoundsInParent();
    }

    @Override
    public ObservableValue translateXPorperty() {
        return null;
    }

    @Override
    public ObservableValue translateYPorperty() {
        return null;
    }


}
