package model;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class Task {
    private final String name;
    private final Priority priority;
    private final Size size;
    private final String tags;
    private final LocalDate createDate;
    private final LocalDate dueDate;
    private final Status status;

    public static class Builder {
        private final String name;
        private Priority priority;
        private Size size;

        private String tags = "None";
        private LocalDate createDate;
        private LocalDate dueDate;
        private Status status;

        public Builder(String name) {
            this.name = name;

        }

        public Builder priority(Priority val) {
            priority = val;
            return this;
        }
        public Builder size(Size val) {
            size = val;
            return this;
        }

        public Builder tags(String val){
            tags = val;
            return this;
        }

        public Builder createDate(LocalDate val) {
            createDate = val;
            return this;
        }

        public Builder dueDate(LocalDate val) {
            dueDate = val;
            return this;
        }

        public Builder status(Status val) {
            status = val;
            return this;
        }

        public Task build() {
            return new Task(this);
        }

    }

    private Task(Builder builder) {
        name = builder.name;
        priority = builder.priority;
        size = builder.size;
        tags = builder.tags;
        createDate = builder.createDate;
        dueDate = builder.dueDate;
        status = builder.status;
    }





}
