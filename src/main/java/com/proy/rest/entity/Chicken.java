package com.proy.rest.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "chicken")
public class Chicken {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer chickenId;
	
	private Integer farmId;
	
	private Date birthDate;
	
	private Date expirationDate;
	

	public Integer getChickenId() {
		return chickenId;
	}

	public void setChickenId(Integer chickenId) {
		this.chickenId = chickenId;
	}

	public Integer getFarmId() {
		return farmId;
	}

	public void setFarmId(Integer farmId) {
		this.farmId = farmId;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	

}