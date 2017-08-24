package team.curise.entity.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import team.curise.dao.BaseDao;
import team.curise.dao.DepartInfoDao;
import team.curise.entity.DepartInfo;

@Service
public class DepartInfoService extends BaseService<DepartInfo> {
    
    @Resource
    private DepartInfoDao departInfoDao;

    @Override
    public BaseDao<DepartInfo> getDao() {
      return departInfoDao;
    }
public void save(DepartInfo entity) {
        getDao().save(entity);
    }

    public void update(DepartInfo entity) {
        getDao().update(entity);
    }

    public void delete(DepartInfo entity) {
        getDao().delete(entity);
    }

}
