package service;

import model.Status;
import model.Task;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class TaskService {

    public final HashMap<Integer, Task> db;
    private final AtomicInteger keyGenerator;
    private final PrintService printService;
    Scanner scanner;

    public TaskService() {
        printService = new PrintService();
        scanner = new Scanner(System.in);
        db = new HashMap<>();
        keyGenerator = new AtomicInteger(1);
    }

    public void getTable() {
        printService.printColumnNames();
        System.out.println(db
                .entrySet()
                .stream()
                .map(entry ->
                        String.format(
                                "%-5s %-20s %-20s %s",
                                entry.getKey(),
                                entry.getValue().getName(),
                                entry.getValue().getDescription(),
                                entry.getValue().getStatus()))
                .collect(Collectors.joining("\n")));

        printService.printSeparatingLine();

    }

    public void addRecord(String taskName, String description) {
        try {
            Task task1 = new Task(taskName, description);
            task1.setStatus(Status.TODO);
            int key = generateKey();
            db.put(key, task1);

        } catch (InputMismatchException e) {
            System.out.println("-----Something went wrong.");
        }

    }

    public void removeRecord(int key) {
        if (db.containsKey(key)) {
            db.remove(key);
        } else System.out.println("-----NO KEY FOUND");
    }

    public void updateRecord(Integer id, String taskName, String description) {
        if(db.containsKey(id)) {
            Task task = new Task(taskName, description);
            db.put(id, task);
        } else System.out.println("-----NO KEY FOUND");
    }

    public void updateStatus(int key) {
            Task task = db.get(key);
            switch (task.getStatus()) {
                case TODO:
                    task.setStatus(Status.DONE);
                    break;
                case DONE:
                    task.setStatus(Status.TODO);
                    break;
                default:
                    System.out.println("something");
            }

        }

    private int generateKey() {
        return keyGenerator.getAndIncrement();
    }

}


