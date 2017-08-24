package team.curise.dao;
import org.springframework.stereotype.Repository;
import team.curise.entity.ServiceRole;

@Repository
public class ServiceRoleDao extends BaseDao<ServiceRole>{

    @Override
    public void save(ServiceRole entity) {
        super.save(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(ServiceRole entity) {
        super.update(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(ServiceRole entity) {
        super.delete(entity); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
