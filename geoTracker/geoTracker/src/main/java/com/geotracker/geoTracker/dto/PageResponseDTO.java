/**
 * 
 */
package com.geotracker.geoTracker.dto;

import org.springframework.data.domain.Page;

/**
 * @author VijayChauhanBPRISE
 *
 */
public class PageResponseDTO extends ResponseDTO {

	private Page page;

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

}
