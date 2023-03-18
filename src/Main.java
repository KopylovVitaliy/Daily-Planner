import java.time.LocalDate;
import java.time.Month;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IncorrectArgumentException {
        Scanner scanner = new Scanner(System.in);
        TaskService taskService = new TaskService();
        DailyTask task1 = new DailyTask("Почистить зубы"
                , Type.valueOf("WORK")
                , LocalDate.of(2023, Month.MARCH
                , 30).atStartOfDay()
                , "чистка зубов");
        DailyTask task2 = new DailyTask("Почистить"
                , Type.valueOf("PERSONAL")
                , LocalDate.of(2023, Month.MARCH
                , 2).atStartOfDay()
                , "чистка");


        while (true) {
            int y = scanner.nextInt();
            if (y == 1) {
                String title1 = scanner.nextLine(); // временная фича
                System.out.println("Название задачи");
                String title = scanner.nextLine();

                System.out.println(title1);

                System.out.println("type");
                Type type = Type.valueOf(scanner.nextLine());
                System.out.println(type);

                System.out.println("Описание");
                String description = scanner.nextLine();
                System.out.println(description);

                System.out.println("дата");
                int year = scanner.nextInt();
                int month = scanner.nextInt();
                int day = scanner.nextInt();
                LocalDate localDate = LocalDate.of(year, month, day);
                System.out.println(localDate);

                System.out.println("повтор");

                int x = scanner.nextInt();
                if (x == 1) {
                    DailyTask task = new DailyTask(title, type, localDate.atTime(12, 00), description);
                    taskService.add(task);
                }
                System.out.println(taskService);
            } else {
                break;
            }
        }

    }
}
