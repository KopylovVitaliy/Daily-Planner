import java.time.LocalDate;
import java.util.*;

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
        return taskMap.remove(id);
    }

    public void getAllByDate(LocalDate localDate) {
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
