package com.hcl.loan.model;

import java.io.Serializable;
import java.time.LocalDateTime;
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
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private int loanTypeId;
	private int userId; 
	private Double monthlyEMI;
	private Double monthlyInterest;
	private Integer tenure;
	private Double appliedLoanAmount;
	private Double approvedLoanAmount;
	private Double totalRepaidAmount;
	private String loanStatus;
	private String pendingWith;
	private String remarks;
	private boolean eligible;
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
	public LocalDateTime getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}
	public LocalDateTime getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}
	public int getLoanTypeId() {
		return loanTypeId;
	}
	public void setLoanTypeId(int loanTypeId) {
		this.loanTypeId = loanTypeId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
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
	public boolean isEligible() {
		return eligible;
	}
	public void setEligible(boolean eligible) {
		this.eligible = eligible;
	}
	
}
