package drawing.commands;

import drawing.Errors;

public interface ICommand {

    void execute() throws Errors;
    void undo();
    ICommand clone();
}
