package net.runnerdave.entity;

import java.util.Date;

public class IdCard {
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public Boolean getValid() {
		return valid;
	}
	public void setValid(Boolean valid) {
		this.valid = valid;
	}
	public Date getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(Date date) {
		this.issueDate = date;
	}
	private Long id;
	private String idNumber;
	private Boolean valid = Boolean.TRUE;
	private Date issueDate;
}
