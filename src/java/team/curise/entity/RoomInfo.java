package team.curise.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "room_info")
public class RoomInfo implements Serializable{

    private int id;
    private String room_name;
    private int layer;
    private double price;
    private int check_in_state;
    private int room_type;
    private int clean_state;
    private int people_num;
    private int curise_id;

    public RoomInfo() {
        super();
    }

    public int getCurise_id() {
        return curise_id;
    }

    public void setCurise_id(int curise_id) {
        this.curise_id = curise_id;
    }

    public RoomInfo(int id, String room_name, int layer, double price, int check_in_state, int room_type, int clean_state, int people_num, int curise_id) {
        this.id = id;
        this.room_name = room_name;
        this.layer = layer;
        this.price = price;
        this.check_in_state = check_in_state;
        this.room_type = room_type;
        this.clean_state = clean_state;
        this.people_num = people_num;
        this.curise_id = curise_id;
    }

   
    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoom_name() {
        return room_name;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

 

    public int getLayer() {
        return layer;
    }

    public void setLayer(int layer) {
        this.layer = layer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCheck_in_state() {
        return check_in_state;
    }

    public void setCheck_in_state(int check_in_state) {
        this.check_in_state = check_in_state;
    }

    public int getRoom_type() {
        return room_type;
    }

    public void setRoom_type(int room_type) {
        this.room_type = room_type;
    }

    public int getClean_state() {
        return clean_state;
    }

    public void setClean_state(int clean_state) {
        this.clean_state = clean_state;
    }

    public int getPeople_num() {
        return people_num;
    }

    public void setPeople_num(int people_num) {
        this.people_num = people_num;
    }

   

}
