public class TaskNotFoundException extends Exception{
    public TaskNotFoundException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "TaskNotFoundException " + super.toString();
    }
}
