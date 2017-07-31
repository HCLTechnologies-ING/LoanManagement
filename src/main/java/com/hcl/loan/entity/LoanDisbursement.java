package com.hcl.loan.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

/**
 * The persistent class for the loan_disbursement database table.
 * 
 */
@Entity
@Table(name = "loan_disbursement")
@NamedQuery(name = "LoanDisbursement.findAll", query = "SELECT l FROM LoanDisbursement l")
public class LoanDisbursement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "DISBURSEMENT_ID")
	private double disbursementId;

	@Column(name = "CREATED_BY")
	private BigInteger createdBy;

	//@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_DATE")
	private Date createdDate;

	@Column(name = "DISBURSED_TO_ACCOUNT")
	private String disbursedToAccount;

	//@Temporal(TemporalType.DATE)
	@Column(name = "DISBURSEMENT_DATE")
	private Date disbursementDate;

	@Column(name = "DISBURSEMENT_MODE")
	private String disbursementMode;

	@Column(name = "LOAN_ID")
	private BigInteger loanId;

	@Column(name = "MODIFY_BY")
	private BigInteger modifyBy;

	//@Temporal(TemporalType.DATE)
	@Column(name = "MODIFY_DATE")
	private Date modifyDate;

	@Column(name = "NO_PDC_COLLECTED")
	private int noPdcCollected;

	@Column(name = "NOTIFICATION_SENT")
	private String notificationSent;

	// bi-directional one-to-one association to Loan
	@OneToOne(mappedBy = "loanDisbursement")
	private Loan loan;

	public LoanDisbursement() {
	}

	public double getDisbursementId() {
		return this.disbursementId;
	}

	public void setDisbursementId(double disbursementId) {
		this.disbursementId = disbursementId;
	}

	public BigInteger getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(BigInteger createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getDisbursedToAccount() {
		return this.disbursedToAccount;
	}

	public void setDisbursedToAccount(String disbursedToAccount) {
		this.disbursedToAccount = disbursedToAccount;
	}

	public Date getDisbursementDate() {
		return this.disbursementDate;
	}

	public void setDisbursementDate(Date disbursementDate) {
		this.disbursementDate = disbursementDate;
	}

	public String getDisbursementMode() {
		return this.disbursementMode;
	}

	public void setDisbursementMode(String disbursementMode) {
		this.disbursementMode = disbursementMode;
	}

	public BigInteger getLoanId() {
		return this.loanId;
	}

	public void setLoanId(BigInteger loanId) {
		this.loanId = loanId;
	}

	public BigInteger getModifyBy() {
		return this.modifyBy;
	}

	public void setModifyBy(BigInteger modifyBy) {
		this.modifyBy = modifyBy;
	}

	public Date getModifyDate() {
		return this.modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public int getNoPdcCollected() {
		return this.noPdcCollected;
	}

	public void setNoPdcCollected(int noPdcCollected) {
		this.noPdcCollected = noPdcCollected;
	}

	public String getNotificationSent() {
		return this.notificationSent;
	}

	public void setNotificationSent(String notificationSent) {
		this.notificationSent = notificationSent;
	}

	public Loan getLoan() {
		return this.loan;
	}

	public void setLoan(Loan loan) {
		this.loan = loan;
	}

}