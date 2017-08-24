package team.curise.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "user_role")
public class UserRole implements Serializable {

    private int id;
    private String real_name;
    private String user_name;
    private String password;
    private int age;
    private int sex;
    private String occupation;
    private int point;//积分
    private String credit;//信用度
    private String ID_number;
    private String phone_number;

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
     * @return the real_name
     */
    public String getReal_name() {
        return real_name;
    }

    /**
     * @param real_name the real_name to set
     */
    public void setReal_name(String real_name) {
        this.real_name = real_name;
    }

    /**
     * @return the user_name
     */
    public String getUser_name() {
        return user_name;
    }

    /**
     * @param user_name the user_name to set
     */
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the sex
     */
    public int getSex() {
        return sex;
    }

    /**
     * @param sex the sex to set
     */
    public void setSex(int sex) {
        this.sex = sex;
    }

    /**
     * @return the occupation
     */
    public String getOccupation() {
        return occupation;
    }

    /**
     * @param occupation the occupation to set
     */
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    /**
     * @return the point
     */
    public int getPoint() {
        return point;
    }

    /**
     * @param point the point to set
     */
    public void setPoint(int point) {
        this.point = point;
    }

    /**
     * @return the ID_number
     */
    public String getID_number() {
        return ID_number;
    }

    /**
     * @param ID_number the ID_number to set
     */
    public void setID_number(String ID_number) {
        this.ID_number = ID_number;
    }

    /**
     * @return the phone_number
     */
    public String getPhone_number() {
        return phone_number;
    }

    /**
     * @param phone_number the phone_number to set
     */
    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public UserRole(int id, String real_name, String user_name, String password, int age, int sex, String occupation, int point, String credit, String ID_number, String phone_number) {
        this.id = id;
        this.real_name = real_name;
        this.user_name = user_name;
        this.password = password;
        this.age = age;
        this.sex = sex;
        this.occupation = occupation;
        this.point = point;
        this.credit = credit;
        this.ID_number = ID_number;
        this.phone_number = phone_number;
    }

    public UserRole() {
    }

    /**
     * @return the credit
     */
    public String getCredit() {
        return credit;
    }

    /**
     * @param credit the credit to set
     */
    public void setCredit(String credit) {
        this.credit = credit;
    }

   

   

   
}
