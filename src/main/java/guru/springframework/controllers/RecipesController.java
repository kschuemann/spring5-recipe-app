package guru.springframework.controllers;

import guru.springframework.repositories.RecipeRepository;
import guru.springframework.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/recipes")
@Controller
public class RecipesController {

    private final RecipeService recipeService;

    public RecipesController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/recipes/index", "/recipes/index.html"})
    public String listRecipes(Model model) {
        model.addAttribute("recipes", recipeService.getRecipes()); // attribute for list in thymeleaf / html
        return "recipes/index";
    }
}
