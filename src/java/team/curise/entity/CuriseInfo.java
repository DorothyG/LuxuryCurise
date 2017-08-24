package team.curise.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "curise_info")
public class CuriseInfo implements Serializable{

    private int id;
    private int curise_num;
    private String name;
    private String intro;
    private int total_rooms;

    
    public CuriseInfo() {
        super();
    }

    public CuriseInfo(int id, int curise_num, String name, String intro) {
        super();
        this.id = id;
        this.curise_num = curise_num;
        this.name = name;
        this.intro = intro;
    }

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCurise_num() {
        return curise_num;
    }

    public void setCurise_num(int curise_num) {
        this.curise_num = curise_num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    @Override
    public String toString() {
        return "CuriseInfo [id=" + id + ", curise_num=" + curise_num + ", name=" + name + ", intro=" + intro + "]";
    }

    /**
     * @return the total_rooms
     */
    public int getTotal_rooms() {
        return total_rooms;
    }

    /**
     * @param total_rooms the total_rooms to set
     */
    public void setTotal_rooms(int total_rooms) {
        this.total_rooms = total_rooms;
    }

}
