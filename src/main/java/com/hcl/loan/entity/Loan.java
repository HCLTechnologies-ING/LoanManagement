package com.hcl.loan.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.math.BigInteger;
import java.util.List;


/**
 * The persistent class for the loan database table.
 * 
 */
@Entity
@NamedQuery(name="Loan.findAll", query="SELECT l FROM Loan l")
public class Loan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="LOAN_ID")
	private String loanId;

	@Column(name="APPLIED_LOAN_AMOUNT")
	private double appliedLoanAmount;

	@Column(name="APPROVED_LOAN_AMOUNT")
	private double approvedLoanAmount;

	@Temporal(TemporalType.DATE)
	@Column(name="COMMENCEMENT_DATE")
	private Date commencementDate;

	@Temporal(TemporalType.DATE)
	@Column(name="COMPLETION_DATE")
	private Date completionDate;

	@Column(name="INTEREST_RATE")
	private double interestRate;

	@Column(name="LOAN_STATUS")
	private String loanStatus;

	@Column(name="LOAN_TYPE_ID")
	private BigInteger loanTypeId;

	@Column(name="PENDING_WITH")
	private String pendingWith;

	private String remarks;

	private int tenure;

	@Column(name="TOTAL_REPAID_AMOUNT")
	private double totalRepaidAmount;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private User user;

	//bi-directional many-to-one association to LoanAuditlog
	@OneToMany(mappedBy="loan")
	private List<LoanAuditlog> loanAuditlogs;

	//bi-directional one-to-one association to LoanDisbursement
	@OneToOne
	@JoinColumn(name="DISBURSEMENT_ID")
	private LoanDisbursement loanDisbursement;

	public Loan() {
	}

	public String getLoanId() {
		return this.loanId;
	}

	public void setLoanId(String loanId) {
		this.loanId = loanId;
	}

	public double getAppliedLoanAmount() {
		return this.appliedLoanAmount;
	}

	public void setAppliedLoanAmount(double appliedLoanAmount) {
		this.appliedLoanAmount = appliedLoanAmount;
	}

	public double getApprovedLoanAmount() {
		return this.approvedLoanAmount;
	}

	public void setApprovedLoanAmount(double approvedLoanAmount) {
		this.approvedLoanAmount = approvedLoanAmount;
	}

	public Date getCommencementDate() {
		return this.commencementDate;
	}

	public void setCommencementDate(Date commencementDate) {
		this.commencementDate = commencementDate;
	}

	public Date getCompletionDate() {
		return this.completionDate;
	}

	public void setCompletionDate(Date completionDate) {
		this.completionDate = completionDate;
	}

	public double getInterestRate() {
		return this.interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public String getLoanStatus() {
		return this.loanStatus;
	}

	public void setLoanStatus(String loanStatus) {
		this.loanStatus = loanStatus;
	}

	public BigInteger getLoanTypeId() {
		return this.loanTypeId;
	}

	public void setLoanTypeId(BigInteger loanTypeId) {
		this.loanTypeId = loanTypeId;
	}

	public String getPendingWith() {
		return this.pendingWith;
	}

	public void setPendingWith(String pendingWith) {
		this.pendingWith = pendingWith;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public int getTenure() {
		return this.tenure;
	}

	public void setTenure(int tenure) {
		this.tenure = tenure;
	}

	public double getTotalRepaidAmount() {
		return this.totalRepaidAmount;
	}

	public void setTotalRepaidAmount(double totalRepaidAmount) {
		this.totalRepaidAmount = totalRepaidAmount;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<LoanAuditlog> getLoanAuditlogs() {
		return this.loanAuditlogs;
	}

	public void setLoanAuditlogs(List<LoanAuditlog> loanAuditlogs) {
		this.loanAuditlogs = loanAuditlogs;
	}

	public LoanAuditlog addLoanAuditlog(LoanAuditlog loanAuditlog) {
		getLoanAuditlogs().add(loanAuditlog);
		loanAuditlog.setLoan(this);

		return loanAuditlog;
	}

	public LoanAuditlog removeLoanAuditlog(LoanAuditlog loanAuditlog) {
		getLoanAuditlogs().remove(loanAuditlog);
		loanAuditlog.setLoan(null);

		return loanAuditlog;
	}

	public LoanDisbursement getLoanDisbursement() {
		return this.loanDisbursement;
	}

	public void setLoanDisbursement(LoanDisbursement loanDisbursement) {
		this.loanDisbursement = loanDisbursement;
	}

}