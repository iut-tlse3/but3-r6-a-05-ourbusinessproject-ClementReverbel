package ourbusinessproject;

import jakarta.annotation.PostConstruct;
import jakarta.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class Bootstrap {

    private static final Logger logger = LoggerFactory.getLogger(Bootstrap.class);

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
            logger.error("Error during bootstrap initialization",e);
        }
    }

    public InitializationService getInitializationService(){
        return this.IS;
    }
}
