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

    @Column(name="is_done",nullable=false)
    private boolean done;

    @Builder
    public Todo(String content){
        this.content=content;
        this.done=false;
    }

    public void updateContent(String content){
        this.content=content;
    }

    public void updateDone(boolean done){
        this.done=done;
    }

}
