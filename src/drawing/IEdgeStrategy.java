package drawing;

import drawing.shapes.IShape;
import javafx.scene.shape.Path;

public interface IEdgeStrategy {
    void buildPath(IShape from, IShape to, Path path);
}
