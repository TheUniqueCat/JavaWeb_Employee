package com.message;

public class Message {
	private int message_id;
	private String message_content;
	private int notice_id;
	private int applicant_id;
	
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getNotice_id() {
		return notice_id;
	}

	public void setNotice_id(int notice_id) {
		this.notice_id = notice_id;
	}

	public int getApplicant_id() {
		return applicant_id;
	}

	public void setApplicant_id(int applicant_id) {
		this.applicant_id = applicant_id;
	}

	public int getMessage_id() {
		return message_id;
	}
	public void setMessage_id(int message_id) {
		this.message_id = message_id;
	}
	public String getMessage_content() {
		return message_content;
	}
	public void setMessage_content(String message_content) {
		this.message_content = message_content;
	}
	public Message(String message_content) {
		super();
		this.message_content = message_content;
	}

	@Override
	public String toString() {
		return "Message [message_id=" + message_id + ", message_content=" + message_content + ", notice_id=" + notice_id
				+ ", applicant_id=" + applicant_id + "]";
	}
	

}
