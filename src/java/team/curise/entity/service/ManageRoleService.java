package team.curise.entity.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import team.curise.dao.BaseDao;
import team.curise.dao.ConsumptionDao;
import team.curise.dao.ManageRoleDao;
import team.curise.entity.ManagerRole;

@Service
public class ManageRoleService extends BaseService<ManagerRole> {

    @Resource
    private ManageRoleDao manageRoleDao;

    @Override
    public BaseDao<ManagerRole> getDao() {
        return manageRoleDao;
    }

    public void save(ManagerRole entity) {
        getDao().save(entity);
    }

    public void update(ManagerRole entity) {
        getDao().update(entity);
    }

    public void delete(ManagerRole entity) {
        getDao().delete(entity);
    }
}
