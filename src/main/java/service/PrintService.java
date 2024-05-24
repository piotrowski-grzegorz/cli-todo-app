package service;

public class PrintService {
    void printMyMenu() {
        printSeparatingLine();
        System.out.println("TYPE 1 TO ADD | TYPE 2 TO UPDATE | TYPE 3 TO REMOVE | TYPE 4 TO EXIT");
        printSeparatingLine();
    }

    void printSeparatingCrossLine() {
        System.out.println("+-----+---------------+----------+---------------+---------------+---------------+---------------+-----------+");
    }

    void printSeparatingLine() {
        System.out.println("+------------------------------------------------------------------------------------------------------------+");
    }

    void printColumnNames() {
        printSeparatingLine();
        System.out.printf("%-5s %-15s %-10s %-15s %-15s %-15s %-15s %-11s %s%n", "| KEY", "| NAME OF TASK", "| SIZE", "| PRIORITY", "| TAGS ", "| CREATE DATE", "| DUE DATE", "| STATUS", "|");
        printSeparatingCrossLine();
    }


}
