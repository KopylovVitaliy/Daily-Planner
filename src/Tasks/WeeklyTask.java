package Tasks;

import Tasks.Type;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class WeeklyTask extends Task {
    public WeeklyTask(String title
            , Type type
            , LocalDateTime dataTime
            , String description) {
        super(title, type, dataTime, description);
    }

    @Override
    public boolean appearsln(LocalDate dateForCheck) {
        return (getDataTime().getDayOfWeek() == dateForCheck.getDayOfWeek());
    }
}
