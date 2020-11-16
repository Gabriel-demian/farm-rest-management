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
@Table(name = "chicken")
public class Chicken {
	
	@Id
	@Column(name="chicken_id")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
	private Integer chickenId;
	
	@Column(name="farm_id")
	private Integer farmId;
	
	@Column(name="birth_date")
	private LocalDateTime birthDate;
	
	@Column(name="expiration_date")
	private LocalDateTime expirationDate;
	

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
