package com.example.todolist.dto;


import com.example.todolist.entity.Todo;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class AddTodoContent {

    private String content;

    public Todo toEntity(){
        return Todo.builder()
                .content(content)
                .build();
    }
}
