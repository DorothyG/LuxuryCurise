package team.curise.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "service_role")
public class ServiceRole implements Serializable{

    private int id;
    private String account;
    private String password;

    public ServiceRole() {
        super();
    }

    public ServiceRole(int id, String account, String password) {
        super();
        this.id = id;
        this.account = account;
        this.password = password;
    }

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "ServiceRole [id=" + id + ", account=" + account + ", password=" + password + "]";
    }

}
