import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskService taskService = new TaskService();
        LocalDate localDate = LocalDate.now();
        LocalDateTime localTime = LocalDateTime.now();

        DailyTask task1 = new DailyTask("Ежедневная"
                , Type.valueOf("WORK")
                , LocalDate.of(2023, Month.MARCH
                , 2).atStartOfDay()
                , "чистка зубов");
        YearlyTask task2 = new YearlyTask("Годовая"
                , Type.valueOf("PERSONAL")
                , LocalDate.of(2022, Month.MARCH
                , 21).atStartOfDay()
                , "чистка");
        OneTimeTask task3 = new OneTimeTask("Разовая"
                , Type.valueOf("PERSONAL")
                , LocalDate.of(2022, Month.MARCH
                , 5).atStartOfDay()
                , "чистка");
        WeeklyTask task4 = new WeeklyTask("Недельная"
                , Type.valueOf("PERSONAL")
                , LocalDate.of(2023, Month.MARCH
                , 6).atStartOfDay()
                , "чистка");
        MonthlyTask task5 = new MonthlyTask("Месячная"
                , Type.valueOf("PERSONAL")
                , LocalDate.of(2023, Month.FEBRUARY
                , 20).atStartOfDay()
                , "чистка");
        taskService.add(task1);
        taskService.add(task2);
        taskService.add(task3);
        taskService.add(task4);
        taskService.add(task5);
        taskService.allTaskSortedDate(localDate);


        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1 - создать задачу");
            System.out.println("2 - Удалить задачу");
            System.out.println("3 - получить задачи на сегодня");
            System.out.println("4 - получить задачи на определённую дату");
            System.out.println("5 - изменить задачу");
            System.out.println("6 - получить отсортированный список всех задач");
            System.out.println("0 - остановить программу");

            int y = scanner.nextInt();
            if (y == 1) {
                String fix1 = scanner.nextLine(); // временная фича пропуска ввода задачи
                System.out.println("Название задачи");
                String title = scanner.nextLine();
                System.out.println(title);

                System.out.println("Тип задачи: 1 - личная, 2 - рабочая");
                int z = scanner.nextInt();
                Type type = Type.DEFOLT;
                if (z == 1) {
                    type = Type.PERSONAL;
                    System.out.println(type);
                } else if (z == 2) {
                    type = Type.WORK;
                    System.out.println(type);
                }
                String fix = scanner.nextLine(); // временная фича пропуска ввода задачи
                System.out.println("Описание");
                String description = scanner.nextLine();
                System.out.println(description);

                System.out.println("дата");
                int year = scanner.nextInt();
                int month = scanner.nextInt();
                int day = scanner.nextInt();
                LocalDate local = LocalDate.of(year, month, day);
                System.out.println(local);

                System.out.println("переодичность задачи");
                System.out.println("1 - ежедневная ");
                System.out.println("2 - еженедельная ");
                System.out.println("3 - ежемесячная ");
                System.out.println("4 - ежегодная ");
                System.out.println("5 - разовая ");

                int x = scanner.nextInt();
                if (x == 1) {
                    DailyTask task = new DailyTask(title, type, localDate.atTime(localTime.getHour(), localTime.getMinute()), description);
                    taskService.add(task);
                } else if (x == 2) {
                    WeeklyTask weeklyTask = new WeeklyTask(title, type, localDate.atTime(localTime.getHour(), localTime.getMinute()), description);
                    taskService.add(weeklyTask);
                } else if (x == 3) {
                    MonthlyTask monthlyTask = new MonthlyTask(title, type, localDate.atTime(localTime.getHour(), localTime.getMinute()), description);
                    taskService.add(monthlyTask);
                } else if (x == 4) {
                    YearlyTask yearlyTask = new YearlyTask(title, type, localDate.atTime(localTime.getHour(), localTime.getMinute()), description);
                    taskService.add(yearlyTask);
                } else if (x == 5) {
                    OneTimeTask oneTimeTask = new OneTimeTask(title, type, localDate.atTime(localTime.getHour(), localTime.getMinute()), description);
                    taskService.add(oneTimeTask);
                }
            } else if (y == 2) {
                System.out.println("Введите id задачи, которую нужно удалить.");
                int d = scanner.nextInt();
                taskService.remove(d);
                taskService.removedTasks();
            } else if (y == 3) {
                taskService.getAllByDate(localDate);
            } else if (y == 4) {
                System.out.println("Введите день");
                int day = scanner.nextInt();
                System.out.println("Введите месяц");
                int month = scanner.nextInt();
                System.out.println("Введите год");
                int year = scanner.nextInt();

                taskService.getAllByDate(LocalDate.of(year, month, day));

            }else if(y == 5){
                System.out.println("Введите id задачи, которую хотите изменить.");
                int id = scanner.nextInt();

                System.out.println("");

            } else if (y==6){
                taskService.allTaskSortedDate(localDate);
            }
            else if (y == 0) {
                break;
            }
        }

    }
}
