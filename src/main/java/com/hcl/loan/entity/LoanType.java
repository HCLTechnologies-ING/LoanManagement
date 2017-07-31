package com.hcl.loan.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the loan_type database table.
 * 
 */
@Entity
@Table(name="loan_type")
@NamedQuery(name="LoanType.findAll", query="SELECT l FROM LoanType l")
public class LoanType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="LOAN_TYPE_ID")
	private String loanTypeId;

	@Column(name="INTEREST_RATE")
	private double interestRate;

	@Column(name="LOAN_TYPE")
	private String loanType;

	public LoanType() {
	}

	public String getLoanTypeId() {
		return this.loanTypeId;
	}

	public void setLoanTypeId(String loanTypeId) {
		this.loanTypeId = loanTypeId;
	}

	public double getInterestRate() {
		return this.interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public String getLoanType() {
		return this.loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

}