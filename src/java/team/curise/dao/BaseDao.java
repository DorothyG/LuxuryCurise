/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.curise.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.util.Assert;
import team.curise.page.entity.Page;

/**
 *
 * @author pupu
 */
public class BaseDao<T> {
	private Class<T> entityClass;
	@Autowired
	private HibernateTemplate hibernateTemplate;
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public Session getSession(){
		return this.getHibernateTemplate().getSessionFactory().openSession();
	}
	/**
	 * 通过反射获取子类确定的泛型类
	 */
	public BaseDao(){
		Type rootType = getClass().getGenericSuperclass(); 
		Type[] params = ((ParameterizedType)rootType).getActualTypeArguments();
		entityClass = (Class)params[0];
	}
	
	/**
	 * 通过id获得entity实例
	 * @param id
	 * @return
	 */
	public T get(Serializable id){
		return (T)getHibernateTemplate().get(entityClass, id);
	}
	
	/**
	 * 保存entity实例
	 * @param entity
	 */
	public void save(T entity){
		Session session = getSession();
		Transaction tx = null;
		tx=session.beginTransaction();
		session.save(entity);
		tx.commit();
		session.flush();
	}
	
	/**
	 * 删除entity实例
	 * @param entity
	 */
	public void delete(T entity){
		Session session = getSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		session.delete(entity);
		tx.commit();
		session.flush();
	}
	
	/**
	 * 更新entity实例
	 * @param entity
	 */
	public void update(T entity){
		Session session = getSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		session.update(entity);
		tx.commit();
		session.flush();
	}
	
	/**
	 * 对延迟加载的实例进行初始化
	 * @param entity
	 */
	public void initialize(T entity){
		this.getHibernateTemplate().initialize(entity);
	}
	
	/**
	 * 执行不带参的hql查询
	 * @param hql
	 * @return
	 */
	public List find(String hql){
		return this.getHibernateTemplate().find(hql);
	}
	
	/**
	 * 执行带参数的hql查询
	 * @param hql
	 * @return
	 */
	public List find(String hql,Object...params){
		return this.getHibernateTemplate().find(hql, params);
	}
	
	/**
	 * 去除hql的select 子句，未考虑union的情况,用于pagedQuery.
	 * @see #pagedQuery(String,int,int,Object[])
	 * @param hql
	 * @return
	 */
	public static String removeSelect(String hql){
		Assert.hasText(hql);
		int beginPos = hql.toLowerCase().indexOf("from");
		Assert.isTrue(beginPos != -1, " hql : " + hql + " must has a keyword 'from'");
		return hql.substring(beginPos);
	}
	
	/**
	 * 去除orderby子句
	 * @param hql
	 * @return
	 */
	public static String removeOrders(String hql){
		Assert.hasText(hql);
		Pattern p = Pattern.compile("order\\s*by[\\w|\\W|\\s|\\S]*",Pattern.CASE_INSENSITIVE); 
		Matcher m = p.matcher(hql);
		StringBuffer sb = new StringBuffer();
		while(m.find()){
			m.appendReplacement(sb, "");
		}
		m.appendTail(sb);
		return sb.toString();
	}
	/**
	 * 创建Query对象. 对于需要first,max,fetchsize,cache,cacheRegion等诸多设置的函数,可以在返回Query后自行设置.
	 * 留意可以连续设置,如下：
	 * <pre>
	 * dao.getQuery(hql).setMaxResult(100).setCacheable(true).list();
	 * </pre>
	 * 调用方式如下：
	 * <pre>
	 *        dao.createQuery(hql)
	 *        dao.createQuery(hql,arg0);
	 *        dao.createQuery(hql,arg0,arg1);
	 *        dao.createQuery(hql,new Object[arg0,arg1,arg2])
	 * </pre>
	 *
	 * @param params 可变参数.
	 */
	public Query createQuery(String hql,Object...params){
		Assert.hasText(hql);
		Query query = getSession().createQuery(hql);
		for(int i=0;i<params.length;i++){
			query.setParameter(hql, params[i]);
		}
		return query;
	}
	
	/**
	 * 找到总记录数
	 * @param hql
	 * @param params
	 * @return
	 */
	public long findTotalCount(String hql,Object...params){
		List countList;
		String countQueryString = " select count (*) " + removeSelect(removeOrders(hql));
		countList = find(countQueryString,params);
		return (Long) countList.get(0);
	}
	
	/**
	 * 查询那一页
	 * @param hql
	 * @param pageNo
	 * @param pageSize
	 * @param params
	 * @return
	 */
	public Page pageQuery(String hql,int pageNo,int pageSize,Object...params){
		Assert.hasText(hql);
		Assert.isTrue(pageNo>=1,"page number should start from 1");
		long totalCount = findTotalCount(hql, params);
		if(totalCount<1){
			return new Page();
		}
		int startIndex = Page.getStartOfPage(pageNo, pageSize);
		Query query = createQuery(hql, params);
		//这样找到的就是这一页的，从startIndex开始，经过pageSize大小
		List list = query.setFirstResult(startIndex).setMaxResults(pageSize).list();
		return new Page(pageSize, startIndex, list, totalCount);
	}
        
        public List listQuery(String hql,Object...params){
            Query query = createQuery(hql,params);
            List list = query.list();
            return list;
        }
}

