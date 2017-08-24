package team.curise.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "depart_info")
public class DepartInfo implements Serializable{

    private int id;
    private String depart_name;

    public DepartInfo() {
        super();
    }

    public DepartInfo(int id, String depart_name) {
        super();
        this.id = id;
        this.depart_name = depart_name;
    }

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepart_name() {
        return depart_name;
    }

    public void setDepart_name(String depart_name) {
        this.depart_name = depart_name;
    }

    @Override
    public String toString() {
        return "DepartInfo [id=" + id + ", depart_name=" + depart_name + "]";
    }

}
