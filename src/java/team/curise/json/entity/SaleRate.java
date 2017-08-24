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
public class SaleRate {

    private String curise_name;//邮轮名称
    private int total_rooms;//总舱位
    private int sailed;//已销售
    private int unsail;//未销售
    private List<LayerSale> layerSales;

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
     * @return the sailed
     */
    public int getSailed() {
        return sailed;
    }

    /**
     * @param sailed the sailed to set
     */
    public void setSailed(int sailed) {
        this.sailed = sailed;
    }

    /**
     * @return the unsail
     */
    public int getUnsail() {
        return unsail;
    }

    /**
     * @param unsail the unsail to set
     */
    public void setUnsail(int unsail) {
        this.unsail = unsail;
    }

    /**
     * @return the layerSales
     */
    public List<LayerSale> getLayerSales() {
        return layerSales;
    }

    /**
     * @param layerSales the layerSales to set
     */
    public void setLayerSales(List<LayerSale> layerSales) {
        this.layerSales = layerSales;
    }

}
