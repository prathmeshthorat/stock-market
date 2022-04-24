package com.estockmarket.stock_market.company;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class CompanyDTO {

    private Long id;

    @NotNull
    @Size(max = 255)
    private String companyCode;

    @NotNull
    @Size(max = 255)
    private String companyName;

    @NotNull
    @Size(max = 255)
    private String companyCEO;

    @NotNull
    @Size(max = 255)
    private String companyTurnover;

    @NotNull
    @Size(max = 255)
    private String companyWebsite;

    @NotNull
    @Size(max = 255)
    private String stockExchange;

    @NotNull
    @Size(max = 255)
    private String createdBy;

    @Size(max = 255)
    private String modifiedBy;

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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(final String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyCEO() {
        return companyCEO;
    }

    public void setCompanyCEO(final String companyCEO) {
        this.companyCEO = companyCEO;
    }

    public String getCompanyTurnover() {
        return companyTurnover;
    }

    public void setCompanyTurnover(final String companyTurnover) {
        this.companyTurnover = companyTurnover;
    }

    public String getCompanyWebsite() {
        return companyWebsite;
    }

    public void setCompanyWebsite(final String companyWebsite) {
        this.companyWebsite = companyWebsite;
    }

    public String getStockExchange() {
        return stockExchange;
    }

    public void setStockExchange(final String stockExchange) {
        this.stockExchange = stockExchange;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(final String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(final String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

}
