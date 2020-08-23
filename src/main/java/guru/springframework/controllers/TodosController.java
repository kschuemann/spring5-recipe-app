package guru.springframework.controllers;

import guru.springframework.services.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/todos")
@Controller
public class TodosController {

    private final TodoService todoService;

    public TodosController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping({"", "/", "/todos/todos", "/todos/todos.html"})
    public String listRecipes(Model model) {
        model.addAttribute("todos", todoService.getAllTodos()); // attribute for list in thymeleaf / html
        return "todos/todos";
    }
}
