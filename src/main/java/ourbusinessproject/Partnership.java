package ourbusinessproject;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@Entity
public class Partnership {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private Date creationDate;

    @NotNull
    @OneToOne
    private Enterprise enterprise;

    @NotNull
    @OneToOne
    private Project project;

    public Partnership() {
    }

    public void setCreationDate(Date date){
        this.creationDate=date;
    }

    public void setEnterprise(Enterprise e){
        this.enterprise=e;
    }

    public void setProject(Project p){
        this.project=p;
    }

    public Long getId(){
        return this.id;
    }

    public Enterprise getEnterprise(){
        return this.enterprise;
    }

    public Project getProject(){
        return this.project;
    }

    public Date getCreationDate(){
        return this.creationDate;
    }
}
