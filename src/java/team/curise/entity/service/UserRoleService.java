package team.curise.entity.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import team.curise.dao.BaseDao;
import team.curise.dao.UserRoleDao;
import team.curise.entity.UserRole;

@Service
public class UserRoleService extends BaseService<UserRole> {

    @Resource
    private UserRoleDao userRoleDao;

    @Override
    public BaseDao<UserRole> getDao() {
        return userRoleDao;
    }

    public void save(UserRole entity) {
        getDao().save(entity);
    }

    public void update(UserRole entity) {
        getDao().update(entity);
    }

    public void delete(UserRole entity) {
        getDao().delete(entity);
    }
}
