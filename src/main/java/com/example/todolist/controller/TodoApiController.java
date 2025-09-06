package com.example.todolist.controller;

import com.example.todolist.dto.AddTodoContent;
import com.example.todolist.dto.TodoResponse;
import com.example.todolist.dto.UpdateTodoContent;
import com.example.todolist.dto.UpdateTodoDone;
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
    public ResponseEntity<TodoResponse> deleteById(@PathVariable long id){
        Todo savedTodo=todoService.deleteById(id);
        return ResponseEntity.ok().body(new TodoResponse(savedTodo));
    }

    @PatchMapping("/api/todo/{id}/content")
    public ResponseEntity<TodoResponse> updateContentById(
            @PathVariable Long id,
            @RequestBody UpdateTodoContent updateTodoContent)
    {
        Todo savedTodo = todoService.updateContentById(id,updateTodoContent);
        return ResponseEntity.ok().body(new TodoResponse(savedTodo));
    }

    @PatchMapping("/api/todo/{id}/done")
    public ResponseEntity<TodoResponse> updateDoneById(
            @PathVariable Long id,
            @RequestBody UpdateTodoDone updateTodoDone
    ){
        Todo todoResponse=todoService.updateDoneById(id,updateTodoDone);
        return ResponseEntity.ok().body(new TodoResponse(todoResponse));
    }

}
