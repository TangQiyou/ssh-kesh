package com.tqy.bean.page;

import java.util.List;

public class PageBean {
	private Integer startRow;    //本页开始行
	private Integer endRow;      //本页结尾行
	private boolean hasNextPage;     //是否有下一页
	private boolean hasPreviousPage; //是否有前一页
	private boolean isFirstPage; //是否第一页    
	private boolean isLastPage;  //是否最后一页
	private Integer firstPage;   //第一页页号
	private Integer lastPage;    //最后一页页号
	private List<Object> list = null;  //具体的分页内容的list
	private Integer navigateFirstPage; //横跨页的第一页
	private Integer navigateLastPage;  //横跨页的最后页
	private Integer navigatePages;     //横跨页的最大总页数
	private List<Integer> navigatepageNums;
	private Integer prePage;     //上一页页号
	private Integer pageNum;     //本页号
	private Integer nextPage;    //下一页页号
	private Integer pageSize;    //每一页最大数量
	private Integer pages;		 //总页数
	private Integer size;        //当前页数量
	private Integer total;       //总行数
	
	public PageBean() {
		super();
	}
	
	public Integer getStartRow() {
		return startRow;
	}
	public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}
	public Integer getEndRow() {
		return endRow;
	}
	public void setEndRow(Integer endRow) {
		this.endRow = endRow;
	}
	public boolean isHasNextPage() {
		return hasNextPage;
	}
	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}
	public boolean isHasPreviousPage() {
		return hasPreviousPage;
	}
	public void setHasPreviousPage(boolean hasPreviousPage) {
		this.hasPreviousPage = hasPreviousPage;
	}
	public boolean isFirstPage() {
		return isFirstPage;
	}
	public void setFirstPage(boolean isFirstPage) {
		this.isFirstPage = isFirstPage;
	}
	public boolean isLastPage() {
		return isLastPage;
	}
	public void setLastPage(boolean isLastPage) {
		this.isLastPage = isLastPage;
	}
	public Integer getFirstPage() {
		return firstPage;
	}
	public void setFirstPage(Integer firstPage) {
		this.firstPage = firstPage;
	}
	public Integer getLastPage() {
		return lastPage;
	}
	public void setLastPage(Integer lastPage) {
		this.lastPage = lastPage;
	}
	public List<Object> getList() {
		return list;
	}
	public void setList(List<Object> list) {
		this.list = list;
	}
	public Integer getNavigateFirstPage() {
		return navigateFirstPage;
	}
	public void setNavigateFirstPage(Integer navigateFirstPage) {
		this.navigateFirstPage = navigateFirstPage;
	}
	public Integer getNavigateLastPage() {
		return navigateLastPage;
	}
	public void setNavigateLastPage(Integer navigateLastPage) {
		this.navigateLastPage = navigateLastPage;
	}
	public Integer getNavigatePages() {
		return navigatePages;
	}
	public void setNavigatePages(Integer navigatePages) {
		this.navigatePages = navigatePages;
	}
	public List<Integer> getNavigatepageNums() {
		return navigatepageNums;
	}
	public void setNavigatepageNums(List<Integer> navigatepageNums) {
		this.navigatepageNums = navigatepageNums;
	}
	public Integer getPrePage() {
		return prePage;
	}
	public void setPrePage(Integer prePage) {
		this.prePage = prePage;
	}
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public Integer getNextPage() {
		return nextPage;
	}
	public void setNextPage(Integer nextPage) {
		this.nextPage = nextPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getPages() {
		return pages;
	}
	public void setPages(Integer pages) {
		this.pages = pages;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	
	@Override
	public String toString() {
		return "PageBean [startRow=" + startRow + ", endRow=" + endRow + ", hasNextPage=" + hasNextPage
				+ ", hasPreviousPage=" + hasPreviousPage + ", isFirstPage=" + isFirstPage + ", isLastPage=" + isLastPage
				+ ", firstPage=" + firstPage + ", lastPage=" + lastPage + ", list=" + list + ", navigateFirstPage="
				+ navigateFirstPage + ", navigateLastPage=" + navigateLastPage + ", navigatePages=" + navigatePages
				+ ", navigatepageNums=" + navigatepageNums + ", prePage=" + prePage + ", pageNum=" + pageNum
				+ ", nextPage=" + nextPage + ", pageSize=" + pageSize + ", pages=" + pages + ", size=" + size
				+ ", total=" + total + "]";
	}

	public PageBean(Integer startRow, Integer endRow, boolean hasNextPage, boolean hasPreviousPage, boolean isFirstPage,
			boolean isLastPage, Integer firstPage, Integer lastPage, List<Object> list, Integer navigateFirstPage,
			Integer navigateLastPage, Integer navigatePages, List<Integer> navigatepageNums, Integer prePage,
			Integer pageNum, Integer nextPage, Integer pageSize, Integer pages, Integer size, Integer total) {
		super();
		this.startRow = startRow;
		this.endRow = endRow;
		this.hasNextPage = hasNextPage;
		this.hasPreviousPage = hasPreviousPage;
		this.isFirstPage = isFirstPage;
		this.isLastPage = isLastPage;
		this.firstPage = firstPage;
		this.lastPage = lastPage;
		this.list = list;
		this.navigateFirstPage = navigateFirstPage;
		this.navigateLastPage = navigateLastPage;
		this.navigatePages = navigatePages;
		this.navigatepageNums = navigatepageNums;
		this.prePage = prePage;
		this.pageNum = pageNum;
		this.nextPage = nextPage;
		this.pageSize = pageSize;
		this.pages = pages;
		this.size = size;
		this.total = total;
	}
}
