package guru.springframework.controllers;

import guru.springframework.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/todos")
@Controller
public class TodosController {

    private final RecipeService recipeService;

    public TodosController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/todos/todos", "/todos/todos.html"})
    public String listRecipes(Model model) {
        model.addAttribute("recipes", recipeService.getRecipes()); // attribute for list in thymeleaf / html
        return "todos/todos";
    }
}
