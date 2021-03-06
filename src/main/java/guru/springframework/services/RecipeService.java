package guru.springframework.services;

import guru.springframework.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();

    void saveRecipe(Recipe recipe);

    Recipe findById(Long id);

}
