package com.example.todolist.service;

import com.example.todolist.dto.AddTodoContent;
import com.example.todolist.dto.UpdateTodoContent;
import com.example.todolist.entity.Todo;
import com.example.todolist.repository.TodoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
                .orElseThrow(()->new IllegalArgumentException("not found: "+id));
    }

    public void deleteById(long id){
        todoRepository.deleteById(id);
    }

    @Transactional
    public void updateById(long id, UpdateTodoContent updateTodoContent){
        Todo todo = todoRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("not found: "+id));

        todo.updateContent(updateTodoContent.getContent());
    }


}
