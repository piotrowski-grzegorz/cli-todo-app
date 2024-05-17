package model;
import lombok.*;

@Getter
@Setter
public class Task {
    private String name;
    private String description;
    private Status status;

    public Task(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
