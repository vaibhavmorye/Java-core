/**
 * 
 */
package com.geotracker.geoTracker.dto;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author VijayChauhanBPRISE
 *
 */
public class PageRequestDTO {

	public Map<String, String>	filter;
	private boolean				newSearch	= true;
	private int					pageNo		= 0;	// Page number is '0'
	// indexed
	private int pageSize = 10;

	private String				searchText;
	private Map<String, String>	sorting;

	public Direction getDirection() {
		if (sorting != null && sorting.size() > 0) {
			Set<Entry<String, String>> entrySet = sorting.entrySet();
			for (Entry<String, String> entry : entrySet) {
				if ("asc".equalsIgnoreCase(entry.getValue())) {
					return Direction.ASC;
				} else if ("desc".equalsIgnoreCase(entry.getValue())) {
					return Direction.DESC;
				}
			}
		}
		return Direction.ASC;
	}

	public Map<String, String> getFilter() {
		return filter;
	}

	public int getPageNo() {
		return pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public String getSearchText() {
		return searchText;
	}

	public String getSortColumn() {
		if (sorting != null && sorting.size() > 0) {
			Set<Entry<String, String>> entrySet = sorting.entrySet();
			for (Entry<String, String> entry : entrySet) {
				return entry.getKey();
			}
		}
		return "id";
	}

	public Map<String, String> getSorting() {
		return sorting;
	}

	public boolean isNewSearch() {
		return newSearch;
	}

	public void setFilter(Map<String, String> filter) {
		this.filter = filter;
	}

	public void setNewSearch(boolean newSearch) {
		this.newSearch = newSearch;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public void setSorting(Map<String, String> sorting) {
		this.sorting = sorting;
	}

	public PageRequest toPageable() {
		return new PageRequest(this.pageNo, this.pageSize, this.getDirection(), this.getSortColumn());
	}

}
