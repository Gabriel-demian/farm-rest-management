package com.proy.rest.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "farm")
public class Farm {
	
	@Id
	@Column(name="farm_id")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
	private Integer farmId;
	
	@Column(name="farm_name")
	@NotNull(message="Farm Name can't be null")
	private String farmName;
	
	@OneToMany(mappedBy= "farm")
	private List<Chicken> chickens;
	
	@Column(name="chicken_bought")
	private Integer chickenBought;
	
	@Column(name="chicken_sold")
	private Integer chickenSold;
	
	@Column(name="egg_bought")
	private Integer eggBought;
	
	@Column(name="egg_sold")
	private Integer eggSold;

	@Column(name="income")
	private BigDecimal income;
	
	@Column(name="expenses")
	private BigDecimal expenses;
	
	
	public Farm() {
		
	}
	
	public List<Chicken> getChickens() {
		return chickens;
	}

	public void setChickens(List<Chicken> chickens) {
		this.chickens = chickens;
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
