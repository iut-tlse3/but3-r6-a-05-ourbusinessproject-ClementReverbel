package ourbusinessproject;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

@Service
public class PartnershipService {

    @PersistenceContext
    private EntityManager EM;

    public PartnershipService(EntityManager EM){
        this.EM=EM;
    }

    public Partnership newPartnership(Project p, Enterprise e){
        Partnership partnership = new Partnership();
        partnership.setProject(p);
        partnership.setEnterprise(e);
        partnership.setCreationDate(new Date());
        EM.persist(partnership);
        EM.flush();
        return partnership;
    }

    public Partnership findPartnershipById(long id){
        return this.EM.find(Partnership.class,id);
    }

    public void remove(Partnership partnership){
        this.EM.remove(partnership);
    }
}
