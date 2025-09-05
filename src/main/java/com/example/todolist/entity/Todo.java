package com.example.todolist.entity;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",updatable=false)
    private Long id;

    @Column(name="content",nullable = false)
    private String content;

    @Builder
    public Todo(String content){
        this.content=content;
    }

}
