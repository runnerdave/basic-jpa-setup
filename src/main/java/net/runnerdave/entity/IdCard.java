package net.runnerdave.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "T_ID_CARD")
public class IdCard {

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "ID_NUMBER")
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

	@Column(name = "ISSUE_DATE")
	@Temporal(TemporalType.TIMESTAMP)
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
