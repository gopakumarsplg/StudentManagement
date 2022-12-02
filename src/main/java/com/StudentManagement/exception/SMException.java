package com.StudentManagement.exception;

import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

@NoArgsConstructor
public class SMException extends Exception {

	private String message;

	private int messageCode;

	private String causeMessage = "";

	public SMException(String message) {
		this.message = message;
	}

	public SMException(String message, int messageCode) {
		this.message = message;
		this.setMessageCode(messageCode);
	}

	public SMException(String message, int messageCode, String causeMessage) {
		super();
		this.message = message;
		this.messageCode = messageCode;
		this.causeMessage = causeMessage;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getMessageCode() {
		return messageCode;
	}

	public void setMessageCode(int messageCode) {
		this.messageCode = messageCode;
	}

	public String getCauseMessage() {
		return StringUtils.hasText(causeMessage) ? "" : " - " + causeMessage;
	}

	public void setCauseMessage(String causeMessage) {
		this.causeMessage = causeMessage;
	}
}