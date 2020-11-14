package com.proy.rest.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "reference")
public class Reference {
	
	@Column(name="egg_expiration_date")
	private Integer eggExpirationDate;
	
	@Column(name="chicken_expiration_date")
	private Integer chickenExpirationDate;
	
	@Column(name="ch_sale_price")
	private BigDecimal chSalePrice;
	
	@Column(name="egg_sale_price")
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
