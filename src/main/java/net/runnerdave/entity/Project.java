package net.runnerdave.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "T_PROJECT")
public class Project implements Auditable {

	private Long id;
	private String title;
	private Set<Geek> geeks = new HashSet<Geek>();
	private Date created;
	private Date lastUpdate;
	private Period period;
	private ProjectType projectType;

	@Enumerated(EnumType.ORDINAL)
	public ProjectType getProjectType() {
		return projectType;
	}

	public void setProjectType(ProjectType projectType) {
		this.projectType = projectType;
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	
	public enum ProjectType {
		FIXED, TIME_AND_MATERIAL
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@ManyToMany(mappedBy = "projects")
	public Set<Geek> getGeeks() {
		return geeks;
	}

	public void setGeeks(Set<Geek> geeks) {
		this.geeks = geeks;
	}

	@Override
	public Date getCreated() {
		return this.created;
	}

	@Override
	public void setCreated(Date created) {
		this.created = created;

	}

	@Override
	public Date getLastUpdate() {
		return this.lastUpdate;
	}

	@Override
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;

	}

	@Embedded
	public Period getPeriod() {
		return period;
	}

	public void setPeriod(Period period) {
		this.period = period;
	}

}
