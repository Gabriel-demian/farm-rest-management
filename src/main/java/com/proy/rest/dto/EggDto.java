package com.proy.rest.dto;

import java.time.LocalDateTime;

public class EggDto {
	
	private Integer id;
	
	private FarmDto farm;
	
	private LocalDateTime birthDate;
	
	private LocalDateTime expirationDate;

	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public FarmDto getFarm() {
		return farm;
	}

	public void setFarm(FarmDto farm) {
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
