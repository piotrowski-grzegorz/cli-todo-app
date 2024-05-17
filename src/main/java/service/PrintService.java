package service;

public class PrintService {
    void printMyMenu() {
        printSeparatingLine();
        System.out.println("TYPE 1 TO ADD | TYPE 2 TO UPDATE | TYPE 3 TO REMOVE | 4 TO EXIT");
    }

    void printSeparatingLine() {
        System.out.println("------------------------------------------------------------");
    }

    void printColumnNames() {
        printSeparatingLine();
        System.out.printf("%-5s %-20s %-20s %-20s%n", "KEY", "NAME OF TASK", "DESCRIPTION", "STATUS");
        printSeparatingLine();
    }
}
