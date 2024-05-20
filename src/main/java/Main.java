import service.StartService;
import service.TaskService;

public class Main {


    public static void main(String[] args) throws InterruptedException {

        StartService service = new StartService();

        service.startApp();

    }

}
