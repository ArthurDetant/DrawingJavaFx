package drawing.shapes;

import drawing.IEdgeStrategy;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;


public class Courbes implements IEdgeStrategy {


    @Override
    public void buildPath(IShape from, IShape to, Path path) {
        MoveTo moveTo = new MoveTo();
        ArcTo arcTo = new ArcTo();

        moveTo.xProperty().bind(from.translateXPorperty());
        moveTo.yProperty().bind(from.translateYPorperty());
        arcTo.xProperty().bind(to.translateXPorperty());
        arcTo.yProperty().bind(to.translateYPorperty());
        arcTo.setRadiusX(50);
        arcTo.setRadiusY(50);

        path.getElements().add(moveTo);
        path.getElements().add(arcTo);
    }
}
