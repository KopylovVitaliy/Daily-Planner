package Tasks;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;

public class DailyTask extends Task {
    public DailyTask(String title
            , Type type
            , LocalDateTime dataTime
            , String description) {
        super(title, type, dataTime, description);
    }

    @Override
    public boolean appearsln(LocalDate dateForCheck) {
        return true;
    }
}
