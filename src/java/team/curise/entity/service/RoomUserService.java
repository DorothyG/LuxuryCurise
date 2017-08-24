package team.curise.entity.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import team.curise.dao.BaseDao;
import team.curise.dao.RoomUserDao;
import team.curise.entity.RoomUser;


@Service
public class RoomUserService extends BaseService<RoomUser> {

    
     @Resource
    private RoomUserDao roomUserDao;
     
    @Override
    public BaseDao<RoomUser> getDao() {
        return roomUserDao;
    }

    public void save(RoomUser entity) {
        getDao().save(entity);
    }

    public void update(RoomUser entity) {
        getDao().update(entity);
    }

    public void delete(RoomUser entity) {
        getDao().delete(entity);
    }

}
