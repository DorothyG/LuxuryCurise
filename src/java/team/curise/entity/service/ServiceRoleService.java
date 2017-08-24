package team.curise.entity.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import team.curise.dao.BaseDao;
import team.curise.dao.ServiceRoleDao;
import team.curise.entity.ServiceRole;

@Service
public class ServiceRoleService extends BaseService<ServiceRole> {
    
      @Resource
    private ServiceRoleDao serviceRoleDao;
    
     @Override
    public BaseDao<ServiceRole> getDao() {
        return serviceRoleDao;
       
    }
    
     public void save(ServiceRole entity) {
        getDao().save(entity);
    }

    public void update(ServiceRole entity) {
        getDao().update(entity);
    }

    public void delete(ServiceRole entity) {
        getDao().delete(entity);
    }

   


}
