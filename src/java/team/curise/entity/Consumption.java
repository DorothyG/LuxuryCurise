package team.curise.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "consumption")
public class Consumption implements Serializable{

    private int id;
    private int user_id;
    private double amount;
    private String time;
    private String place;
    private String consume_type;
    private int is_paid;

    public Consumption() {
        super();
    }

    public Consumption(int id, int user_id, double amount, String time, String place, String consume_type, int is_paid) {
        this.id = id;
        this.user_id = user_id;
        this.amount = amount;
        this.time = time;
        this.place = place;
        this.consume_type = consume_type;
        this.is_paid = is_paid;
    }

    @Override
    public String toString() {
        return "Consumption{" + "id=" + id + ", user_id=" + user_id + ", amount=" + amount + ", time=" + time + ", place=" + place + ", consume_type=" + consume_type + ", is_paid=" + is_paid + '}';
    }
   

    /**
     * @return the id
     */
    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the user_id
     */
    public int getUser_id() {
        return user_id;
    }

    /**
     * @param user_id the user_id to set
     */
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    /**
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * @return the place
     */
    public String getPlace() {
        return place;
    }

    /**
     * @param place the place to set
     */
    public void setPlace(String place) {
        this.place = place;
    }

    /**
     * @return the consume_type
     */
    public String getConsume_type() {
        return consume_type;
    }

    /**
     * @param consume_type the consume_type to set
     */
    public void setConsume_type(String consume_type) {
        this.consume_type = consume_type;
    }

    /**
     * @return the is_paid
     */
    public int getIs_paid() {
        return is_paid;
    }

    /**
     * @param is_paid the is_paid to set
     */
    public void setIs_paid(int is_paid) {
        this.is_paid = is_paid;
    }

}
