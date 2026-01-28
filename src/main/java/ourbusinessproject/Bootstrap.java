package ourbusinessproject;

import jakarta.annotation.PostConstruct;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;


@Service
public class Bootstrap {

    @NotNull
    private InitializationService IS;

    public Bootstrap(InitializationService IS){
        this.IS=IS;
    }

    @PostConstruct
    public void init(){
        try {
            this.IS.initProjects();
        } catch (RuntimeException e) {
        }
    }

    public InitializationService getInitializationService(){
        return this.IS;
    }
}
