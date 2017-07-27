package com.hcl.loan.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Loan implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1461934723929503402L;
	private Long loanId;
	private Long roleName;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private Double monthlyEMI;
	private Double monthlyInterest;
	private Integer tenure;
	private Double appliedLoanAmount;
	private Double approvedLoanAmount;
	private Double totalRepaidAmount;
	private String loanStatus;
	private String pendingWith;
	private String remarks;

	public Long getLoanId() {
		return loanId;
	}

	public void setLoanId(final Long loanId) {
		this.loanId = loanId;
	}

	public Long getRoleName() {
		return roleName;
	}

	public void setRoleName(final Long roleName) {
		this.roleName = roleName;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(final LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(final LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public Double getMonthlyEMI() {
		return monthlyEMI;
	}

	public void setMonthlyEMI(final Double monthlyEMI) {
		this.monthlyEMI = monthlyEMI;
	}

	public Double getMonthlyInterest() {
		return monthlyInterest;
	}

	public void setMonthlyInterest(final Double monthlyInterest) {
		this.monthlyInterest = monthlyInterest;
	}

	public Integer getTenure() {
		return tenure;
	}

	public void setTenure(final Integer tenure) {
		this.tenure = tenure;
	}

	public Double getAppliedLoanAmount() {
		return appliedLoanAmount;
	}

	public void setAppliedLoanAmount(final Double appliedLoanAmount) {
		this.appliedLoanAmount = appliedLoanAmount;
	}

	public Double getApprovedLoanAmount() {
		return approvedLoanAmount;
	}

	public void setApprovedLoanAmount(final Double approvedLoanAmount) {
		this.approvedLoanAmount = approvedLoanAmount;
	}

	public Double getTotalRepaidAmount() {
		return totalRepaidAmount;
	}

	public void setTotalRepaidAmount(final Double totalRepaidAmount) {
		this.totalRepaidAmount = totalRepaidAmount;
	}

	public String getLoanStatus() {
		return loanStatus;
	}

	public void setLoanStatus(final String loanStatus) {
		this.loanStatus = loanStatus;
	}

	public String getPendingWith() {
		return pendingWith;
	}

	public void setPendingWith(final String pendingWith) {
		this.pendingWith = pendingWith;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(final String remarks) {
		this.remarks = remarks;
	}

}
