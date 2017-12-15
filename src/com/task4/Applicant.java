package com.task4;

public class Applicant {
	private int applicantId;
	private String applicantEmail;
	private String applicantPwd;
	public Applicant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Applicant(int applicantId, String applicantEmail, String applicantPwd) {
		super();
		this.applicantId = applicantId;
		this.applicantEmail = applicantEmail;
		this.applicantPwd = applicantPwd;
	}
	public int getApplicantId() {
		return applicantId;
	}
	public void setApplicantId(int applicantId) {
		this.applicantId = applicantId;
	}
	public String getApplicantEmail() {
		return applicantEmail;
	}
	public void setApplicantEmail(String applicantEmail) {
		this.applicantEmail = applicantEmail;
	}
	public String getApplicantPwd() {
		return applicantPwd;
	}
	public void setApplicantPwd(String applicantPwd) {
		this.applicantPwd = applicantPwd;
	}
	@Override
	public String toString() {
		return "Applicant [applicantId=" + applicantId + ", applicantEmail=" + applicantEmail + "]";
	}
	
	
	
}
