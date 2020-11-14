package com.proy.rest.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "egg")
public class Egg {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer eggId;
	
	private Integer farmId;
	
	private Date birthDate;
	
	private Date expirationDate;

	public Integer getEggId() {
		return eggId;
	}

	public void setEggId(Integer eggId) {
		this.eggId = eggId;
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
