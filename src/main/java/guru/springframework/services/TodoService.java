package guru.springframework.services;

import guru.springframework.domain.Recipe;
import guru.springframework.domain.Todo;

import java.util.List;
import java.util.Set;

public interface TodoService {

    List<Todo> getAllTodos();

    List<Todo> getAllByTodoDesc(String desc);

    public void saveTodo(Todo todo);

}
