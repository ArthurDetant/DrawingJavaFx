package drawing.ui;

import drawing.Observer;
import drawing.commands.*;
import drawing.handlers.*;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class ToolBar extends HBox implements Observer {

    private Button clearButton;
    private Button rectangleButton;
    private Button circleButton;
    private Button triangleButton;
    private Button removeButton;
    private Button groupButton;
    private Button degroupButton;
    private Button undoButton;
    private Button cloneButton;
    private Button TextButton;
    private Button bindButton;
    private Button ArcButton;
    private Button QuadButton;


    public ToolBar(DrawingPane drawingPane) {

        ClearCommand clear = new ClearCommand(drawingPane);
        DegroupCommand degroup = new DegroupCommand(drawingPane);
        GroupCommand group = new GroupCommand(drawingPane);
        RemoveCommand remove = new RemoveCommand(drawingPane);
        CloneCommand clone = new CloneCommand(drawingPane);
        TextCommand text = new TextCommand(drawingPane);
        BindCommand bind = new BindCommand(drawingPane);
        ArcCommand arc = new ArcCommand(drawingPane);
        QuadCommand quad = new QuadCommand(drawingPane);

        clearButton = new Button("Clear");
        // clearButton.setOnAction(event -> drawingPane.clear());
        clearButton.addEventFilter(ActionEvent.ACTION, new ClearButtonHandler(clear, drawingPane));
        rectangleButton = new Button("Rectangle");
        rectangleButton.addEventFilter(ActionEvent.ACTION, new RectangleButtonHandler(drawingPane));
        circleButton = new Button("Circle");
        circleButton.addEventFilter(ActionEvent.ACTION, new EllipseButtonHandler(drawingPane));
        triangleButton = new Button("Triangle");
        triangleButton.addEventFilter(ActionEvent.ACTION, new TriangleButtonHandler(drawingPane));
        removeButton = new Button("Suppr.");
        removeButton.addEventFilter(ActionEvent.ACTION, new RemoveShapesHandler(remove, drawingPane));
        groupButton = new Button("Group");
        groupButton.addEventFilter(ActionEvent.ACTION, new GroupButtonHandler(group, drawingPane));
        degroupButton = new Button("Degroup");
        degroupButton.addEventFilter(ActionEvent.ACTION, new DegroupButtonHandler(degroup, drawingPane));
        undoButton = new Button("Undo");
        undoButton.addEventFilter(ActionEvent.ACTION, new UndoButtonHandler(drawingPane));
        cloneButton = new Button("Clone");
        cloneButton.addEventFilter(ActionEvent.ACTION, new CloneButtonHandler(clone,drawingPane));
        TextButton = new Button("Text");
        TextButton.addEventFilter(ActionEvent.ACTION, new TextButtonHandler(text,drawingPane));
        bindButton = new Button("Bind");
        bindButton.addEventFilter(ActionEvent.ACTION, new BindButtonHandler(bind ,drawingPane));
        ArcButton = new Button("Courbe");
        ArcButton.addEventFilter(ActionEvent.ACTION, new BindButtonHandler(arc ,drawingPane));

        QuadButton = new Button("Quad");
        QuadButton.addEventFilter(ActionEvent.ACTION, new BindButtonHandler(quad ,drawingPane));


        getChildren().addAll(clearButton, rectangleButton, circleButton, triangleButton, removeButton, groupButton, degroupButton, undoButton, cloneButton, TextButton, bindButton, ArcButton, QuadButton);
        setPadding(new Insets(5));
        setSpacing(5.0);
        getStyleClass().add("toolbar");
    }

    public void update () {

    }
}
