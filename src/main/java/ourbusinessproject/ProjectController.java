package ourbusinessproject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value="/api")
public class ProjectController {

    EnterpriseProjectService EPS;

    public ProjectController(EnterpriseProjectService EPS){
        this.EPS=EPS;
    }

    @RequestMapping(value="/projects")
    public List<Project> findAllProjectsWithEnterprises(){
        return EPS.findAllProjects();
    }
}
