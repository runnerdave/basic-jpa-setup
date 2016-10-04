package net.runnerdave.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "T_PERSON")
@DiscriminatorColumn(name="PERSON_TYPE", discriminatorType = DiscriminatorType.INTEGER)
@Inheritance(strategy = InheritanceType.JOINED)
public class Person implements Auditable {
	
	
	private Long id;
	private String firstName;
	private String lastName;
	private IdCard idCard;
	private Set<Phone> phones = new HashSet<>();
	
	private Date created;
	private Date lastUpdate;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "FIRST_NAME")	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "LAST_NAME")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Transient	
	public IdCard getIdCard() {
		return idCard;
	}

	public void setIdCard(IdCard idCard) {
		this.idCard = idCard;
	}

	@Transient
	public Set<Phone> getPhones() {
		return phones;
	}

	public void setPhones(Set<Phone> phones) {
		this.phones = phones;
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

}
