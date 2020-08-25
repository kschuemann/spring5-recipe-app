package guru.springframework.api.v1;

import guru.springframework.services.TodoService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoRestServiceImpl {

    private TodoService todoService;

    public TodoRestServiceImpl(TodoService todoService) {
        this.todoService = todoService;
    }

}
