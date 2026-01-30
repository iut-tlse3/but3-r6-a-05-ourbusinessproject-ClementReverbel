package ourbusinessproject;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class PartnershipController {

    private EnterpriseProjectService EPS;
    private PartnershipService PS;

    public PartnershipController(EnterpriseProjectService EPS, PartnershipService PS){
        this.EPS=EPS;
        this.PS=PS;
    }

    @RequestMapping("partnerships")
    @ResponseBody
    public Partnership addPartnership(@RequestParam("project_id") Long idProject,
                               @RequestParam("enterprise_id") Long idEnterprise){
        Project p = this.EPS.findProjectById(idProject);
        Enterprise e = this.EPS.findEnterpriseById(idEnterprise);
        return this.PS.newPartnership(p,e);
    }

    @RequestMapping("partnerships/{id}")
    public void removePartnership(@PathVariable("id") Long idPartnership){
        Partnership ps=this.PS.findPartnershipById(idPartnership);
        this.PS.remove(ps);
    }
}
