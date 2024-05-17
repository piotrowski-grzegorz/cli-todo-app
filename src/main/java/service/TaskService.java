package service;

import model.Task;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class TaskService {

    public final HashMap<Integer, Task> db;
    private final AtomicInteger keyGenerator;
    private final PrintService printService;
    public Scanner scanner;

    public TaskService() {
        printService = new PrintService();
        scanner = new Scanner(System.in);
        db = new HashMap<>();
        keyGenerator = new AtomicInteger(1);
    }

    public void getTable() {
        printService.printSeparatingLine();
        System.out.printf("%-5s %-20s %-20s%n", "KEY", "NAME OF TASK", "DESCRIPTION");
        printService.printSeparatingLine();
        System.out.println(db
                .entrySet()
                .stream()
                .map(entry ->
                        String.format(
                                "%-5s %-20s %s",
                                entry.getKey(),
                                entry.getValue().getName(),
                                entry.getValue().getDescription()))
                .collect(Collectors.joining("\n")));

        printService.printSeparatingLine();

    }

    public void addRecord(String taskName, String description) {
        try {
            Task task1 = new Task(taskName, description);
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
        Task task = new Task(taskName, description);
        db.put(id, task);
    }

    public int generateKey() {
        return keyGenerator.getAndIncrement();
    }

}


