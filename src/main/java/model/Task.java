package model;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class Task {
    private String name;
    private String description;
    private Status status;
    private Priority priority;
    private LocalDate date;


    public Task(String name, String description) {
        this.name = name;
        this.description = description;
    }


}
