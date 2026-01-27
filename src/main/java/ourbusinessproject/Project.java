package ourbusinessproject;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="Projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank
    private String title;

    private String description;

    public Project(){
    }

    public void setTitle(String title) {
        this.title=title;
    }

    public void setDescription(String description){
        this.description=description;
    }
}
