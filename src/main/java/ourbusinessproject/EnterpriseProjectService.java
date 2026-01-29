package ourbusinessproject;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.constraints.NotNull;
import org.hibernate.procedure.internal.EntityDomainResultBuilder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@Transactional
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
        enterprise.addProject(p);
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

    public List<Project> findAllProjects(){
        String query = "SELECT p FROM Project p JOIN FETCH p.enterprise ORDER BY p.title";
        TypedQuery<Project> queryObj = EM.createQuery(query, Project.class);
        return queryObj.getResultList();
    }
}
