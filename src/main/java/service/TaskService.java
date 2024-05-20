package service;

import model.Priority;
import model.Status;
import model.Task;
import utils.IntegerAsker;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class TaskService {

    public final HashMap<Integer, Task> DATA_BASE;
    private final AtomicInteger keyGenerator;
    private final PrintService printService;
    Scanner scanner;

    public TaskService() {
        printService = new PrintService();
        scanner = new Scanner(System.in);
        DATA_BASE = new HashMap<>();
        keyGenerator = new AtomicInteger(1);
    }

    public void getTable() {
        printService.printColumnNames();
        System.out.println(DATA_BASE
                .entrySet()
                .stream()
                .map(entry ->
                        String.format(
                                "%-5s %-15s %-20s %-15s %-15s %s",
                                entry.getKey(),
                                entry.getValue().getName(),
                                entry.getValue().getDescription(),
                                entry.getValue().getStatus(),
                                entry.getValue().getDate(),
                                entry.getValue().getPriority()
                                        ))
                .collect(Collectors.joining("\n")));

        printService.printSeparatingLine();

    }

    public void addRecord(String taskName, String description) {
        try {
            Task task1 = new Task(taskName, description);
            task1.setStatus(Status.TODO);
            task1.setDate(LocalDate.now());
            task1.setPriority(Priority.LOW);
            int key = generateKey();
            DATA_BASE.put(key, task1);

        } catch (InputMismatchException e) {
            System.out.println("-----Something went wrong.");
        }

    }

    public void removeRecord(int key) {
        if (DATA_BASE.containsKey(key)) {
            DATA_BASE.remove(key);
        } else System.out.println("-----NO KEY FOUND");
    }

    public void updateRecord(Integer id, String taskName, String description) {
        if(DATA_BASE.containsKey(id)) {
            Task task = new Task(taskName, description);
            LocalDate date = DATA_BASE.get(id).getDate();
            Priority priority = DATA_BASE.get(id).getPriority();
            task.setDate(date);
            task.setPriority(priority);
            DATA_BASE.put(id, task);

            updateStatus(id);

        } else System.out.println("-----NO KEY FOUND");
    }

    public void updateStatus(int key) {
            Task task = DATA_BASE.get(key);
            switch (task.getStatus()) {
                case TODO:
                    task.setStatus(Status.DONE);
                    break;
                case DONE:
                case null:
                    task.setStatus(Status.TODO);
                    break;
                default:
                    System.out.println("something wrong with updating status");
            }

        }
    public void updatePriority(int key)  {
        Task task = DATA_BASE.get(key);
        switch (task.getPriority()) {
            case LOW:
                task.setPriority(Priority.HIGH);
                break;
            case HIGH:
            case null:
                task.setPriority(Priority.LOW);
                break;
            default:
                System.out.println("something wrong with updating priority");
        }
    }

    public void updateDate(int key) {
        Task task = DATA_BASE.get(key);
        Scanner dateInput = new Scanner(System.in);
        boolean isInvalid;
        do {
            isInvalid = false;
            try {
                System.out.println("---GIVE YEAR");
                int year = dateInput.nextInt();
                System.out.println("---GIVE MONTH BETWEEN 1 TO 12");
                int month = dateInput.nextInt();
                System.out.println("---GIVE DAY BETWEEN 1 TO 31");
                int day = dateInput.nextInt();
                task.setDate(LocalDate.of(year, month, day));
            } catch (Exception e) {
                isInvalid = true;
                System.out.println("Wrong date format try again");
            }
        } while (isInvalid);
    }
    public Integer getFirstKeyFromDatabase() {
        return DATA_BASE.entrySet().stream().findFirst().get().getKey();
    }

     int generateKey() {
        return keyGenerator.getAndIncrement();
    }

    void checkIfListIsEmpty() {
        if (DATA_BASE.isEmpty()) {
            System.out.println("YOUR LIST IS EMPTY ! ADD SOMETHING :)");
        }
    }




//todo
    public int getBoundIntegerFromUser2(IntegerAsker asker) {
        int input = asker.ask("Give a number between  and " );
        while (input < 1 || input > 10)
            input = asker.ask("Wrong number, try again.");
        return input;
    }

    public boolean checkIfStringIsNotToLong(String input) {
        return input.length() <= 11;
    }







}


