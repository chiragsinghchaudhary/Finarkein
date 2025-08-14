//Generic structure for wrapping all responses if needed
package com.ashika.data.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponse {

	@JsonProperty("status")
	private boolean success;

	@JsonProperty("message")
	private String message;

	@JsonProperty("errorcode")
	private String errorCode;

	@JsonProperty("errorMessage")
	private String errorMessage;

	@JsonProperty("devError")
	private String devErrorMsg;

	@JsonProperty("traceId")
	private String traceId;

	@JsonProperty("timestamp")
	private String timestamp;

	@JsonProperty("data")
	private Object data;

	// Getters and Setters

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getDevErrorMsg() {
		return devErrorMsg;
	}

	public void setDevErrorMsg(String devErrorMsg) {
		this.devErrorMsg = devErrorMsg;
	}

	public String getTraceId() {
		return traceId;
	}

	public void setTraceId(String traceId) {
		this.traceId = traceId;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
