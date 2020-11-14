package com.proy.rest.entity;

import java.math.BigDecimal;

import javax.persistence.Column;

public class References {
	
	@Column(name="egg_Expiration_Date")
	private Integer eggExpirationDate;
	
	@Column(name="chicken_Expiration_Date")
	private Integer chickenExpirationDate;
	
	@Column(name="ch_Sale_Price")
	private BigDecimal chSalePrice;
	
	@Column(name="egg_Sale_Price")
	private BigDecimal eggSalePrice;
	
	
	public Integer getEggExpirationDate() {
		return eggExpirationDate;
	}
	public void setEggExpirationDate(Integer eggExpirationDate) {
		this.eggExpirationDate = eggExpirationDate;
	}
	public Integer getChickenExpirationDate() {
		return chickenExpirationDate;
	}
	public void setChickenExpirationDate(Integer chickenExpirationDate) {
		this.chickenExpirationDate = chickenExpirationDate;
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
