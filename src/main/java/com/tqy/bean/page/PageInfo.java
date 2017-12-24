package com.tqy.bean.page;

import java.util.ArrayList;
import java.util.List;

public class PageInfo extends PageBean{
	
	public PageInfo(){
		super();
	}
	
	public PageInfo(List<Object> originate, Integer pn, Integer pageSize, Integer navigateSize){
		Integer listSize = originate.size();
		super.setTotal(listSize);
		super.setPageNum(pn);
		super.setPageSize(pageSize);
		super.setNavigatePages(navigateSize);
		
		super.setStartRow(buildStartRow(pn, pageSize));
		super.setEndRow(buildEndRow(listSize, pn, pageSize));
		
		super.setHasNextPage(buildHasNextPage(listSize, pn, pageSize));
		super.setHasPreviousPage(buildHasPreviousPage(pn));
		
		super.setFirstPage(buildIsFirstPage(pn));
		super.setLastPage(buildIsLastPage(listSize, pn, pageSize));
		
		super.setFirstPage(buildFirstPage());
		super.setLastPage(buildLastPage(listSize, pageSize));
		
		super.setList(buildList(originate, pn));
		
		super.setNavigateFirstPage(buildNavigateFirstPage(listSize, pageSize, pn, navigateSize));
		super.setNavigateLastPage(buildNavigateLastPage(listSize, pageSize, pn, navigateSize));
		super.setNavigatepageNums(buildNnavigatepageNums(listSize, pageSize, pn, navigateSize));
		
		super.setPrePage(buildPrePage(pn));
		super.setNextPage(buildNextPage(listSize, pn, pageSize));
		
		super.setPages(buildPages(listSize, pageSize));
		super.setSize(buildSize(listSize, pn, pageSize));
	}
	
	public Integer buildStartRow(Integer pn, Integer pageSize){
		Integer startRow = (pn - 1) * pageSize + 1;
		return startRow;
	}
	
	public Integer buildEndRow(Integer listSize, Integer pn, Integer pageSize){
		Integer endRow = null;
		Integer tmp = Math.floorDiv(listSize, pageSize)+1;
		if (pn == tmp) {
			endRow = listSize - (pn - 1) * pageSize;
		} else {
			endRow = 5;
		}
		return endRow+(pn-1)*pageSize;
	}
	
	public boolean buildHasNextPage(Integer listSize, Integer pn, Integer pageSize){
		boolean hasNextPage = false;
		Integer tmp = Math.floorDiv(listSize, pageSize)+1;
		if (pn != tmp){
			hasNextPage = true;
		}
		return hasNextPage;
	}
	
	public boolean buildHasPreviousPage(Integer pn){
		return pn == 1? false : true;
	}
	
	public boolean buildIsFirstPage(Integer pn){
		return pn == 1? true : false;
	}
	
	public boolean buildIsLastPage(Integer listSize, Integer pn, Integer pageSize){
		boolean isLastPage = false;
		Integer tmp = Math.floorDiv(listSize, pageSize)+1;
		if (pn == tmp){
			isLastPage = true;
		}
		return isLastPage;
	}
	
	public Integer buildFirstPage(){
		return 1;
	}
	
	public Integer buildLastPage(Integer listSize, Integer pageSize){	
		return Math.floorDiv(listSize, pageSize)+1;
	}
	
	public List<Object> buildList(List<Object> originate, Integer pn){
		Integer startRow = super.getStartRow();
		Integer listSize = originate.size();
		Integer endRow = super.getEndRow();
		
		List<Object> list = new ArrayList<Object>();
		for (int i = 0; i < listSize; i++){
			if (i >= startRow-1){
				if (i > endRow-1){
					break;
				}
				list.add(originate.get(i));
			}
		}
		return list;
	}
	
	public Integer buildNavigateFirstPage(Integer listSize, Integer pageSize, Integer pn, Integer navigateSize){
		Integer start = pn - Math.floorDiv(navigateSize, 2);
		if (start <= 0){
			return 1;
		} else {
			return start;
		}
	}
	
	public Integer buildNavigateLastPage(Integer listSize, Integer pageSize, Integer pn, Integer navigateSize){
		Integer pages = buildPages(listSize, pageSize);
		Integer end = null;
		if (navigateSize % 2 == 0){
			end = pn + Math.floorDiv(navigateSize,2)-1; 
		} else {
			end = pn + Math.floorDiv(navigateSize,2); 
		}
		if (end >= pages){
			return pages;
		} else {
			return buildNavigateFirstPage(listSize,pageSize,pn,navigateSize)+navigateSize-1;
		}
	}
	
	public List<Integer> buildNnavigatepageNums(Integer listSize, Integer pageSize, Integer pn, Integer navigateSize){
		List<Integer> list = new ArrayList<Integer>();
		Integer pages = buildPages(listSize, pageSize);
		Integer tmp = 0;
		Integer start = pn - Math.floorDiv(navigateSize, 2);
		boolean flag = false;
		for(int i = 1; i <= pages; i++){
			if (start <= 0 ){
				if (tmp == navigateSize){
					break;
				}
				list.add(i);
//				System.out.println("<0:  "+list);
				tmp++;
			} else {
				if (i == start){
					flag = true;
				}
				if (tmp == navigateSize){
					break;
				}
				if (flag && tmp != navigateSize){
					list.add(i);
					tmp++;
				}
//				System.out.println(">0:  "+list);
			}
		}
		return list;
	}
	
	public Integer buildPrePage(Integer pn){
		return pn == 1 ? 1 : pn - 1;
	}
	
	public Integer buildNextPage(Integer listSize, Integer pn, Integer pageSize){
		Integer tmp = Math.floorDiv(listSize, pageSize)+1;
		if (pn == tmp){
			return pn;
		} else {
			return pn + 1;
		}
	}
	
	public Integer buildPages(Integer listSize, Integer pageSize){
		return Math.floorDiv(listSize, pageSize)+1;
	}
	
	public Integer buildSize(Integer listSize, Integer pn, Integer pageSize){
		Integer tmp = Math.floorDiv(listSize, pageSize)+1;
		if (pn == tmp){
			return listSize - (pn - 1) * pageSize;
		} else {
			return pageSize;
		}
	}
	
	
	public String toString() {
		return super.toString();
	}
}
