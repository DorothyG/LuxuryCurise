package team.curise.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "depart_month_revenue")
public class DepartMonthRevenue implements Serializable{

    private int id;
    private int depart_id;
    private int curise_id;
    private double revenue;
    private String collator;
    private String date;

    public DepartMonthRevenue() {
        super();
    }

    public DepartMonthRevenue(int id, int depart_id, int curise_id, double revenue, String collator, String date) {
        super();
        this.id = id;
        this.depart_id = depart_id;
        this.curise_id = curise_id;
        this.revenue = revenue;
        this.collator = collator;
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

    public int getDepart_id() {
        return depart_id;
    }

    public void setDepart_id(int depart_id) {
        this.depart_id = depart_id;
    }

    public int getCurise_id() {
        return curise_id;
    }

    public void setCurise_id(int curise_id) {
        this.curise_id = curise_id;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public String getCollator() {
        return collator;
    }

    public void setCollator(String collator) {
        this.collator = collator;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "DepartMonthRevenue [id=" + id + ", depart_id=" + depart_id + ", curise_id=" + curise_id + ", revenue="
                + revenue + ", collator=" + collator + ", month=" + date + "]";
    }

}
