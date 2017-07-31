package com.hcl.loan.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The primary key class for the user_address database table.
 * 
 */
@Embeddable
public class UserAddressPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="USER_ID", insertable=false, updatable=false)
	private String userId;

	@Column(name="ADDRESS_TYPE")
	private String addressType;

	public UserAddressPK() {
	}
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getAddressType() {
		return this.addressType;
	}
	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof UserAddressPK)) {
			return false;
		}
		UserAddressPK castOther = (UserAddressPK)other;
		return 
			this.userId.equals(castOther.userId)
			&& this.addressType.equals(castOther.addressType);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.userId.hashCode();
		hash = hash * prime + this.addressType.hashCode();
		
		return hash;
	}
}