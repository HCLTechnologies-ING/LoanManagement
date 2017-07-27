package com.hcl.loan.model;

import java.util.Date;

public class LoanDisbursment {

	private Long userId;
    private Long LoanId;
    private Date disbursmentDate;
    private Integer  numberOfChecks;
    private String disbursmentMode;
    private String emailNotification;
    
	
	public String getEmailNotification() {
		return emailNotification;
	}
	public void setEmailNotification(String emailNotification) {
		this.emailNotification = emailNotification;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getLoanId() {
		return LoanId;
	}
	public void setLoanId(Long loanId) {
		LoanId = loanId;
	}
	public Date getDisbursmentDate() {
		return disbursmentDate;
	}
	public void setDisbursmentDate(Date disbursmentDate) {
		this.disbursmentDate = disbursmentDate;
	}
	public Integer getNumberOfChecks() {
		return numberOfChecks;
	}
	public void setNumberOfChecks(Integer numberOfChecks) {
		this.numberOfChecks = numberOfChecks;
	}
	public String getDisbursmentMode() {
		return disbursmentMode;
	}
	public void setDisbursmentMode(String disbursmentMode) {
		this.disbursmentMode = disbursmentMode;
	}
	
    public String toString()
    {
    	
    	return "";//for now leave it
    }
    
}
