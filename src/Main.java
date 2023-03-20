import java.time.LocalDate;
import java.time.Month;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IncorrectArgumentException, TaskNotFoundException {
        Scanner scanner = new Scanner(System.in);
        TaskService taskService = new TaskService();
        LocalDate localDate = LocalDate.now();

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
        taskService.add(task1);
        taskService.add(task2);
        System.out.println(task1.appearsln(LocalDate.of(2023, 03, 30)));
        taskService.getAllByDate(LocalDate.of(2023, 03, 30));


        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1 - создать задачу");
            System.out.println("2 - Удалить задачу");
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
                    DailyTask task = new DailyTask(title, type, localDate.atTime(12, 00), description);
                    taskService.add(task);
                } else if (x == 2) {
                    WeeklyTask weeklyTask = new WeeklyTask(title, type, localDate.atTime(12, 00), description);
                    taskService.add(weeklyTask);
                } else if (x == 3) {
                    MonthlyTask monthlyTask = new MonthlyTask(title, type, localDate.atTime(12, 00), description);
                    taskService.add(monthlyTask);
                } else if (x == 4) {
                    YearlyTask yearlyTask = new YearlyTask(title, type, localDate.atTime(12, 00), description);
                    taskService.add(yearlyTask);
                } else if (x == 5) {
                    OneTimeTask oneTimeTask = new OneTimeTask(title, type, localDate.atTime(12, 00), description);
                    taskService.add(oneTimeTask);
                }
                System.out.println(taskService);
            } else if (y == 2){
                System.out.println("Введите id задачи, которую нужно удалить.");
                int d = scanner.nextInt();
                taskService.remove(d);
                taskService.removedTasks();
            }

            else if (y == 0) {
                break;
            }
        }

    }
}
