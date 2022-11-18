package com.todo.module.todo;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class TodoData {
    private long key;
    private String title;
    private String date;
    private boolean finished;

    private static int index = 0;

    public TodoData(String title, String date) {
        this.key = Long.parseLong(String.valueOf(index++) + System.currentTimeMillis());
        this.title = title;
        this.date = date;
        this.finished = false;

        index %= 10;
    }
}
