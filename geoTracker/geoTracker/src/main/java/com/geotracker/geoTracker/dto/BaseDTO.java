/**
 * 
 */
package com.geotracker.geoTracker.dto;

import java.util.Date;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonInclude(Include.NON_NULL)
@ApiObject(name = "CommonField", description = "Represents common filed for the all the objects")
public class BaseDTO extends ResponseDTO {

	// @JsonIgnore
	@JsonProperty(value = "created_by")
	@ApiObjectField(name = "created_by", description = "Unique id of the user who has created this particular object")
	private Long createdBy;
	// @JsonIgnore
	@JsonProperty(value = "created_date")
	@ApiObjectField(name = "created_date", description = "Created date of this object")
	private Date	createdDate;
	@JsonProperty(value = "id")
	@ApiObjectField(name = "id", description = "Unique id of the this object")
	private Long	id;
	// @JsonIgnore
	@JsonProperty(value = "updated_by")
	@ApiObjectField(name = "updated_by", description = "Unique id of the user who has updated this particular object")
	private Long updatedBy;
	// @JsonIgnore
	@JsonProperty(value = "updated_date")
	@ApiObjectField(name = "updated_date", description = "Updated date of this object")
	private Date updatedDate;

	/**
	 * This flag must be used for the Objects being created without the User's
	 * Login, Which will be used to bypass the Creator/Updater Audit
	 */
	@JsonIgnore
	private boolean withoutLogin = false;

	public Long getCreatedBy() {
		return createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public Long getId() {
		return id;
	}

	public Long getUpdatedBy() {
		return updatedBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public boolean isWithoutLogin() {
		return withoutLogin;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public void setWithoutLogin(boolean withoutLogin) {
		this.withoutLogin = withoutLogin;
	}

}
