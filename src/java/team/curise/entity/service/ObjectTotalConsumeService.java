package team.curise.entity.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import team.curise.dao.BaseDao;
import team.curise.dao.ObjectTotalConsumeDao;
import team.curise.entity.ObjectsTotalConsume;

@Service
public class ObjectTotalConsumeService extends BaseService<ObjectsTotalConsume> {

     @Resource
    private ObjectTotalConsumeDao objectTotalConsumeDao;
    @Override
    public BaseDao<ObjectsTotalConsume> getDao() {
        return objectTotalConsumeDao;
    }

    
     public void save(ObjectsTotalConsume entity) {
        getDao().save(entity);
    }

    public void update(ObjectsTotalConsume entity) {
        getDao().update(entity);
    }

    public void delete(ObjectsTotalConsume entity) {
        getDao().delete(entity);
    }
}
