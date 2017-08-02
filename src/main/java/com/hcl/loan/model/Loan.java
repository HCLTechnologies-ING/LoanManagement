package com.hcl.loan.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
/**
 * 
 * Model class for Loan.
 * 
 *
 */
public class Loan implements Serializable {
	
	/**
	 * Serial version unique id
	 */
	private static final long serialVersionUID = 1461934723929503402L;
	
	private Long loanId;
	private Long roleName;
	private Date startDate;
	private Date endDate;
	private Integer loanTypeId;
	private Integer userId; 
	private Double monthlyEMI;
	private Double monthlyInterest;
	private Integer tenure;
	private Double appliedLoanAmount;
	private Double approvedLoanAmount;
	private Double totalRepaidAmount;
	private String loanStatus;
	private String pendingWith;
	private String remarks;
	private Boolean eligible;
	private Double disbursementId;
	
	public Long getLoanId() {
		return loanId;
	}
	public void setLoanId(Long loanId) {
		this.loanId = loanId;
	}
	public Long getRoleName() {
		return roleName;
	}
	public void setRoleName(Long roleName) {
		this.roleName = roleName;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Integer getLoanTypeId() {
		return loanTypeId;
	}
	public void setLoanTypeId(Integer loanTypeId) {
		this.loanTypeId = loanTypeId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Double getMonthlyEMI() {
		return monthlyEMI;
	}
	public void setMonthlyEMI(Double monthlyEMI) {
		this.monthlyEMI = monthlyEMI;
	}
	public Double getMonthlyInterest() {
		return monthlyInterest;
	}
	public void setMonthlyInterest(Double monthlyInterest) {
		this.monthlyInterest = monthlyInterest;
	}
	public Integer getTenure() {
		return tenure;
	}
	public void setTenure(Integer tenure) {
		this.tenure = tenure;
	}
	public Double getAppliedLoanAmount() {
		return appliedLoanAmount;
	}
	public void setAppliedLoanAmount(Double appliedLoanAmount) {
		this.appliedLoanAmount = appliedLoanAmount;
	}
	public Double getApprovedLoanAmount() {
		return approvedLoanAmount;
	}
	public void setApprovedLoanAmount(Double approvedLoanAmount) {
		this.approvedLoanAmount = approvedLoanAmount;
	}
	public Double getTotalRepaidAmount() {
		return totalRepaidAmount;
	}
	public void setTotalRepaidAmount(Double totalRepaidAmount) {
		this.totalRepaidAmount = totalRepaidAmount;
	}
	public String getLoanStatus() {
		return loanStatus;
	}
	public void setLoanStatus(String loanStatus) {
		this.loanStatus = loanStatus;
	}
	public String getPendingWith() {
		return pendingWith;
	}
	public void setPendingWith(String pendingWith) {
		this.pendingWith = pendingWith;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Boolean getEligible() {
		return eligible;
	}
	public void setEligible(Boolean eligible) {
		this.eligible = eligible;
	}
	public Double getDisbursementId() {
		return disbursementId;
	}
	public void setDisbursementId(Double disbursementId) {
		this.disbursementId = disbursementId;
	}	
}
