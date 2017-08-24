/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.curise.json.entity;

/**
 *
 * @author pupu
 */
public class RealNameInfo {
    private int notRealName;
    private int realName;

    public RealNameInfo(int[] realNameInfo) {
        this.notRealName = realNameInfo[0];
        this.realName = realNameInfo[1];
    }

    
    public int getNotRealName() {
        return notRealName;
    }

    public void setNotRealName(int notRealName) {
        this.notRealName = notRealName;
    }

    public int getRealName() {
        return realName;
    }

    public void setRealName(int realName) {
        this.realName = realName;
    }
    
}
