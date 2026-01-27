package ourbusinessproject;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;

@Service
public class EnterpriseProjectService {

    @PersistenceContext
    private EntityManager EM;

    public EnterpriseProjectService(EntityManager EM){
        this.EM=EM;
    }

    public EntityManager getEntityManager(){
        return this.EM;
    }

    public Project newProject(String title, String description, Enterprise enterprise){
        Project p=new Project();
        p.setTitle(title);
        p.setDescription(description);
        p.setEnterprise(enterprise);
        this.EM.persist(p);
        this.EM.flush();
        return p;
    }

    public Enterprise newEnterprise(String name, String description, String contactname, String email){
        Enterprise e=new Enterprise();
        e.setName(name);
        e.setDescription(description);
        e.setContactName(contactname);
        e.setContactEmail(email);
        this.EM.persist(e);
        this.EM.flush();
        return e;
    }

    public Project findProjectById(Long id){
        return this.EM.find(Project.class,id);
    }

    public Enterprise findEnterpriseById(Long id){
        return this.EM.find(Enterprise.class,id);
    }
}
