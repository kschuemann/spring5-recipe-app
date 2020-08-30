package guru.springframework.controllers;

import guru.springframework.domain.Todo;
import guru.springframework.services.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.SessionScope;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RequestMapping("/todos")
@Controller
@SessionScope
public class TodosController {

    private final TodoService todoService;
    private List<Todo> currentTodos;

    public TodosController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public String standardPostMethod(Model model){
        return listTodos(model);
    }

    @RequestMapping({"", "/", "/todos/todos", "/todos/todos.html"})
    public String listTodos(Model model) {
        currentTodos = todoService.getAllTodos();
        model.addAttribute("todos", currentTodos); // attribute for list in thymeleaf / html
        return "todos/todos";
    }

    @RequestMapping("/show/{id}")
    public String showById(@PathVariable String id, Model model){
        model.addAttribute("todo", todoService.findById(Long.valueOf(id)));
        return "todos/show";
    }

    @GetMapping("/new")
    public String newTodo(Model model) {
        Date date = new Date(System.currentTimeMillis());
        model.addAttribute("todo", new Todo("", date, date));
        return "todos/todoform"; // where the html is
    }

    @PostMapping("/new")
    public String processCreationForm(@Valid Todo todo, BindingResult result) {
        if (result.hasErrors()) {
            return "todos/todoform";
        } else {
            this.todoService.saveTodo(todo);
            return "redirect:/todos";
        }
    }

    @GetMapping("/edit/{id}")
    public String newTodo(@PathVariable Long id, Model model) {
        Todo todo = todoService.findById(id);
        model.addAttribute("todo", todo);
        return "todos/todoform"; // where the html is
    }

    @PostMapping("/edit/{id}")
    public String editTodo(@Valid Todo editTodo, BindingResult result) {
        if (result.hasErrors()) {
            return "todos/todoform";
        } else {
            this.todoService.saveTodo(editTodo);
            return "redirect:/todos";
        }
    }
}
