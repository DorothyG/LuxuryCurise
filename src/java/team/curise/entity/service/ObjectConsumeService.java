package team.curise.entity.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import team.curise.dao.BaseDao;
import team.curise.dao.ObjectConsumeDao;
import team.curise.entity.ObjectsConsume;

@Service
public class ObjectConsumeService extends BaseService<ObjectsConsume>  {
    
     @Resource
    private ObjectConsumeDao objectConsumeDao;

    @Override
    public BaseDao<ObjectsConsume> getDao() {
      return objectConsumeDao;
    }

    public void save(ObjectsConsume entity) {
        getDao().save(entity);
    }

    public void update(ObjectsConsume entity) {
        getDao().update(entity);
    }

    public void delete(ObjectsConsume entity) {
        getDao().delete(entity);
    }
}
