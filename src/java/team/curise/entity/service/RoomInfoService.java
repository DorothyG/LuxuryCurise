package team.curise.entity.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import team.curise.dao.BaseDao;
import team.curise.dao.RoomInfoDao;
import team.curise.entity.RoomInfo;

@Service
public class RoomInfoService extends BaseService<RoomInfo> {
    
     @Resource
    private RoomInfoDao roomInfoDao;

    @Override
    public BaseDao<RoomInfo> getDao() {
        return roomInfoDao;
    }

    public void save(RoomInfo entity) {
        getDao().save(entity);
    }

    public void update(RoomInfo entity) {
        getDao().update(entity);
    }

    public void delete(RoomInfo entity) {
        getDao().delete(entity);
    }

}
