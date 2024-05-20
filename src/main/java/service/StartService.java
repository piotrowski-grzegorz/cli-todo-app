package service;

import utils.IntegerAsker;

import java.util.Scanner;
import java.util.stream.Stream;

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
        String input = userInput.nextLine();

        while(!checkIfStringIsNotTooLong(input, 10)) {
            System.out.println("To long name try again");
            input = scanner.next();
        }
        return input;
    }

    boolean checkIfStringIsNotTooLong(String input, int maxStringLength) {
        if(input.length() > maxStringLength) {
            out.println("The string is too long - max " + maxStringLength + " chars");
            return false;
        } else return true;
    }

    public String getDescriptionNameFromUser() {
        Scanner userInput = new Scanner(in);
        System.out.println("---GIVE DESC NAME");
        String input = userInput.nextLine();

        while(!checkIfStringIsNotTooLong(input,15)) {
            System.out.println("To long name try again");
            input = scanner.next();
        }
        return input;
    }

//    public int getKeyFromUser() {
//        Scanner userInput = new Scanner(System.in);
//        System.out.println("---GIVE KEY OF TASK");
//        int key = userInput.nextInt();
//        userInput.nextLine();
//        return key;
//    }

    public int getBoundIntegerFromUser(IntegerAsker asker) {
        int input = asker.ask("Give one number from  " + taskService.DATA_BASE.keySet());
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
                    taskService.checkIfListIsEmpty();
                    taskService.getTable();
                    System.out.print("--CHOOSE:");
                    int input = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println(input);
                    switch (input) {
                        case 1:
                            taskService.addRecord(getTaskNameFromUser(), getDescriptionNameFromUser());
//                            if(getTaskNameFromUser().length() > 3) {
//                                out.println("once again");
//
//                            }
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
