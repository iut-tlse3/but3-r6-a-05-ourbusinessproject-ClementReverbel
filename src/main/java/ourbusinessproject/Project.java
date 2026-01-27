package ourbusinessproject;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Project {
    @NotNull
    @Size(min=1)
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
