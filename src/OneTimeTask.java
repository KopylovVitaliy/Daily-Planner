import java.time.LocalDate;
import java.time.LocalDateTime;

public class OneTimeTask extends Task{
    public OneTimeTask(String title
            , Type type
            , LocalDateTime dataTime
            , String description) throws IncorrectArgumentException {
        super(title, type, dataTime, description);
    }

    @Override
    public boolean appearsln(LocalDate dateForCheck) {
        return getDataTime().getYear() == dateForCheck.getYear()
                && getDataTime().getMonth() == dateForCheck.getMonth()
                && getDataTime().getDayOfYear() == dateForCheck.getDayOfYear();
    }
}
