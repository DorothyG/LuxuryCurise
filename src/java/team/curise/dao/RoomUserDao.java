package team.curise.dao;

import org.springframework.stereotype.Repository;
import team.curise.entity.RoomUser;

@Repository
public class RoomUserDao extends BaseDao<RoomUser>{

    @Override
    public void save(RoomUser entity) {
        super.save(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(RoomUser entity) {
        super.update(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(RoomUser entity) {
        super.delete(entity); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
