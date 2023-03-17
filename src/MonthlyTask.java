import java.time.LocalDateTime;

public class MonthlyTask extends Task{
    public MonthlyTask(String title
            , Type type
            , LocalDateTime dataTime
            , String description) {
        super(title, type, dataTime, description);
    }

    @Override
    public boolean appearsln() {
        return false;
    }
}
