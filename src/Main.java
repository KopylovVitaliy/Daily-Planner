import java.time.LocalDate;
import java.time.Month;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IncorrectArgumentException {
        DailyTask task1 = new DailyTask("Почистить зубы"
                , Type.valueOf("WORK")
                , LocalDate.of(2023, Month.MARCH
                , 30).atStartOfDay()
                , "чистка зубов");
        System.out.println(task1);
        TaskService taskService = new TaskService();
        taskService.add(task1);
        System.out.println(taskService);

        try {
            taskService.remove(1);
        } catch (TaskNotFoundException e) {
            throw new RuntimeException(e);
        }


        System.out.println(taskService);


    }
}
