/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.curise.json.entity;

import java.util.List;

/**
 *
 * @author pupu
 */
public class CuriseAboard {
    
    private String curise_name;//邮轮名称
    private int total_rooms;//总舱位
    private int reserved;//已预定
    private int remainder;//剩余
    private int checked_in;//入住
    private List<LayerReserve> layerReserves;

    /**
     * @return the curise_name
     */
    public String getCurise_name() {
        return curise_name;
    }

    /**
     * @param curise_name the curise_name to set
     */
    public void setCurise_name(String curise_name) {
        this.curise_name = curise_name;
    }

    /**
     * @return the total_rooms
     */
    public int getTotal_rooms() {
        return total_rooms;
    }

    /**
     * @param total_rooms the total_rooms to set
     */
    public void setTotal_rooms(int total_rooms) {
        this.total_rooms = total_rooms;
    }

    /**
     * @return the reserved
     */
    public int getReserved() {
        return reserved;
    }

    /**
     * @param reserved the reserved to set
     */
    public void setReserved(int reserved) {
        this.reserved = reserved;
    }

    /**
     * @return the remainder
     */
    public int getRemainder() {
        return remainder;
    }

    /**
     * @param remainder the remainder to set
     */
    public void setRemainder(int remainder) {
        this.remainder = remainder;
    }

    /**
     * @return the checked_in
     */
    public int getChecked_in() {
        return checked_in;
    }

    /**
     * @param checked_in the checked_in to set
     */
    public void setChecked_in(int checked_in) {
        this.checked_in = checked_in;
    }

    /**
     * @return the layerReserves
     */
    public List<LayerReserve> getLayerReserves() {
        return layerReserves;
    }

    /**
     * @param layerReserves the layerReserves to set
     */
    public void setLayerReserves(List<LayerReserve> layerReserves) {
        this.layerReserves = layerReserves;
    }
    
    
}
