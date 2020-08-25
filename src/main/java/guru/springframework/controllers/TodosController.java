package guru.springframework.controllers;

import guru.springframework.domain.Todo;
import guru.springframework.services.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Date;

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

    @RequestMapping("/show/{id}")
    public String showById(@PathVariable String id, Model model){
        model.addAttribute("todo", todoService.findById(Long.valueOf(id)));
        return "todos/show";
    }

    @GetMapping("/new")
    public String newRecipe(Model model) {
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
            return "redirect:/todos/";
        }
    }

}
