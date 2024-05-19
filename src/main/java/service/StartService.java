package service;

import utils.IntegerAsker;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class StartService {
    private final TaskService taskService;
    private final PrintService printService;
    private final IntegerAsker integerAsker;
    Scanner scanner;

    public StartService() {
        integerAsker = new IntegerAsker(in,out);
        taskService = new TaskService();
        printService = new PrintService();
        scanner = new Scanner(in);
    }

    public String getTaskNameFromUser() {
        Scanner userInput = new Scanner(in);
        System.out.println("---GIVE TASK NAME");
        return userInput.nextLine();
    }

    public String getDescriptionNameFromUser() {
        Scanner userInput = new Scanner(in);
        System.out.println("---GIVE DESC NAME");
        return userInput.nextLine();
    }

//    public int getKeyFromUser() {
//        Scanner userInput = new Scanner(System.in);
//        System.out.println("---GIVE KEY OF TASK");
//        int key = userInput.nextInt();
//        userInput.nextLine();
//        return key;
//    }

    public int getBoundIntegerFromUser(IntegerAsker asker) {
        int input = asker.ask("Give a number between 1 and 10");
        while (input < 1 || input > 10)
            input = asker.ask("Wrong number, try again.");
        return input;
    }



    public void startApp() throws InterruptedException {
        boolean isInvalid;
        System.out.println("WELCOME TO MY TO-DO APP VERSION 1.0");
        Thread.sleep(1000);
        do {
            isInvalid = false;
            boolean isRunning = true;
            try {
                while (isRunning) {
                    printService.printMyMenu();
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
                            taskService.updateRecord(getBoundIntegerFromUser(integerAsker), getTaskNameFromUser(), getDescriptionNameFromUser());
                            break;
                        case 3:
                            taskService.removeRecord(getBoundIntegerFromUser(integerAsker));
                            break;
                        case 4:
                            taskService.updateStatus(getBoundIntegerFromUser(integerAsker));
                            break;
                        case 5:
                            taskService.updateDate(getBoundIntegerFromUser(integerAsker));
                            break;
                        case 6:
                            taskService.updatePriority(getBoundIntegerFromUser(integerAsker));
                            break;
                        case 7:
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
