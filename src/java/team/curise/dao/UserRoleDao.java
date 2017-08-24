package team.curise.dao;

import org.springframework.stereotype.Repository;
import team.curise.entity.UserRole;

@Repository
public class UserRoleDao extends BaseDao<UserRole>{

    @Override
    public void save(UserRole entity) {
        super.save(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(UserRole entity) {
        super.update(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(UserRole entity) {
        super.delete(entity); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}

