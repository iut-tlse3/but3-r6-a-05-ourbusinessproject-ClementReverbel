package ourbusinessproject;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="Projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String title;

    private String description;

    @ManyToOne
    @NotNull
    private Enterprise enterprise;

    public Project(){
    }

    public void setTitle(String title) {
        this.title=title;
    }

    public void setDescription(String description){
        this.description=description;
    }

    public void setEnterprise(Enterprise entreprise){
        this.enterprise=entreprise;
    }

    public long getId(){
        return this.id;
    }

    public Enterprise getEnterprise(){ return this.enterprise;}

}
