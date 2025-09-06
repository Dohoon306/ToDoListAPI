package com.example.todolist.service;

import com.example.todolist.dto.AddTodoContent;
import com.example.todolist.dto.UpdateTodoContent;
import com.example.todolist.dto.UpdateTodoDone;
import com.example.todolist.entity.Todo;
import com.example.todolist.repository.TodoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    //생성자를 통한 주입
    private final TodoRepository todoRepository;
    public TodoService(TodoRepository todoRepository){
        this.todoRepository=todoRepository;
    }

    public Todo save(AddTodoContent request){
        return todoRepository.save(request.toEntity());
    }

    public List<Todo> findAll(){
        return todoRepository.findAll();
    }

    public Todo findById(long id){
        return todoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Todo not found: " + id));
    }

    public Todo deleteById(long id){
        Todo savedTodo = todoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Todo not found: " + id));
        todoRepository.deleteById(id);
        return savedTodo;
    }

    @Transactional
    public Todo updateContentById(long id, UpdateTodoContent updateTodoContent){
        Todo savedTodo = todoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Todo not found: " + id));
        savedTodo.updateContent(updateTodoContent.getContent());
        return savedTodo;
    }

    //체크박스 표시 업데이트 API
    @Transactional
    public Todo updateDoneById(long id, UpdateTodoDone updateTodoDone){
        Todo savedTodo = todoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Todo not found: " + id));
        savedTodo.updateDone(updateTodoDone.isDone());
        return savedTodo;
    }



}
