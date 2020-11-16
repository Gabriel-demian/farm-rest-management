package com.proy.rest.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "egg")
public class Egg {
	
	@Id
	@Column(name="egg_id")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
	private Integer eggId;
	
	@Column(name="farm_id")
	private Integer farmId;
	
	@Column(name="birth_date")
	private LocalDateTime birthDate;
	
	@Column(name="expiration_date")
	private LocalDateTime expirationDate;

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

	public LocalDateTime getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDateTime birthDate) {
		this.birthDate = birthDate;
	}

	public LocalDateTime getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(LocalDateTime expirationDate) {
		this.expirationDate = expirationDate;
	}

	
}
