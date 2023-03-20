import java.time.LocalDate;
import java.time.LocalDateTime;

public class YearlyTask extends Task {
    public YearlyTask(String title
            , Type type
            , LocalDateTime dataTime
            , String description) throws IncorrectArgumentException {
        super(title, type, dataTime, description);
    }

    @Override
    public boolean appearsln(LocalDate dateForCheck) {
        return getDataTime().getMonth() == dateForCheck.getMonth()
                && getDataTime().getDayOfYear() == dateForCheck.getDayOfYear();
    }
}
