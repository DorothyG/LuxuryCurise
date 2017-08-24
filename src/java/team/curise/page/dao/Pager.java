/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.curise.page.dao;

import java.util.List;

/**
 *
 * @author pupu
 */
public class Pager<T>{

	private int pageSize;//每页显示多少条记录
	private int currentPage;//当前的页数
	private int totalRecord;//一共多少条记录
	private int totalPages;//一共多少页
	private List<T> dataList;//这一页要显示的数据
	public Pager() {
		super();
	}
	public Pager(int pageSize, int currentPage, int totalRecord,
			int totalPages, List<T> dataList) {
		super();
		this.pageSize = pageSize;
		this.currentPage = currentPage;
		this.totalRecord = totalRecord;
		this.totalPages = totalPages;
		this.dataList = dataList;
	}
	//这里会有人用 页数，每页的大小，源数据项来创建Pager吗,意思就是要通过这里的三个参数，来求出本Pager包括的另外几个参数
	public Pager(int pageNum,int pageSize,List<T> sourceList){
		if(sourceList==null){
			return;
		}
		this.totalRecord=sourceList.size();
		this.pageSize=pageSize;
		//总共的页数，就是总的记录大小除以每页的记录大小
		this.totalPages=sourceList.size()/pageSize;
		//如果当前请求的页数大于总的页数，就返回总的页数，否则就返回请求的页数
		this.currentPage=pageNum>totalPages?totalPages:pageNum;

		//当前页的起始索引
		int fromIndex = this.pageSize*(this.currentPage-1);
		//结束索引,可能出现这是最后一页，结束在中间，所以要与总的记录数相比较
		int toIndex = this.pageSize*this.currentPage>totalRecord?totalRecord:this.pageSize*this.currentPage;
		
		this.dataList=sourceList.subList(fromIndex, toIndex);
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public List<T> getDataList() {
		return dataList;
	}
	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}
	@Override
	public String toString() {
		return "Pager [pageSize=" + pageSize + ", currentPage=" + currentPage
				+ ", totalRecord=" + totalRecord + ", totalPages=" + totalPages
				+ ", dataList=" + dataList + "]";
	}
	
	
}
