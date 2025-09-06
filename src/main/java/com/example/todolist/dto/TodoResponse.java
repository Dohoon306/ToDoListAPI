package com.example.todolist.dto;


import com.example.todolist.entity.Todo;
import lombok.Getter;

@Getter
public class TodoResponse {
    private Long id;
    private String content;
    private boolean done;

    public TodoResponse(Todo todo){
        this.id=todo.getId();
        this.content=todo.getContent();
        this.done=todo.isDone();
    }
}
