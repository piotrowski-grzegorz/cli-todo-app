package model;

import lombok.*;
import service.TaskService;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Task {
    private String name;
    private String description;
//
//    @Override
//    public String toString() {
//        return "Task{" +
//                "name='" + name + '\'' +
//                ", description='" + description + '\'' +
//                '}';
//    }
}
