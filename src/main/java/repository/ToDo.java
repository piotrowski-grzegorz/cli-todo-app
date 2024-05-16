package repository;

public interface ToDo {


    void addRecord(String taskName, String description);

    void removeRecord(int key);

    void updateRecord(Integer id, String taskName, String description);

    void getAllRecords();

    void findRecordByName();

    void exitApp();

    void startApp() throws InterruptedException;

    void printMyMenu();




}
