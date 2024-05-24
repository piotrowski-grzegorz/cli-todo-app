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
        Status setStatus = null;
        switch (setStatusString) {
            case "T":
                setStatus = Status.TODO;
                break;
            case "D":
                setStatus = Status.DONE;
                break;
        }
        return setStatus;
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
        Priority setPriority = Priority.NORMAL;
        switch (setPriorityString) {
            case "L":
                setPriority = Priority.LOW;
                System.out.println(setPriority);
                break;
            case "N":
                break;
            case "H":
                setPriority = Priority.HIGH;
                break;
        }
        return setPriority;
    }

    public String setTagsInput(){
        System.out.print("GIVE TAGS: ");
        String setTags = scanner.next();
        scanner.nextLine();
        return setTags;
    }

    public LocalDate setCreateDateInput() {
        System.out.println("GIVE CREATE DATE");
        System.out.print("YEAR: ");
        int setYear = scanner.nextInt();
        System.out.print("MONTH: ");
        int setMonth = scanner.nextInt();
        System.out.print("DAY: ");
        int setDay = scanner.nextInt();
        LocalDate setCreateDate = LocalDate.of(setYear,setMonth,setDay);
        return setCreateDate;
    }

    public LocalDate setDueDateInput() {
        System.out.println("GIVE DUE DATE");
        System.out.print("YEAR: ");
        int setYear = scanner.nextInt();
        System.out.print("MONTH: ");
        int setMonth = scanner.nextInt();
        System.out.print("DAY: ");
        int setDay = scanner.nextInt();
        LocalDate setDueDate = LocalDate.of(setYear,setMonth,setDay);
        return setDueDate;
    }

    public Size setSizeInput(){
        System.out.print("GIVE SIZE - S FOR SMALL, M FOR MEDIUM, B FOR BIG: ");
        String setSizeString = scanner.next();
        Size setSize = Size.SMALL;
        switch (setSizeString) {
            case "S":
                setSize = Size.SMALL;
                break;
            case "M":
                setSize = Size.MEDIUM;
                break;
            case "B":
                setSize = Size.BIG;
                break;
        }
        return setSize;
    }
}
