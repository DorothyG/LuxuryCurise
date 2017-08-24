package team.curise.entity.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import team.curise.dao.BaseDao;
import team.curise.dao.DepartYearRevenueDao;
import team.curise.entity.DepartYearRevenue;

@Service
public class DepartYearRevenueService extends BaseService<DepartYearRevenue> {
 
    
    @Resource
    private DepartYearRevenueDao departYearRevenueDao;
    @Override
    public BaseDao<DepartYearRevenue> getDao() {
       return departYearRevenueDao;
    }

    public void save(DepartYearRevenue entity) {
        getDao().save(entity);
    }

    public void update(DepartYearRevenue entity) {
        getDao().update(entity);
    }

    public void delete(DepartYearRevenue entity) {
        getDao().delete(entity);
    }
}
