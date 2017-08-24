package team.curise.dao;

import org.springframework.stereotype.Repository;
import team.curise.entity.DepartInfo;

@Repository
public class DepartInfoDao extends BaseDao<DepartInfo>{

    @Override
    public void save(DepartInfo entity) {
        super.save(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(DepartInfo entity) {
        super.update(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(DepartInfo entity) {
        super.delete(entity); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
