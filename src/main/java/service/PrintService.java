package service;

public class PrintService {
    void printMyMenu() {
        printSeparatingLine();
        System.out.println("TYPE 1 TO ADD | TYPE 2 TO UPDATE | TYPE 3 TO REMOVE | 4 TO UPDATE STATUS | 5 TO SET DATE");
        System.out.println("TYPE 6 CHANGE PRIORITY | TYPE 7 EXIT ");
        printSeparatingLine();
    }

    void printSeparatingLine() {
        System.out.println("-----------------------------------------------------------------------------------------");
    }

    void printColumnNames() {
        printSeparatingLine();
        System.out.printf("%-5s %-15s %-20s %-15s %-15s %-20s%n", "KEY", "NAME OF TASK", "DESCRIPTION", "STATUS", "TERM", "PRIORITY");
        printSeparatingLine();
    }
}
