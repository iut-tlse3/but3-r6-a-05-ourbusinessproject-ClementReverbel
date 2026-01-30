package ourbusinessproject;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InitializationService {

    @Autowired
    private EnterpriseProjectService EPS;
    @Autowired
    private PartnershipService PS;

    private Project p1e1;
    private Project p2e1;
    private Project p1e2;
    private Enterprise e1;
    private Enterprise e2;

    private Partnership p1E1WithE2;
    private Partnership p1E2WithE1;
    private Partnership p2E1WithE2;

    @Transactional
    //Le @Transactional permet de garder la bd dans un état cohérent
    //Si un élément ne passe pas alors toute la transaction est annulé
    //pour éviter les données incohérentes dans notre base de données
    public void initProjects(){
        this.e1 = EPS.newEnterprise(
                "e1",
                "a description",
                "a contact name",
                "acontact@email.com"
        );
        this.e2 = EPS.newEnterprise(
                "e2",
                "a description",
                "a contact name",
                "acontact@email.com"
        );
        this.p1e1= this.EPS.newProject("p1e1", "description", e1);
        this.p1e2= this.EPS.newProject("p1e2", "description", e2);
        this.p2e1= this.EPS.newProject("p2e1", "description", e1);
    }

    @Transactional
    public void initPartnerships(){
        this.p1E1WithE2=this.PS.newPartnership(p1e1,e2);
        this.p1E2WithE1 =this.PS.newPartnership(p1e2,e1);
        this.p2E1WithE2 =this.PS.newPartnership(p2e1,e2);
    }

    public Project getProject1E1(){
        return this.p1e1;
    }

    public Project getProject1E2(){
        return this.p1e2;
    }

    public Project getProject2E1(){
        return this.p2e1;
    }

    public Enterprise getEnterprise1(){
        return e1;
    }

    public Enterprise getEnterprise2(){
        return e2;
    }

    public Partnership getPartnershipP1E1WithE2(){
        return this.p1E1WithE2;
    }

    public Partnership getPartnershipP1E2WithE1(){
        return this.p1E2WithE1;
    }

    public Partnership getPartnershipP2E1WithE2(){
        return this.p2E1WithE2;
    }
}
