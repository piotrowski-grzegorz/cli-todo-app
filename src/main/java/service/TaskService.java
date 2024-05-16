package service;

import model.Task;
import repository.ToDo;
import lombok.ToString;
import utils.Validation;

import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

@ToString
public class TaskService implements ToDo {

    public final HashMap<Integer, Task> db;
    private boolean isRunning;
    private final AtomicInteger keyGenerator;
    private final Scanner scanner;
    public TaskService() {
         scanner = new Scanner(System.in);
         db = new HashMap<>();
         keyGenerator = new AtomicInteger(1);
    }
    public void printMap() {
//        db.forEach((key, value) -> System.out.println(key + " " + value));
        db.forEach((key, value) -> System.out.println(String.format("%5s %5s %5s", key, "|", value)));
    }

    public void printInvoiceHeader() {
        System.out.println(String.format("%5s %1s %15s %5s %25s", "Key", "|", "Name of task", "|", "Description of task"));
        System.out.println(String.format("%s", "----------------------------------------------------------------------------------------------------------------"));
    }

    @Override
    public void addRecord(String taskName, String description) {
        Task task1 = new Task(taskName, description);
        int key = generateKey();
        db.put(key, task1);
        System.out.println("RECORD ADDED");
    }

    @Override
    public void removeRecord(int key) {
        if(db.containsKey(key)) {
            db.remove(key);
            System.out.println("RECORD REMOVED");
        } else System.out.println("NO KEY FOUND");
    }

    @Override
    public void updateRecord(Integer id, String taskName, String description) {
        Task task = new Task(taskName, description);
        db.put(id,task);
        System.out.println("RECORD UPDATED");

    }

    @Override
    public void getAllRecords() {
        System.out.println("MY TASKS: " + db);

    }

    public HashMap<Integer,Task> getDb() {
        return db;
    }

    @Override
    public void findRecordByName() {

    }

    @Override
    public void exitApp() {
        isRunning = false;
        System.out.println("BYE BYE");

    }



    @Override
    public void startApp() throws InterruptedException {
        Validation valid = new Validation();
        System.out.println("WELCOME TO MY TO-DO APP");

        isRunning = true;
        while (isRunning) {
            Thread.sleep(1000);
            printMyMenu();
            printInvoiceHeader();
            printMap();
            int input = scanner.nextInt();





            switch (input) {
                case 1:
                    System.out.println("GIVE TASK NAME");
                    scanner.nextLine();
                    String taskName = scanner.nextLine();
                    System.out.println("APPROVED");
                    System.out.println("##################");
                    System.out.println("GIVE DESCRIPTION TO TASK");
                    String description = scanner.nextLine();
                    System.out.println("APPROVED");
                    addRecord(taskName, description);
                    break;
                case 2:
                    System.out.println("GIVE KEY OF TASK TO UPGRADE");
                    int key = scanner.nextInt();
                    System.out.println("GIVE TASK NAME TO UPGRADE");
                    taskName = scanner.next();
                    System.out.println("APPROVED");
                    System.out.println("##################");
                    System.out.println("GIVE DESCRIPTION TO TASK TO UPGRADE");
                    description = scanner.next();
                    System.out.println("APPROVED");
                    updateRecord(key, taskName, description);
                    break;
                case 3:
                    System.out.println("GIVE KEY OF TASK TO REMOVE");
                    key = scanner.nextInt();
                    removeRecord(key);
                    break;
                case 4:
                    exitApp();
                default:
                    valid.printMsgWrongNumberTryAgain(input);
            }
        }
    }

    @Override
    public void printMyMenu() {
        System.out.println("MAIN MENU --------------------------------------------------");
        System.out.println("TYPE 1 TO ADD, TYPE 2 TO UPDATE, TYPE 3 TO REMOVE, 4 TO EXIT");
        System.out.println("------------------------------------------------------------");

    }

    void clearScreen() {
        System.out.println("############################################");
        }

    public int generateKey() {
        return keyGenerator.getAndIncrement();
    }



}


