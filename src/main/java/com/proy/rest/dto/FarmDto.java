package com.proy.rest.dto;

import java.math.BigDecimal;


public class FarmDto {
	
	private Integer farmId;
	
	private String farmName;
	
	private Integer chickenBought;
	
	private Integer chickenSold;
	
	private Integer eggBought;
	
	private Integer eggSold;

	private BigDecimal income;
	
	private BigDecimal expenses;
	
	
	public FarmDto() {
		
	}

	public Integer getFarmId() {
		return farmId;
	}

	public void setFarmId(Integer farmId) {
		this.farmId = farmId;
	}

	public String getFarmName() {
		return farmName;
	}

	public void setFarmName(String farmName) {
		this.farmName = farmName;
	}

	public Integer getChickenBought() {
		return chickenBought;
	}

	public void setChickenBought(Integer chickenBought) {
		this.chickenBought = chickenBought;
	}

	public Integer getChickenSold() {
		return chickenSold;
	}

	public void setChickenSold(Integer chickenSold) {
		this.chickenSold = chickenSold;
	}

	public Integer getEggBought() {
		return eggBought;
	}

	public void setEggBought(Integer eggBought) {
		this.eggBought = eggBought;
	}

	public Integer getEggSold() {
		return eggSold;
	}

	public void setEggSold(Integer eggSold) {
		this.eggSold = eggSold;
	}

	public BigDecimal getIncome() {
		return income;
	}

	public void setIncome(BigDecimal income) {
		this.income = income;
	}

	public BigDecimal getExpenses() {
		return expenses;
	}

	public void setExpenses(BigDecimal expenses) {
		this.expenses = expenses;
	}
	
}
