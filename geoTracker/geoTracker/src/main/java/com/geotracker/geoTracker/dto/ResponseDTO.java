package com.geotracker.geoTracker.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

@JsonInclude(Include.NON_NULL)
@ApiObject(name = "Response", description = "Parent response object for particular object")
public class ResponseDTO {
	@JsonIgnore
	@JsonProperty(value = "error_code")
	@ApiObjectField(name = "error_code", description = "Error code for the failed request")
	private String	errorId;
	@JsonIgnore
	@JsonProperty(value = "error_msg")
	@ApiObjectField(name = "error_msg", description = "Error message for the failed request")
	private String	errorMsg;

	@JsonIgnore
	@JsonProperty(value = "status_code")
	@ApiObjectField(name = "status_code", description = "Error status code for the failed request")
	private String statusCode;

	@JsonIgnore
	@JsonProperty(value = "status")
	@ApiObjectField(name = "status", description = "Status of the request")
	private String responseStatus;

	public String getErrorId() {
		return errorId;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public String getResponseStatus() {
		return responseStatus;
	}

	public void setErrorId(String errorId) {
		this.errorId = errorId;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

}
