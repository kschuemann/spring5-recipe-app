package guru.springframework.repositories;

import guru.springframework.domain.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodosRepository extends CrudRepository<Todo,Long>{

}
