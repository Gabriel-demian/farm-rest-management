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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer farm_id;
	
	
	@NotNull(message="Farm Name can't be null")
	private String farm_name;
	
	@Column
	private Integer chicken_bought;
	@Column
	private Integer chicken_sold;
	@Column
	private Integer egg_bought;
	@Column
	private Integer egg_sold;

	@Column
	private BigDecimal income;
	@Column
	private BigDecimal expenses;
	
	@Column
	private BigDecimal ch_purchase_Price;
	@Column
	private BigDecimal ch_sale_Price;
	@Column
	private BigDecimal egg_purchase_Price;
	@Column
	private BigDecimal egg_sale_Price;
	
	public Farm() {
		
	}
	
	public Integer getFarm_id() {
		return farm_id;
	}
	public void setFarm_id(Integer farm_id) {
		this.farm_id = farm_id;
	}
	public String getFarm_name() {
		return farm_name;
	}
	public void setFarm_name(String farm_name) {
		this.farm_name = farm_name;
	}

	public Integer getChicken_bought() {
		return chicken_bought;
	}

	public void setChicken_bought(Integer chicken_bought) {
		this.chicken_bought = chicken_bought;
	}

	public Integer getChicken_sold() {
		return chicken_sold;
	}

	public void setChicken_sold(Integer chicken_sold) {
		this.chicken_sold = chicken_sold;
	}

	public Integer getEgg_bought() {
		return egg_bought;
	}

	public void setEgg_bought(Integer egg_bought) {
		this.egg_bought = egg_bought;
	}

	public Integer getEgg_sold() {
		return egg_sold;
	}

	public void setEgg_sold(Integer egg_sold) {
		this.egg_sold = egg_sold;
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

	public BigDecimal getCh_purchase_Price() {
		return ch_purchase_Price;
	}

	public void setCh_purchase_Price(BigDecimal ch_purchase_Price) {
		this.ch_purchase_Price = ch_purchase_Price;
	}

	public BigDecimal getCh_sale_Price() {
		return ch_sale_Price;
	}

	public void setCh_sale_Price(BigDecimal ch_sale_Price) {
		this.ch_sale_Price = ch_sale_Price;
	}

	public BigDecimal getEgg_purchase_Price() {
		return egg_purchase_Price;
	}

	public void setEgg_purchase_Price(BigDecimal egg_purchase_Price) {
		this.egg_purchase_Price = egg_purchase_Price;
	}

	public BigDecimal getEgg_sale_Price() {
		return egg_sale_Price;
	}

	public void setEgg_sale_Price(BigDecimal egg_sale_Price) {
		this.egg_sale_Price = egg_sale_Price;
	}
	

	
	
	
}
