import java.time.LocalDate;
import java.time.LocalDateTime;

public class WeeklyTask extends Task{
    public WeeklyTask(String title
            , Type type
            , LocalDateTime dataTime
            , String description) throws IncorrectArgumentException {
        super(title, type, dataTime, description);
    }

    @Override
    public boolean appearsln(LocalDate dateForCheck) {
        return (dateForCheck.isEqual(getDataTime().toLocalDate()) && dateForCheck.getDayOfMonth() == getDataTime().getDayOfMonth());
    }
}
