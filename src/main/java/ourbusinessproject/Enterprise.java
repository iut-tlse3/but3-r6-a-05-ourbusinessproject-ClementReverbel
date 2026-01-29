package ourbusinessproject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.concurrent.ArrayBlockingQueue;

@Entity
@Table(name="Enterprises")
public class Enterprise {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String name;

    @Size(min=10)
    private String description;

    @NotBlank
    private String contactname;

    @NotBlank
    @Email
    private String contactemail;

    @JsonIgnore
    @OneToMany(mappedBy = "enterprise")
    private Collection<Project> projects;

    public Enterprise(){
    }

    public void setName(String name){
        this.name=name;
    }

    public void setDescription(String description){
        this.description=description;
    }

    public void setContactName(String contactname){
        this.contactname=contactname;
    }

    public void setContactEmail(String contactemail){
        this.contactemail=contactemail;
    }

    public Long getId(){
        return this.id;
    }

    public String getName(){return this.name;}

    public Collection<Project> getProjects(){
        return projects;
    }

    public void addProject(Project project){
        if (this.projects == null){
            this.projects=new HashSet<>();
        }
        this.projects.add(project);
    }
}
