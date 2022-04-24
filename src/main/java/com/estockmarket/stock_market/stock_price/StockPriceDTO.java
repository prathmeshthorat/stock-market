package com.estockmarket.stock_market.stock_price;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class StockPriceDTO {

    private Long id;

    @NotNull
    @Size(max = 255)
    private String companyCode;

    @NotNull
    private Double price;

    @Size(max = 255)
    private String createdBy;

    private Long companyToStockPrice;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(final String companyCode) {
        this.companyCode = companyCode;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(final Double price) {
        this.price = price;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(final String createdBy) {
        this.createdBy = createdBy;
    }

    public Long getCompanyToStockPrice() {
        return companyToStockPrice;
    }

    public void setCompanyToStockPrice(final Long companyToStockPrice) {
        this.companyToStockPrice = companyToStockPrice;
    }

}
