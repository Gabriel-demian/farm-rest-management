package com.proy.rest.entity;

import java.math.BigDecimal;

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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer farmId;
	
	
	@NotNull(message="Farm Name can't be null")
	private String farmName;
	
	private Integer chickenBought;
	private Integer chickenSold;
	private Integer eggBought;
	private Integer eggSold;

	private BigDecimal income;
	private BigDecimal expenses;
	
	private BigDecimal chSalePrice;
	private BigDecimal eggSalePrice;
	
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

	public BigDecimal getChSalePrice() {
		return chSalePrice;
	}

	public void setChSalePrice(BigDecimal chSalePrice) {
		this.chSalePrice = chSalePrice;
	}

	public BigDecimal getEggSalePrice() {
		return eggSalePrice;
	}

	public void setEggSalePrice(BigDecimal eggSalePrice) {
		this.eggSalePrice = eggSalePrice;
	}
	
	

	
	
	
}
