/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.curise.controller.service;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import team.curise.entity.service.CuriseInfoService;
import team.curise.entity.service.RoomInfoService;
import team.curise.json.entity.LayerSale;
import team.curise.json.entity.RoomTypeLayerSale;
import team.curise.json.entity.SaleRate;
/**
 *
 * @author pupu
 */
@Service
public class SaleRateService {

    String[] roomType = {"", "套房", "阳台房", "海景房", "内舱房"};

    @Resource
    private RoomInfoService roomInfoService;
    @Resource
    private CuriseInfoService curiseInfoService;
    @Resource
    private QueryService queryService;

    public SaleRate getCuriseSaleRateInfo(String curise_name,int curise_id, int room_type) {
        SaleRate s = new SaleRate();
        long a = (long) curiseInfoService.find("select count(*) from RoomInfo where curise_id =? and room_type=?", curise_id, room_type).get(0);
        int total_rooms = (int) a;
        s.setTotal_rooms(total_rooms);
        //1未入住2带入住3已入住
        a = (long) curiseInfoService.find("select count(*) from RoomInfo where check_in_state =? and curise_id=? and room_type=?", 1, curise_id, room_type).get(0);
        int unsail = (int) a;
        int sailed = total_rooms - unsail;
        s.setUnsail(unsail);
        s.setSailed(sailed);
        s.setCurise_name(curise_name);
        return s;
    }

    public SaleRate getCuriseSaleRateInfo(String curise_name, int curise_id) {
        SaleRate s = new SaleRate();
        long a = (long) curiseInfoService.find("select count(*) from RoomInfo where curise_id =?", curise_id).get(0);
        int total_rooms = (int) a;
        s.setTotal_rooms(total_rooms);
        //1未入住2带入住3已入住
        a = (long) curiseInfoService.find("select count(*) from RoomInfo where check_in_state =? and curise_id=? ", 1, curise_id).get(0);
        int unsail = (int) a;
        int sailed = total_rooms - unsail;
        s.setUnsail(unsail);
        s.setSailed(sailed);
        s.setCurise_name(curise_name);
        return s;
    }

    public LayerSale findCuriseLayerSaleRateInfo(int curise_id, int layer, int room_type) {
        LayerSale layerSale = new LayerSale();
        layerSale.setLayer(layer);
        long a = (long) curiseInfoService.find("select count(*) from RoomInfo where curise_id=? and layer=? and room_type=? ", curise_id, layer, room_type).get(0);
        int l_total_rooms = (int) a;
        a = (long) curiseInfoService.find("select count(*) from RoomInfo where curise_id=? and layer = ? and check_in_state =? and room_type=?", curise_id, layer, 1, room_type).get(0);
        int l_unsail = (int) a;
        layerSale.setTotal_rooms(l_total_rooms);
        layerSale.setUnsail(l_unsail);
        layerSale.setSailed(l_total_rooms - l_unsail);
        return layerSale;
    }

    public LayerSale findCuriseLayerSaleRateInfo(int curise_id, int layer) {
        LayerSale layerSale = new LayerSale();
        layerSale.setLayer(layer);
        long a = (long) curiseInfoService.find("select count(*) from RoomInfo where curise_id=? and layer=? ", curise_id, layer).get(0);
        int l_total_rooms = (int) a;
        a = (long) curiseInfoService.find("select count(*) from RoomInfo where curise_id=? and layer = ? and check_in_state =? ", curise_id, layer, 1).get(0);
        int l_unsail = (int) a;
        layerSale.setTotal_rooms(l_total_rooms);
        layerSale.setUnsail(l_unsail);
        layerSale.setSailed(l_total_rooms - l_unsail);
        return layerSale;
    }

    public RoomTypeLayerSale findCuriseLayerRoomTypeSaleRate(int curise_id, int layer, int room_type) {
        RoomTypeLayerSale rtls = new RoomTypeLayerSale();
        long a = (long) curiseInfoService.find("select count(*) from RoomInfo where curise_id=? and layer=? and room_type=? ", curise_id, layer, room_type).get(0);
        int rt_total_rooms = (int) a;

        a = (long) curiseInfoService.find("select count(*) from RoomInfo where curise_id=? and layer = ? and check_in_state =? and room_type=? ", curise_id, layer, 1, room_type).get(0);
        int rt_unsail = (int) a;
        rtls.setRoom_type(roomType[room_type]);
        rtls.setSaled(rt_total_rooms - rt_unsail);
        rtls.setTotal_rooms(rt_total_rooms);
        return rtls;
    }

    

    public SaleRate findAllSaleRate(int curise_id, String curise_name) {
        SaleRate s = getCuriseSaleRateInfo(curise_name, curise_id);
        List<LayerSale> layerSales = new ArrayList<>();
        int layers = queryService.findLayerByCuriseId(curise_id);
        for (int layer = 1; layer <= layers; layer++) {
            LayerSale layerSale = findCuriseLayerSaleRateInfo(curise_id, layer);
            List<RoomTypeLayerSale> roomTypeSales = new ArrayList<>();
            for (int room_type = 1; room_type <= 4; room_type++) {
                RoomTypeLayerSale rtls = findCuriseLayerRoomTypeSaleRate(curise_id, layer, room_type);
                roomTypeSales.add(rtls);
            }
            layerSale.setRoomTypeSales(roomTypeSales);
            layerSales.add(layerSale);
        }
        s.setLayerSales(layerSales);
        return s;
    }

    public int findRoomTypeByRtype(String room_type){
        int r_type=0 ;
        for(int i=1;i<=4;i++){
            if(roomType[i].equals(room_type)){
                r_type=i;
            }
        }
        return r_type;
    }
    
    public SaleRate findSaleRateByRoomType(int curise_id, String curise_name, String r_type) {
        int room_type = findRoomTypeByRtype(r_type);
        SaleRate s = getCuriseSaleRateInfo(curise_name, curise_id,room_type);
        List<LayerSale> layerSales = new ArrayList<>();
        int layers = queryService.findLayerByCuriseId(curise_id);
        for (int layer = 1; layer <= layers; layer++) {
            LayerSale layerSale = findCuriseLayerSaleRateInfo(curise_id, layer, room_type);
            List<RoomTypeLayerSale> roomTypeSales = new ArrayList<>();

            RoomTypeLayerSale rtls = findCuriseLayerRoomTypeSaleRate(curise_id, layer, room_type);
            roomTypeSales.add(rtls);

            layerSale.setRoomTypeSales(roomTypeSales);
            layerSales.add(layerSale);
        }
        s.setLayerSales(layerSales);
        return s;
    }

}
