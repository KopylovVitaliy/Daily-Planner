import java.time.LocalDate;
import java.time.Month;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IncorrectArgumentException {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, Task> taskMap = new HashMap<>();
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

        taskService.add(task1);
        taskService.add(task2);
        System.out.println(task2.getId());
        System.out.println(task1.getId());
        taskService.print();

        System.out.println("Выберите задачу");
        String title;
        System.out.println("title");
        title = scanner.nextLine();
        Type type;
        System.out.println("type");
        type = Type.valueOf(scanner.nextLine());
        LocalDate localDate;
        System.out.println("дата");
        localDate = LocalDate.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        String disc;
        System.out.println("Описание");
        disc = scanner.nextLine();
        System.out.println("повтор");
        int x = scanner.nextInt();
        if(x == 1){
            DailyTask task = new DailyTask(title, type, localDate.atStartOfDay(), disc);
            taskService.add(task);
        }

        System.out.println(taskService);



    }
}
