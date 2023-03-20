import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TaskService {
    private HashMap<Integer, Task> taskMap = new HashMap<>();
    private List<Task> removedTasks = new LinkedList<>();


    public void add(Task task) {
        taskMap.put(task.getId(), task);
    }

    public Task remove(int id) throws TaskNotFoundException {
        if (!taskMap.containsKey(id)) {
            throw new TaskNotFoundException("Задачи под номером " + id + " не существует");
        }

        removedTasks.add(getTaskMap().get(id));
        return taskMap.remove(id);
    }

    public void getAllByDate(LocalDate localDate) {
        Map<Integer, Task> list = taskMap.entrySet().stream()
                .filter(x -> x.getValue().appearsln(localDate))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        for (Map.Entry<Integer, Task> list1 :
                list.entrySet()) {
            System.out.println("Задача N: " + list1.getKey() + ", " + list1.getValue());
        }

    }

    public void allTaskSortedDate(LocalDate localDate) {
        Map<Integer, Task> list = taskMap.entrySet().stream()
                .filter(x -> x.getValue().appearsln(localDate))
                .sorted(Comparator.comparingInt(o -> (o.getValue().getDataTime().getDayOfYear())))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        for (Map.Entry<Integer, Task> list1 :
                list.entrySet()) {
            System.out.println("Задача N: " + list1.getKey() + ", " + list1.getValue());
        }
        System.out.println(list);
//        List <Map.Entry<Integer, Task>> valuesList = new ArrayList(taskMap.entrySet());
//        Collections.sort(valuesList, Comparator.comparingInt(o -> (o.getValue().getDataTime().getDayOfYear())));
//
    }

    public HashMap<Integer, Task> getTaskMap() {
        return taskMap;
    }

    public void removedTasks() {
        System.out.println("Удалённые задачи:");
        System.out.println(removedTasks);
    }

    @Override
    public String toString() {
        return "Карта задач " + taskMap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskService that = (TaskService) o;
        return Objects.equals(taskMap, that.taskMap) && Objects.equals(removedTasks, that.removedTasks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskMap, removedTasks);
    }
}
