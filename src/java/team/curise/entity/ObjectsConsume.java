package team.curise.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "objects_consume")
public class ObjectsConsume implements Serializable{

    private int id;
    private int room_id;
    private int curise_id;
    private int toothbrush;
    private int toothpaste;
    private int towel;
    private int slippers;
    private int soap;
    private int shamppo;
    private int lotion;
    private int comb;
    private Date date;

    public ObjectsConsume() {
        super();
    }

    public ObjectsConsume(int id, int room_id, int curise_id, int toothbrush, int toothpaste, int towel, int slippers,
            int soap, int shamppo, int lotion, int comb, Date date) {
        super();
        this.id = id;
        this.room_id = room_id;
        this.curise_id = curise_id;
        this.toothbrush = toothbrush;
        this.toothpaste = toothpaste;
        this.towel = towel;
        this.slippers = slippers;
        this.soap = soap;
        this.shamppo = shamppo;
        this.lotion = lotion;
        this.comb = comb;
        this.date = date;
    }

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public int getCurise_id() {
        return curise_id;
    }

    public void setCurise_id(int curise_id) {
        this.curise_id = curise_id;
    }

    public int getToothbrush() {
        return toothbrush;
    }

    public void setToothbrush(int toothbrush) {
        this.toothbrush = toothbrush;
    }

    public int getToothpaste() {
        return toothpaste;
    }

    public void setToothpaste(int toothpaste) {
        this.toothpaste = toothpaste;
    }

    public int getTowel() {
        return towel;
    }

    public void setTowel(int towel) {
        this.towel = towel;
    }

    public int getSlippers() {
        return slippers;
    }

    public void setSlippers(int slippers) {
        this.slippers = slippers;
    }

    public int getSoap() {
        return soap;
    }

    public void setSoap(int soap) {
        this.soap = soap;
    }

    public int getShamppo() {
        return shamppo;
    }

    public void setShamppo(int shamppo) {
        this.shamppo = shamppo;
    }

    public int getLotion() {
        return lotion;
    }

    public void setLotion(int lotion) {
        this.lotion = lotion;
    }

    public int getComb() {
        return comb;
    }

    public void setComb(int comb) {
        this.comb = comb;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ObjectConsume [id=" + id + ", room_id=" + room_id + ", curise_id=" + curise_id + ", toothbrush="
                + toothbrush + ", toothpaste=" + toothpaste + ", towel=" + towel + ", slippers=" + slippers + ", soap="
                + soap + ", shamppo=" + shamppo + ", lotion=" + lotion + ", comb=" + comb + ", date=" + date + "]";
    }

}
