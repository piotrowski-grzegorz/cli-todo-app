package service;
import model.Status;
import model.Task;
import utils.IntegerAsker;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class TaskService {

    public final HashMap<Integer, Task> DATA_BASE;
    private final AtomicInteger keyGenerator;
    private final PrintService printService;
    private final InputService inputService;
    Scanner scanner;

    public TaskService() {
        printService = new PrintService();
        scanner = new Scanner(System.in);
        inputService = new InputService();
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
                                "%-2s %-2s %-1s %-13s %-1s %-8s %-1s %-13s %-1s %-13s %-1s %-13s %-1s %-13s %-1s %-9s %s",
                                "|",
                                entry.getKey(),
                                "|",
                                entry.getValue().getName(),
                                "|",
                                entry.getValue().getSize(),
                                "|",
                                entry.getValue().getPriority(),
                                "|",
                                entry.getValue().getTags(),
                                "|",
                                entry.getValue().getCreateDate(),
                                "|",
                                entry.getValue().getDueDate(),
                                "|",
                                entry.getValue().getStatus(),
                                "|"
                                        ))
                .collect(Collectors.joining("\n")));

        printService.printSeparatingCrossLine();

    }

    public void addRecord(String taskName) {
        try {
            int key = generateKey();
            var priorityInput = inputService.setPriorityInput();
            var sizeInput = inputService.setSizeInput();
            var tagsInput = inputService.setTagsInput();
            var createDateInput = inputService.setCreateDateInput();
            var dueDateInput = inputService.setDueDateInput();


            Task task = new Task.Builder(taskName)
                    .priority(priorityInput)
                    .size(sizeInput)
                    .tags(tagsInput)
                    .createDate(createDateInput)
                    .dueDate(dueDateInput)
                    .status(Status.TODO)
                    .build();

            DATA_BASE.put(key, task);

        } catch (InputMismatchException e) {
            System.out.println("-----Something went wrong.");
        }

    }

    public void removeRecord(int key) {
        if (DATA_BASE.containsKey(key)) {
            DATA_BASE.remove(key);
        } else System.out.println("-----NO KEY FOUND");
    }

    public void updateRecord(int id) {
        try {
            var nameInput = inputService.setTaskNameInput();
            var priorityInput = inputService.setPriorityInput();
            var sizeInput = inputService.setSizeInput();
            var tagsInput = inputService.setTagsInput();
            var createDateInput = inputService.setCreateDateInput();
            var dueDateInput = inputService.setDueDateInput();
            var statusInput = inputService.setStatusInput();

            if(DATA_BASE.containsKey(id)) {
                System.out.println("GIVE DATA TO UPDATE");
                Task task = new Task.Builder(nameInput)
                        .priority(priorityInput)
                        .size(sizeInput)
                        .tags(tagsInput)
                        .createDate(createDateInput)
                        .dueDate(dueDateInput)
                        .status(statusInput)
                        .build();

                DATA_BASE.put(id, task);
            } else System.out.println("-----NO KEY FOUND");
        } catch (Exception e) {
            System.out.println("Something wrong with update");
        }
    }

    void getAllTasksByPriority(){};
    void getAllTasksBySize(){};
    void getAllTasksByStatus(){};
    void getAllTaskByDateInterval(){};

     int generateKey() {
        return keyGenerator.getAndIncrement();
    }

    void checkIfListIsEmpty() {
        if (DATA_BASE.isEmpty()) {
            System.out.println("YOUR LIST IS EMPTY ! ADD SOMETHING :)");
        }


    }

    public int checkIfTheKeyOfTaskIsWithinRange(IntegerAsker asker) {
        int input = asker.ask("Give one number from  " + DATA_BASE.keySet());
        while (!DATA_BASE.containsKey(input))
            input = asker.ask("Wrong number, try again.");
        return input;
    }

}


