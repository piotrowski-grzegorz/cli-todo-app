package service;

import utils.IntegerAsker;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class StartService {
    private final TaskService taskService;
    private final PrintService printService;
    private final IntegerAsker integerAsker;
    private final InputService inputService;
    private boolean isRunning = true;
    Scanner scanner;

    public StartService() {
        integerAsker = new IntegerAsker(in, out);
        taskService = new TaskService();
        printService = new PrintService();
        inputService = new InputService();
        scanner = new Scanner(in);
    }



    public void startApp() throws InterruptedException {
        boolean isInvalid;
        System.out.println("WELCOME TO MY TO-DO APP VERSION 1.1");
        Thread.sleep(1000);
        do {
            isInvalid = false;

            try {
                while (isRunning) {
                    printService.printMyMenu();
                    taskService.checkIfListIsEmpty();
                    taskService.getTable();
                    System.out.print("--CHOOSE:");
                    int input = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println(input);
                    switch (input) {
                        case 1:
                            taskService.addRecord(inputService.setTaskNameInput());
                            break;
                        case 2:
                            taskService.updateRecord(taskService.checkIfTheKeyOfTaskIsWithinRange(integerAsker));
                            break;
                        case 3:
                            taskService.removeRecord(taskService.checkIfTheKeyOfTaskIsWithinRange(integerAsker));
                            break;
                        case 4:
                            System.out.println("BYE BYE");
                            isRunning = false;
                            break;
                        default:
                            System.out.println("WRONG NUMBER! - CHOOSE AGAIN");
                            break;

                    }

                }
            } catch (Exception e) {
                isInvalid = true;
                System.out.println("IT'S NOT AN INT! - CHOOSE AGAIN :");
                scanner.next();
            }

        } while (isInvalid);

    }

}
