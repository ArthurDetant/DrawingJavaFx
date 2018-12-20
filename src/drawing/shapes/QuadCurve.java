package drawing.shapes;

import drawing.IEdgeStrategy;
import javafx.scene.shape.*;


public class QuadCurve implements IEdgeStrategy {


    @Override
    public void buildPath(IShape from, IShape to, Path path) {
        MoveTo moveTo = new MoveTo();
        QuadCurveTo quadCurveTo = new QuadCurveTo();

        moveTo.xProperty().bind(from.translateXPorperty());
        moveTo.yProperty().bind(from.translateYPorperty());
        quadCurveTo.xProperty().bind(to.translateXPorperty());
        quadCurveTo.yProperty().bind(to.translateYPorperty());
        quadCurveTo.setControlX(100.0f);
        quadCurveTo.setControlY(0.0f);


        path.getElements().add(moveTo);
        path.getElements().add(quadCurveTo);
    }
}
