package net.runnerdave.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "T_GEEK")
public class Geek extends Person {

	private String favouriteProgrammingLanguage;
	private Set<Project> projects = new HashSet<Project>();

	@Column(name = "FAV_PROG_LANG")
	public String getFavouriteProgrammingLanguage() {
		return favouriteProgrammingLanguage;
	}

	public void setFavouriteProgrammingLanguage(String favouriteProgrammingLanguage) {
		this.favouriteProgrammingLanguage = favouriteProgrammingLanguage;
	}

	@Transient
	public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

}
