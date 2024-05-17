package service;
import java.util.Scanner;

public class StartService {
    private final TaskService taskService;
    private final PrintService printService;
    public Scanner scanner;

    public StartService() {
        taskService = new TaskService();
        printService = new PrintService();
        scanner = new Scanner(System.in);
    }

    public String getTaskNameFromUser() {
        System.out.println("---GIVE TASK NAME");
        return scanner.nextLine();
    }

    public String getDescriptionNameFromUser() {
        System.out.println("---GIVE DESC NAME");
        return scanner.nextLine();
    }

    public int getKeyFromUser() {
        System.out.println("---GIVE KEY OF TASK");
        int key = scanner.nextInt();
        scanner.nextLine();
        return key;
    }

    public void startApp() throws InterruptedException {
        boolean isInvalid;
        System.out.println("test: give input");
        System.out.println("WELCOME TO MY TO-DO APP VERSION 1.0");
        Thread.sleep(1000);
        do {
            isInvalid = false;
            boolean isRunning = true;
            try {
                printService.printMyMenu();
                while (isRunning) {
                    taskService.getTable();
                    System.out.print("--CHOOSE:");
                    int input = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println(input);
                    switch (input) {
                        case 1:
                            taskService.addRecord(getTaskNameFromUser(), getDescriptionNameFromUser());
                            break;
                        case 2:
                            taskService.updateRecord(getKeyFromUser(), getTaskNameFromUser(), getDescriptionNameFromUser());
                            break;
                        case 3:
                            taskService.removeRecord(getKeyFromUser());
                            break;
                        case 4:
                            System.out.println("BYE BYE");
                            isRunning = false;
                            break;
                        default:
                            System.out.println("hello from default");
                            isRunning = false;
                            break;

                    }

                }
            } catch (Exception e) {
                isInvalid = true;
                System.out.println("WRONG NUMBER - CHOOSE AGAIN :");
                scanner.next();
            }

        } while (isInvalid);

    }
}
