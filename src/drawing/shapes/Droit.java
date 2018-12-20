package drawing.shapes;

import drawing.IEdgeStrategy;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;


public class Droit implements IEdgeStrategy {


    @Override
    public void buildPath(IShape from, IShape to, Path path) {
        MoveTo moveTo = new MoveTo();
        LineTo lineTo = new LineTo();

        moveTo.xProperty().bind(from.translateXPorperty());
        moveTo.yProperty().bind(from.translateYPorperty());
        lineTo.xProperty().bind(to.translateXPorperty());
        lineTo.yProperty().bind(to.translateYPorperty());

        path.getElements().add(moveTo);
        path.getElements().add(lineTo);
    }
}
