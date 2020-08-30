package guru.springframework.controllers;

import guru.springframework.domain.Todo;
import guru.springframework.services.RecipeService;
import guru.springframework.services.TodoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

class TodosControllerTest {

    @Mock
    TodoService todoService;

    TodosController todosController;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        todosController = new TodosController(todoService);
        mockMvc = MockMvcBuilders.standaloneSetup(todosController).build();
    }

    @Test
    void listTodos() {
    }

    @Test
    void showById() throws Exception {

        Todo todo = new Todo();
        todo.setId(1L);
        when(todoService.findById(anyLong())).thenReturn(todo);

        mockMvc.perform(MockMvcRequestBuilders.get("/todos/show/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("todos/show"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("todo"));

    }

    @Test
    void newTodo() {
    }

    @Test
    void testNewTodo() {
    }
}