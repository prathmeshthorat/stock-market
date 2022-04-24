package com.estockmarket.stock_market.company;

import com.estockmarket.stock_market.stock_price.StockPrice;
import java.time.OffsetDateTime;
import java.util.Set;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;


@Document
public class Company {

    @Id
    private Long id;

    @Indexed(unique = true)
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

    @DocumentReference(lazy = true, lookup = "{ 'companyToStockPrice' : ?#{#self._id} }")
    @ReadOnlyProperty
    private Set<StockPrice> companyToStockPriceStockPrices;

    @CreatedDate
    private OffsetDateTime dateCreated;

    @LastModifiedDate
    private OffsetDateTime lastUpdated;

    @Version
    private Integer version;

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

    public Set<StockPrice> getCompanyToStockPriceStockPrices() {
        return companyToStockPriceStockPrices;
    }

    public void setCompanyToStockPriceStockPrices(
            final Set<StockPrice> companyToStockPriceStockPrices) {
        this.companyToStockPriceStockPrices = companyToStockPriceStockPrices;
    }

    public OffsetDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(final OffsetDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public OffsetDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(final OffsetDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(final Integer version) {
        this.version = version;
    }

}
