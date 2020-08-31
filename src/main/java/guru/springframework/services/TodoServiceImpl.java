package guru.springframework.services;

import guru.springframework.domain.Todo;
import guru.springframework.repositories.TodosRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoServiceImpl implements TodoService{

    TodosRepository todosRepository;

    public TodoServiceImpl(TodosRepository todosRepository) {
        this.todosRepository = todosRepository;
    }

    @Override
    public List<Todo> getAllTodos() {
        List<Todo> objects = new ArrayList<>();
        todosRepository.findAll().forEach(e -> objects.add(e));
        return objects;
    }

    @Override
    public List<Todo> getAllByTodoDesc(String desc) {
        // return todosRepository.findById(); TODO
        return null;
    }

    public void saveTodo(Todo todo) {
        todosRepository.save(todo);
    }

    @Override
    public Todo findById(Long id) {
        return todosRepository.findById(id).orElseThrow(() -> new RuntimeException("Nothing found"));
    }

    @Override
    public void deleteTodo(Long id) {
        todosRepository.deleteById(id);
    }
}
