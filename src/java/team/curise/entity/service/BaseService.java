package team.curise.entity.service;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;
import team.curise.dao.BaseDao;
import team.curise.page.entity.Page;

public abstract class BaseService<T>{
    public abstract BaseDao<T> getDao();
	
	public T get(Serializable id){
		return getDao().get(id);
	}
	
	public void save(T entity){
		getDao().save(entity);
	}
	
	public void update(T entity){
		getDao().update(entity);
	}
	
	public void delete(T entity){
		getDao().delete(entity);
	}
	
	public List find(String hql){
		return getDao().find(hql);
	}
	
	public List find(String hql,Object...params){
		return getDao().find(hql,params);
	}
	
	public Query createQuery(String hql,Object...params){
		return getDao().createQuery(hql, params);
	}
	
	public Page pageQuery(String hql,int pageNo,int pageSize,Object...params){
		return getDao().pageQuery(hql, pageNo, pageSize, params);
	}
        public List listQuery(String hql,Object...params){
            return getDao().listQuery(hql, params);
        }
	
}
