package team.curise.entity.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import team.curise.dao.BaseDao;
import team.curise.dao.DepartMonthRevenueDao;
import team.curise.entity.DepartMonthRevenue;

@Service
public class DepartMonthRevenueService extends BaseService<DepartMonthRevenue> {

    
     @Resource
    private DepartMonthRevenueDao departMonthRevenueDao;
    @Override
    public BaseDao<DepartMonthRevenue> getDao() {
        return departMonthRevenueDao;
    }
 public void save(DepartMonthRevenue entity) {
        getDao().save(entity);
    }

    public void update(DepartMonthRevenue entity) {
        getDao().update(entity);
    }

    public void delete(DepartMonthRevenue entity) {
        getDao().delete(entity);
    }

}
