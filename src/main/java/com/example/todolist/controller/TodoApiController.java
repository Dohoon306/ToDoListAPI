package com.example.todolist.controller;

import com.example.todolist.dto.AddTodoContent;
import com.example.todolist.dto.TodoResponse;
import com.example.todolist.entity.Todo;
import com.example.todolist.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TodoApiController {

    private final TodoService todoService;

    @PostMapping("/api/todo")
    public ResponseEntity<TodoResponse> addTodo(@RequestBody AddTodoContent request){//자동으로 JSON->dto변환

        Todo savedTodo = todoService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new TodoResponse(savedTodo));
    }

    //전부 조회
    @GetMapping("/api/todos")
    public ResponseEntity<List<TodoResponse>> getAllTodos(){

        List<TodoResponse> savedTodo = todoService.findAll()
                .stream()
                .map(TodoResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(savedTodo);
    }

    //id로 조회
    @GetMapping("/api/todo/{id}")
    public ResponseEntity<TodoResponse> getIdtodos(@PathVariable long id){
        Todo savedTodo = todoService.findById(id);
        return ResponseEntity.ok()
                .body(new TodoResponse(savedTodo));
    }

    @DeleteMapping("/api/todo/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id){
        todoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }



}
