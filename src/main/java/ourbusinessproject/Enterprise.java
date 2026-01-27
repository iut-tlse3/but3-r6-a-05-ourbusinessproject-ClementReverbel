package ourbusinessproject;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Enterprise {

    @NotNull
    @Size(min=1)
    private String name;

    @Size(min=10)
    private String description;

    @NotNull
    @Size(min=1)
    private String contactname;

    @NotNull
    @Size(min=1)
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
