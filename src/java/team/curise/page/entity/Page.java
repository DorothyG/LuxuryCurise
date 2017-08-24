/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.curise.page.entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pupu
 */
public class Page {

	public static int DEFAULT_PAGE_SIZE=8;
	private int pageSize = DEFAULT_PAGE_SIZE;//每页的记录数
	private long start;//当前页第一条数据在list中的位置
	private List data;//当前页存放的记录
	private long totalCount;//总记录数
	
	public Page(int pageSize, long start, List data, long totalCount) {
		super();
		this.pageSize = pageSize;
		this.start = start;
		this.data = data;
		this.totalCount = totalCount;
	}
	
	public Page() {
		this(DEFAULT_PAGE_SIZE, 0, new ArrayList(), 0);
	}

	/**
	 * 取每页数据容量
	 * @return
	 */
	public int getPageSize() {
		return pageSize;
	}

	public long getStart() {
		return start;
	}

	/**
	 * 取当前页中的记录
	 * @return
	 */
	public List getData() {
		return data;
	}

	/**
	 * 取总记录数
	 * @return
	 */
	public long getTotalCount() {
		return totalCount;
	}

	/**
	 * 多出的没有满一页也要加上一页，取总页数
	 * @return
	 */
	public long getTotalPageCount(){
		if(totalCount%pageSize==0){
			return totalCount/pageSize;
		}else{
			return totalCount/pageSize+1;
		}
	}
	
	/**
	 * 取当前页码
	 * @return
	 */
	public long getCurrentPageNo(){
		return start/pageSize+1;
	}
	
	/**
	 * 是否还有下一页
	 * @return
	 */
	public boolean isHasNextPage(){
		return getCurrentPageNo()<getTotalPageCount();
	}
	
	/**
	 * 是否还有下一页
	 * @return
	 */
	public boolean isHasPrePage(){
		return getCurrentPageNo()>1;
	}
	
	/**
	 * 获取任一页第一条数据在数据集中的位置
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public static int getStartOfPage(int pageNo,int pageSize){
		return pageSize*(pageNo-1);
	}
	
	/**
	 * 获取任一页在数据集中的位置，采用默认页大小
	 * @param pageNo
	 * @return
	 */
	public static int getStartOfPage(int pageNo){
		return getStartOfPage(pageNo, DEFAULT_PAGE_SIZE);
	}
}

