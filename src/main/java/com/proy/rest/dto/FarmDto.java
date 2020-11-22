package com.proy.rest.dto;

import java.math.BigDecimal;
import java.util.List;


public class FarmDto {
	
	private Integer id;
	
	private String farmName;
	
	private Integer chickenBought;
	
	private Integer chickenSold;
	
	private Integer eggBought;
	
	private Integer eggSold;

	private BigDecimal income;
	
	private BigDecimal expenses;
	
	private List<EggDto> eggs;
	
	private List<ChickenDto> chickens;
	
	
	public FarmDto() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public List<EggDto> getEggs() {
		return eggs;
	}

	public void setEggs(List<EggDto> eggs) {
		this.eggs = eggs;
	}

	public List<ChickenDto> getChickens() {
		return chickens;
	}

	public void setChickens(List<ChickenDto> chickens) {
		this.chickens = chickens;
	}
	
	
	
}
