package com.proy.rest.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "farm")
public class Farm {
	
	@Id
	@Column(name="farm_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer farmId;
	
	@Column(name="farm_Name")
	@NotNull(message="Farm Name can't be null")
	private String farmName;
	
	@Column(name="chicken_Bought")
	private Integer chickenBought;
	
	@Column(name="chicken_Sold")
	private Integer chickenSold;
	
	@Column(name="egg_Bought")
	private Integer eggBought;
	
	@Column(name="egg_Sold")
	private Integer eggSold;

	@Column(name="income")
	private BigDecimal income;
	
	@Column(name="expenses")
	private BigDecimal expenses;
	
	
	public Farm() {
		
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
