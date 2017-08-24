package team.curise.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "room_user")
public class RoomUser implements Serializable {

    private int id;
    private int user_id;
    private int room_id;
    private double deposit_amount;
    private int deposit_state;
    private String time;
    private int pre_room_id;
    private int curise_id;
    private int is_now;

    public RoomUser() {
        super();
    }

    public RoomUser(int id, int user_id, int room_id, double deposit_amount, int deposit_state, String time, int pre_room_id, int curise_id, int is_now) {
        this.id = id;
        this.user_id = user_id;
        this.room_id = room_id;
        this.deposit_amount = deposit_amount;
        this.deposit_state = deposit_state;
        this.time = time;
        this.pre_room_id = pre_room_id;
        this.curise_id = curise_id;
        this.is_now = is_now;
    }

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public double getDeposit_amount() {
        return deposit_amount;
    }

    public void setDeposit_amount(double deposit_amount) {
        this.deposit_amount = deposit_amount;
    }

    public int getDeposit_state() {
        return deposit_state;
    }

    public void setDeposit_state(int deposit_state) {
        this.deposit_state = deposit_state;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "RoomUser [id=" + id + ", user_id=" + user_id + ", room_id=" + room_id + ", deposit_amount="
                + deposit_amount + ", deposit_state=" + deposit_state + ", time=" + time + "]";
    }

    /**
     * @return the pre_room_id
     */
    public int getPre_room_id() {
        return pre_room_id;
    }

    /**
     * @param pre_room_id the pre_room_id to set
     */
    public void setPre_room_id(int pre_room_id) {
        this.pre_room_id = pre_room_id;
    }

    /**
     * @return the curise_id
     */
    public int getCurise_id() {
        return curise_id;
    }

    /**
     * @param curise_id the curise_id to set
     */
    public void setCurise_id(int curise_id) {
        this.curise_id = curise_id;
    }

    /**
     * @return the is_now
     */
    public int getIs_now() {
        return is_now;
    }

    /**
     * @param is_now the is_now to set
     */
    public void setIs_now(int is_now) {
        this.is_now = is_now;
    }

}
