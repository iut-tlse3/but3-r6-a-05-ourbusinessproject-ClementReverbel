package ourbusinessproject;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

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
}
