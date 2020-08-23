package guru.springframework.bootstrap;

import guru.springframework.domain.Ingredient;
import guru.springframework.domain.Recipe;
import guru.springframework.domain.Todo;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.repositories.TodosRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.HashSet;

@Slf4j
@Component
public class Bootstrap implements CommandLineRunner {

    RecipeRepository recipeRepository;
    TodosRepository todosRepository;

    public Bootstrap(RecipeRepository recipeRepository, TodosRepository todosRepository) {
        this.recipeRepository = recipeRepository;
        this.todosRepository = todosRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        Recipe r1 = new Recipe();
        r1.setDescription("Spicy grilled Chicken");
        r1.setCookTime(0);
        r1.setPrepTime(10);
        r1.setDirections("asdsjkdfgkjdldgblfdhgldhgkjfdhgbfjkdgbfjkdghkj");
        Ingredient ingr1 = new Ingredient();
        ingr1.setDescription("Ingred. Bitch");
        ingr1.setRecipe(r1);
        HashSet<Ingredient> ingredients1 = new HashSet<>();
        ingredients1.add(ingr1);
        r1.setIngredients(ingredients1);
        recipeRepository.save(r1);

        Recipe r2 = new Recipe();
        r2.setDescription("Guacamole");
        r2.setCookTime(0);
        r2.setPrepTime(10);
        r2.setDirections("adajfdshsssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss adajfdshsssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss adajfdshsssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss");
        Ingredient ingr2 = new Ingredient();
        ingr2.setDescription("Advocado");
        ingr2.setRecipe(r2);
        HashSet<Ingredient> ingredients2 = new HashSet<>();
        ingredients2.add(ingr2);
        r2.setIngredients(ingredients2);
        recipeRepository.save(r2);
        log.debug("Setup Recipes");


        Todo t1 = new Todo(1L, "Tue dies", new Date(System.currentTimeMillis()), null);
        Todo t2 = new Todo(2L, "Tue das", new Date(System.currentTimeMillis()), null);
        Todo t3 = new Todo(3L, "Bla bla", new Date(System.currentTimeMillis()), null);
        todosRepository.save(t1);
        todosRepository.save(t2);
        todosRepository.save(t3);
        log.debug("Setup Todos");

    }
}

