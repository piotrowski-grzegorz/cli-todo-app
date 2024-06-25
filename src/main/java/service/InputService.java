package service;

import model.Priority;
import model.Size;
import model.Status;

import java.time.LocalDate;
import java.util.Scanner;

import static java.lang.System.in;

public class InputService {
    Scanner scanner;
    public InputService(){
        scanner = new Scanner(System.in);

    }
    public Status setStatusInput() {
        System.out.print("GIVE STATUS - T FOR TODO AND D FOR DONE: ");
        String setStatusString = scanner.next();
        return switch (setStatusString) {
            case "T" -> Status.TODO;
            case "D" -> Status.DONE;
            default -> null;
        };
    }

    public String setTaskNameInput() {
        ValidationService validationService = new ValidationService();
        Scanner userInput = new Scanner(in);
        System.out.println("---GIVE TASK NAME");
        String input = userInput.nextLine();

        while(validationService.checkIfStringIsNotTooLong(input, 10)) {
            System.out.println("To long name try again");
            input = scanner.next();
        }
        return input;
    }

    public Priority setPriorityInput() {
        System.out.print("GIVE PRIORITY - L FOR LOW AND H FOR HIGH: ");
        String setPriorityString = scanner.next();
        return switch (setPriorityString) {
            case "L" -> Priority.LOW;
            case "N" -> Priority.NORMAL;
            case "H" -> Priority.HIGH;
            default -> null;
        };
    }

    public String setTagsInput(){
        System.out.print("GIVE TAGS: ");
        String setTags = scanner.next();
        scanner.nextLine();
        return setTags;
    }

    public LocalDate setCreateDateInput() {
        System.out.print("GIVE CREATE DATE - N for now() or C for create: ");
        String input = scanner.nextLine();
        LocalDate setDate = LocalDate.now();
        switch (input) {
            case "N":
                return setDate;
            case "C":
                System.out.print("YEAR FOR CREATE DATE: ");
                int setYear = scanner.nextInt();
                System.out.print("MONTH FOR CREATE DATE: ");
                int setMonth = scanner.nextInt();
                System.out.print("DAY FOR CREATE DATE: ");
                int setDay = scanner.nextInt();
                setDate = LocalDate.of(setYear,setMonth,setDay);

        }
        return setDate;

    }

    public LocalDate setDueDateInput() {
        System.out.println("GIVE DUE DATE");
        System.out.print("YEAR FOR DUE DATE: ");
        int setYear = scanner.nextInt();
        System.out.print("MONTH FOR DUE DATE: ");
        int setMonth = scanner.nextInt();
        System.out.print("DAY FOR DUE DATE: ");
        int setDay = scanner.nextInt();
        return LocalDate.of(setYear,setMonth,setDay);
    }

    public Size setSizeInput(){
        System.out.print("GIVE SIZE - S FOR SMALL, M FOR MEDIUM, B FOR BIG: ");
        String setSizeString = scanner.next();
        return switch (setSizeString) {
            case "S" -> Size.SMALL;
            case "M" -> Size.MEDIUM;
            case "B" -> Size.BIG;
            default -> null;
        };
    }
}
