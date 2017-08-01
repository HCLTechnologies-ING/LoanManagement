package com.hcl.loan.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import com.hcl.loan.model.Loan;
import com.hcl.loan.entity.Role;
import com.hcl.loan.entity.UserAddress;

public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String userId;
	private String bankAccountNo;
	private String bankIfscCode;
	private String bankName;
	private BigInteger createdBy;
	private Date createdDate;
	private String currentEmployer;
	private Date dateofbirth;
	private String emailId;
	private String firstName;
	private String gender;
	private byte hniFlag;
	private String lastName;
	private String mobileNumber;
	private BigInteger modifiedBy;
	private Date modifiedDate;
	private String password;
	private String preferredLang;
	private String repaymentMode;
	private String status;
	private List<Loan> loans;
	private List<UserAddress> userAddresses;
	private Role role;
	
	public List<Loan> getLoans() {
		return loans;
	}
	public void setLoans(List<Loan> loans) {
		this.loans = loans;
	}
	public List<UserAddress> getUserAddresses() {
		return userAddresses;
	}
	public void setUserAddresses(List<UserAddress> userAddresses) {
		this.userAddresses = userAddresses;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getBankAccountNo() {
		return bankAccountNo;
	}
	public void setBankAccountNo(String bankAccountNo) {
		this.bankAccountNo = bankAccountNo;
	}
	public String getBankIfscCode() {
		return bankIfscCode;
	}
	public void setBankIfscCode(String bankIfscCode) {
		this.bankIfscCode = bankIfscCode;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public BigInteger getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(BigInteger createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getCurrentEmployer() {
		return currentEmployer;
	}
	public void setCurrentEmployer(String currentEmployer) {
		this.currentEmployer = currentEmployer;
	}
	public Date getDateofbirth() {
		return dateofbirth;
	}
	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public byte getHniFlag() {
		return hniFlag;
	}
	public void setHniFlag(byte hniFlag) {
		this.hniFlag = hniFlag;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public BigInteger getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(BigInteger modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPreferredLang() {
		return preferredLang;
	}
	public void setPreferredLang(String preferredLang) {
		this.preferredLang = preferredLang;
	}
	public String getRepaymentMode() {
		return repaymentMode;
	}
	public void setRepaymentMode(String repaymentMode) {
		this.repaymentMode = repaymentMode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}