package team.curise.entity.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import team.curise.dao.BaseDao;
import team.curise.dao.ConsumptionDao;
import team.curise.entity.Consumption;

@Service
public class ConsumptionService extends BaseService<Consumption> {

    @Resource
    private ConsumptionDao consumptionDao;

    @Override
    public BaseDao<Consumption> getDao() {
        return consumptionDao;
    }

    public void save(Consumption entity) {
        getDao().save(entity);
    }

    public void update(Consumption entity) {
        getDao().update(entity);
    }

    public void delete(Consumption entity) {
        getDao().delete(entity);
    }

}
