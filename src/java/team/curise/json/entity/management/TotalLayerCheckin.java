/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.curise.json.entity.management;

import java.util.List;

/**
 *
 * @author pupu
 */
public class TotalLayerCheckin {
    private List<LayerCheckin> layerCheckinList;
    private List<String> utilizationRate;//客房使用率

    public List<LayerCheckin> getLayerCheckinList() {
        return layerCheckinList;
    }

    public void setLayerCheckinList(List<LayerCheckin> layerCheckinList) {
        this.layerCheckinList = layerCheckinList;
    }

    public List<String> getUtilizationRate() {
        return utilizationRate;
    }

    public void setUtilizationRate(List<String> utilizationRate) {
        this.utilizationRate = utilizationRate;
    }

   
    
    
}
