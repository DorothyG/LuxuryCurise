/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.curise.json.entity.management;

import java.util.List;
import java.util.Map;
import team.curise.entity.chart.BarChart;
import team.curise.entity.chart.PieChart;

/**
 *
 * @author pupu
 */
public class RoomManageEntity {
    
    //总表
    private TotalLayerCheckin totalLayerCheckin;
   private BarChart checkin;
   private BarChart consume;
   private PieChart sex;
   private PieChart age;
   
   private List<String> occupList;

    public List<String> getOccupList() {
        return occupList;
    }

    public void setOccupList(List<String> occupList) {
        this.occupList = occupList;
    }
   

    public TotalLayerCheckin getTotalLayerCheckin() {
        return totalLayerCheckin;
    }

    public void setTotalLayerCheckin(TotalLayerCheckin totalLayerCheckin) {
        this.totalLayerCheckin = totalLayerCheckin;
    }

    public BarChart getCheckin() {
        return checkin;
    }

    public void setCheckin(BarChart checkin) {
        this.checkin = checkin;
    }

    public BarChart getConsume() {
        return consume;
    }

    public void setConsume(BarChart consume) {
        this.consume = consume;
    }

    public PieChart getSex() {
        return sex;
    }

    public void setSex(PieChart sex) {
        this.sex = sex;
    }

    public PieChart getAge() {
        return age;
    }

    public void setAge(PieChart age) {
        this.age = age;
    }


   
    
    
}
