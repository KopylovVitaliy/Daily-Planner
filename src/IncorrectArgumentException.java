import java.io.IOException;

public class IncorrectArgumentException extends IOException {
    private String argument;

    public IncorrectArgumentException(String argument) {
        super(argument);
    }

    public String getArgument() {
        return argument;
    }

    @Override
    public String toString() {
        return "Параметр " + argument + " задан неверно";
    }
}

