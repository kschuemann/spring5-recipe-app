package guru.springframework.bootstrap;

import guru.springframework.domain.Ingredient;
import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class RecipeBootstrap implements CommandLineRunner {

    RecipeRepository recipeRepository;

    public RecipeBootstrap(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        {
            Recipe r1 = new Recipe();
            r1.setDescription("Testing bitch");
            r1.setCookTime(0);
            r1.setPrepTime(10);
            r1.setDirections("asdsjkdfgkjdldgblfdhgldhgkjfdhgbfjkdgbfjkdghkj");

            Ingredient ingredient = new Ingredient();
            ingredient.setDescription("Ingred. Bitch");
            ingredient.setRecipe(r1);

            HashSet<Ingredient> ingredients = new HashSet<>();
            ingredients.add(ingredient);
            r1.setIngredients(ingredients);
            recipeRepository.save(r1);
        }

        {
            Recipe r1 = new Recipe();
            r1.setDescription("Guacamole");
            r1.setCookTime(0);
            r1.setPrepTime(10);
            r1.setDirections("adajfdshsssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss adajfdshsssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss adajfdshsssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss");

            Ingredient ingredient = new Ingredient();
            ingredient.setDescription("Advocado");
            ingredient.setRecipe(r1);

            HashSet<Ingredient> ingredients = new HashSet<>();
            ingredients.add(ingredient);
            r1.setIngredients(ingredients);
            recipeRepository.save(r1);
        }
    }
}
