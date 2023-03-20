import java.time.LocalDate;
import java.time.LocalDateTime;

public class MonthlyTask extends Task{
    public MonthlyTask(String title
            , Type type
            , LocalDateTime dataTime
            , String description) throws IncorrectArgumentException {
        super(title, type, dataTime, description);
    }

    @Override
    public boolean appearsln(LocalDate dateForCheck) {
        return getDataTime().getDayOfMonth() == dateForCheck.getDayOfMonth();
    }
}
