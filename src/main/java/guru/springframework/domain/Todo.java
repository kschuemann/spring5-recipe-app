package guru.springframework.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String description;
    Date createdDate;
    Date editedDate;

    public Todo() {
    }

    public Todo(Long id, String description, Date createdDate, Date editedDate) {
        this.id = id;
        this.description = description;
        this.createdDate = createdDate;
        this.editedDate = editedDate;
    }

    public Todo(String description, Date createdDate, Date editedDate) {
        this.description = description;
        this.createdDate = createdDate;
        this.editedDate = editedDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String todoDesc) {
        this.description = todoDesc;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getEditedDate() {
        return editedDate;
    }

    public void setEditedDate(Date editedDate) {
        this.editedDate = editedDate;
    }
}
