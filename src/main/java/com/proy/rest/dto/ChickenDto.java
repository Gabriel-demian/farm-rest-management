package com.proy.rest.dto;

import java.time.LocalDateTime;

import com.proy.rest.entity.Farm;

public class ChickenDto {
	

	private Integer chickenId;
	
	private Farm farm;
	
	private LocalDateTime birthDate;
	
	private LocalDateTime expirationDate;
	
	

	public ChickenDto() {
		
	}

	public Integer getChickenId() {
		return chickenId;
	}

	public void setChickenId(Integer chickenId) {
		this.chickenId = chickenId;
	}

	public Farm getFarm() {
		return farm;
	}

	public void setFarm(Farm farm) {
		this.farm = farm;
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
