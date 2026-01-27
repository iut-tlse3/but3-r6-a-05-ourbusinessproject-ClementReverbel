package ourbusinessproject;

import jakarta.validation.constraints.*;

public class Enterprise {

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
}
