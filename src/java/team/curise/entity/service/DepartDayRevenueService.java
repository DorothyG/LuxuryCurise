package team.curise.entity.service;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import team.curise.dao.BaseDao;
import team.curise.dao.DepartDayRevenueDao;
import team.curise.entity.DepartDayRevenue;

@Service
public class DepartDayRevenueService extends BaseService<DepartDayRevenue> {

    @Resource
    private DepartDayRevenueDao departDayRevenueDao;
    @Override
    public BaseDao<DepartDayRevenue> getDao() {
        return departDayRevenueDao;
    }
 public void save(DepartDayRevenue entity) {
        getDao().save(entity);
    }

    public void update(DepartDayRevenue entity) {
        getDao().update(entity);
    }

    public void delete(DepartDayRevenue entity) {
        getDao().delete(entity);
    }

}
