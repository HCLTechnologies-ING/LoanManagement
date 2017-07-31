package com.hcl.loan.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * The persistent class for the email_notification database table.
 * 
 */
@Entity
@Table(name = "email_notification")
@NamedQuery(name = "EmailNotification.findAll", query = "SELECT e FROM EmailNotification e")
public class EmailNotification implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "MESSAGE_ID")
	private String messageId;

	@Column(name = "MESSAGE_BODY")
	private String messageBody;

	@Column(name = "MESSAGE_SENT_DATE")
	private Timestamp messageSentDate;

	private String remarks;

	@Column(name = "SENT_STATUS")
	private String sentStatus;

	@Column(name = "SOURCE_ID")
	private BigInteger sourceId;

	@Column(name = "TO_MAIL_ID")
	private String toMailId;

	public EmailNotification() {
	}

	public String getMessageId() {
		return this.messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getMessageBody() {
		return this.messageBody;
	}

	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}

	public Timestamp getMessageSentDate() {
		return this.messageSentDate;
	}

	public void setMessageSentDate(Timestamp messageSentDate) {
		this.messageSentDate = messageSentDate;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getSentStatus() {
		return this.sentStatus;
	}

	public void setSentStatus(String sentStatus) {
		this.sentStatus = sentStatus;
	}

	public BigInteger getSourceId() {
		return this.sourceId;
	}

	public void setSourceId(BigInteger sourceId) {
		this.sourceId = sourceId;
	}

	public String getToMailId() {
		return this.toMailId;
	}

	public void setToMailId(String toMailId) {
		this.toMailId = toMailId;
	}

}