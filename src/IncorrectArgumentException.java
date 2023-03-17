public class IncorrectArgumentException extends Exception{
    private String argument;

    public IncorrectArgumentException(String argument) {
        super(argument);
    }

    @Override
    public String toString() {
        return "Параметр " + argument + " задан неверно";
    }
}

