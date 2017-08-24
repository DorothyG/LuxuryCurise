/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.curise.dao;

import org.springframework.stereotype.Repository;
import team.curise.entity.Consumption;

/**
 *
 * @author pupu
 */
@Repository
public class ConsumptionDao extends BaseDao<Consumption>{

    @Override
    public void save(Consumption entity) {
        super.save(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Consumption entity) {
        super.update(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Consumption entity) {
        super.delete(entity); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
