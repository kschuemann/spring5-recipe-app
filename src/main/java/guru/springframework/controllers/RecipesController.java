package guru.springframework.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/recipes")
@Controller
public class RecipesController {

    @RequestMapping({"", "/", "/recipes/index", "/recipes/index.html"})
    public String listRecipes(Model model) {
        return "recipes/index";
    }
}
