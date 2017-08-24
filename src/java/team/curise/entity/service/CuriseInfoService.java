package team.curise.entity.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import team.curise.dao.BaseDao;
import team.curise.dao.CuriseInfoDao;
import team.curise.entity.CuriseInfo;

@Service
public class CuriseInfoService extends BaseService<CuriseInfo> {

    @Resource
    private CuriseInfoDao curiseInfoDao;

    @Override
    public BaseDao<CuriseInfo> getDao() {
        return curiseInfoDao;

    }

    public void save(CuriseInfo entity) {
        getDao().save(entity);
    }

    public void update(CuriseInfo entity) {
        getDao().update(entity);
    }

    public void delete(CuriseInfo entity) {
        getDao().delete(entity);
    }

}
