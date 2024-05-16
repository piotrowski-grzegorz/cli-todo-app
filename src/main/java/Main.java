import model.Task;
import service.TaskService;

import java.util.HashMap;
import java.util.List;

public class Main {


    public static void main(String[] args) throws InterruptedException {

//        printInvoiceHeader();
        TaskService toDoApp = new TaskService();
        toDoApp.startApp();
    }
}
