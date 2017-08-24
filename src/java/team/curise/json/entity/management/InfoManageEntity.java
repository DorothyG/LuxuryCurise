/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.curise.json.entity.management;

import java.util.List;
import team.curise.entity.chart.PieChart;
import team.curise.json.entity.CreditOfDiffRank;
import team.curise.json.entity.RealNameInfo;

/**
 *
 * @author pupu
 */
public class InfoManageEntity {

    private PieChart credit;
    private PieChart real_name;
    private List<String> occupList;

    public List<String> getOccupList() {
        return occupList;
    }

    public void setOccupList(List<String> occupList) {
        this.occupList = occupList;
    }

    /**
     * @return the credit
     */
    public PieChart getCredit() {
        return credit;
    }

    /**
     * @param credit the credit to set
     */
    public void setCredit(PieChart credit) {
        this.credit = credit;
    }

    /**
     * @return the real_name
     */
    public PieChart getReal_name() {
        return real_name;
    }

    /**
     * @param real_name the real_name to set
     */
    public void setReal_name(PieChart real_name) {
        this.real_name = real_name;
    }

}
