package com.coinflex.api.mortgage.vo;

import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import com.coinflex.api.mortgage.validator.InsertGroup;
import com.coinflex.api.mortgage.validator.UpdateGroup;

/**
 * marketVO对象
 *
 * @author 
 */
@ApiModel(value = "marketVO对象", description = "marketVO对象")
public class MarketVO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ApiModelProperty(value = "id", dataType = "Long", required = true, example = "1")
    @NotNull(message = "id(id)为空", groups = {UpdateGroup.class})
    private Long id;

    /**
     * market_id
     */
    @ApiModelProperty(value = "market_id", dataType = "Long", required = true, example = "1")
    @NotNull(message = "market_id(marketId)为空", groups = {InsertGroup.class})
    private Long marketId;

    /**
     * market_code
     */
    @ApiModelProperty(value = "market_code", dataType = "String", required = true)
    @NotBlank(message = "market_code(marketCode)为空", groups = {InsertGroup.class})
    @Length(max = 32, message = "market_code(marketCode)长度不能超过{max}个字符", groups = {Default.class})
    private String marketCode;

    /**
     * name
     */
    @ApiModelProperty(value = "name", dataType = "String", required = true)
    @NotBlank(message = "name(name)为空", groups = {InsertGroup.class})
    @Length(max = 60, message = "name(name)长度不能超过{max}个字符", groups = {Default.class})
    private String name;

    /**
     * market_type
     */
    @ApiModelProperty(value = "market_type", dataType = "String", required = true)
    @NotBlank(message = "market_type(marketType)为空", groups = {InsertGroup.class})
    @Length(max = 12, message = "market_type(marketType)长度不能超过{max}个字符", groups = {Default.class})
    private String marketType;

    /**
     * spread_type
     */
    @ApiModelProperty(value = "spread_type", dataType = "String")
    @Length(max = 12, message = "spread_type(spreadType)长度不能超过{max}个字符", groups = {Default.class})
    private String spreadType;

    /**
     * base_id
     */
    @ApiModelProperty(value = "base_id", dataType = "Long", example = "1")
    private Long baseId;

    /**
     * base_inst
     */
    @ApiModelProperty(value = "base_inst", dataType = "String", required = true)
    @NotBlank(message = "base_inst(baseInst)为空", groups = {InsertGroup.class})
    @Length(max = 32, message = "base_inst(baseInst)长度不能超过{max}个字符", groups = {Default.class})
    private String baseInst;

    /**
     * counter_id
     */
    @ApiModelProperty(value = "counter_id", dataType = "Long", example = "1")
    private Long counterId;

    /**
     * counter_inst
     */
    @ApiModelProperty(value = "counter_inst", dataType = "String", required = true)
    @NotBlank(message = "counter_inst(counterInst)为空", groups = {InsertGroup.class})
    @Length(max = 32, message = "counter_inst(counterInst)长度不能超过{max}个字符", groups = {Default.class})
    private String counterInst;

    /**
     * collateral_type
     */
    @ApiModelProperty(value = "collateral_type", dataType = "String")
    @Length(max = 12, message = "collateral_type(collateralType)长度不能超过{max}个字符", groups = {Default.class})
    private String collateralType;

    /**
     * cycle_type
     */
    @ApiModelProperty(value = "cycle_type", dataType = "String")
    @Length(max = 12, message = "cycle_type(cycleType)长度不能超过{max}个字符", groups = {Default.class})
    private String cycleType;

    /**
     * margin_currency
     */
    @ApiModelProperty(value = "margin_currency", dataType = "String")
    @Length(max = 12, message = "margin_currency(marginCurrency)长度不能超过{max}个字符", groups = {Default.class})
    private String marginCurrency;

    /**
     * contract_val_currency
     */
    @ApiModelProperty(value = "contract_val_currency", dataType = "String")
    @Length(max = 12, message = "contract_val_currency(contractValCurrency)长度不能超过{max}个字符", groups = {Default.class})
    private String contractValCurrency;

    /**
     * reference_pair
     */
    @ApiModelProperty(value = "reference_pair", dataType = "String")
    @Length(max = 32, message = "reference_pair(referencePair)长度不能超过{max}个字符", groups = {Default.class})
    private String referencePair;

    /**
     * market_group
     */
    @ApiModelProperty(value = "market_group", dataType = "String")
    @Length(max = 12, message = "market_group(marketGroup)长度不能超过{max}个字符", groups = {Default.class})
    private String marketGroup;

    /**
     * linked_market
     */
    @ApiModelProperty(value = "linked_market", dataType = "String")
    @Length(max = 32, message = "linked_market(linkedMarket)长度不能超过{max}个字符", groups = {Default.class})
    private String linkedMarket;

    /**
     * risk_orderbook_a
     */
    @ApiModelProperty(value = "risk_orderbook_a", dataType = "String")
    @Length(max = 32, message = "risk_orderbook_a(riskOrderbookA)长度不能超过{max}个字符", groups = {Default.class})
    private String riskOrderbookA;

    /**
     * risk_orderbook_b
     */
    @ApiModelProperty(value = "risk_orderbook_b", dataType = "String")
    @Length(max = 32, message = "risk_orderbook_b(riskOrderbookB)长度不能超过{max}个字符", groups = {Default.class})
    private String riskOrderbookB;

    /**
     * tick_size
     */
    @ApiModelProperty(value = "tick_size", dataType = "BigDecimal")
    private BigDecimal tickSize;

    /**
     * qty_increment
     */
    @ApiModelProperty(value = "qty_increment", dataType = "BigDecimal")
    private BigDecimal qtyIncrement;

    /**
     * pricing_source
     */
    @ApiModelProperty(value = "pricing_source", dataType = "String")
    @Length(max = 128, message = "pricing_source(pricingSource)长度不能超过{max}个字符", groups = {Default.class})
    private String pricingSource;

    /**
     * upper_price_type
     */
    @ApiModelProperty(value = "upper_price_type", dataType = "String")
    @Length(max = 12, message = "upper_price_type(upperPriceType)长度不能超过{max}个字符", groups = {Default.class})
    private String upperPriceType;

    /**
     * upper_price_bound
     */
    @ApiModelProperty(value = "upper_price_bound", dataType = "BigDecimal")
    private BigDecimal upperPriceBound;

    /**
     * lower_price_type
     */
    @ApiModelProperty(value = "lower_price_type", dataType = "String")
    @Length(max = 12, message = "lower_price_type(lowerPriceType)长度不能超过{max}个字符", groups = {Default.class})
    private String lowerPriceType;

    /**
     * lower_price_bound
     */
    @ApiModelProperty(value = "lower_price_bound", dataType = "BigDecimal")
    private BigDecimal lowerPriceBound;

    /**
     * price_bound
     */
    @ApiModelProperty(value = "price_bound", dataType = "BigDecimal")
    private BigDecimal priceBound;

    /**
     * price_bound_type
     */
    @ApiModelProperty(value = "price_bound_type", dataType = "String")
    @Length(max = 12, message = "price_bound_type(priceBoundType)长度不能超过{max}个字符", groups = {Default.class})
    private String priceBoundType;

    /**
     * max_leverage
     */
    @ApiModelProperty(value = "max_leverage", dataType = "BigDecimal")
    private BigDecimal maxLeverage;

    /**
     * status
     */
    @ApiModelProperty(value = "status", dataType = "String")
    @Length(max = 12, message = "status(status)长度不能超过{max}个字符", groups = {Default.class})
    private String status;

    /**
     * active
     */
    @ApiModelProperty(value = "active", dataType = "Boolean")
    private Boolean active;

    /**
     * listing_date
     */
    @ApiModelProperty(value = "listing_date", dataType = "Date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date listingDate;

    /**
     * days_listing
     */
    @ApiModelProperty(value = "days_listing", dataType = "Integer")
    private Integer daysListing;

    /**
     * end_date
     */
    @ApiModelProperty(value = "end_date", dataType = "Date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endDate;

    /**
     * ref_instrument_id
     */
    @ApiModelProperty(value = "ref_instrument_id", dataType = "Long", example = "1")
    private Long refInstrumentId;

    /**
     * created
     */
    @ApiModelProperty(value = "created", dataType = "Date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date created;

    /**
     * creator
     */
    @ApiModelProperty(value = "creator", dataType = "Long", example = "1")
    private Long creator;

    /**
     * last_updated
     */
    @ApiModelProperty(value = "last_updated", dataType = "Date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastUpdated;

    /**
     * last_updator
     */
    @ApiModelProperty(value = "last_updator", dataType = "Long", example = "1")
    private Long lastUpdator;

    /**
     * market_price
     */
    @ApiModelProperty(value = "market_price", dataType = "BigDecimal")
    private BigDecimal marketPrice;

    /**
     * tag
     */
    @ApiModelProperty(value = "tag", dataType = "String")
    private String tag;

    /**
     * description
     */
    @ApiModelProperty(value = "description", dataType = "String")
    @Length(max = 60, message = "description(description)长度不能超过{max}个字符", groups = {Default.class})
    private String description;

    /**
     * delisting_date
     */
    @ApiModelProperty(value = "delisting_date", dataType = "Date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date delistingDate;

    /**
     * is_delisting
     */
    @ApiModelProperty(value = "is_delisting", dataType = "Boolean")
    private Boolean isDelisting;

    /**
     * zone
     */
    @ApiModelProperty(value = "zone", dataType = "Integer", required = true, example = "1")
    @NotNull(message = "zone(zone)为空", groups = {InsertGroup.class})
    private Integer zone;

    /**
     * fee_code
     */
    @ApiModelProperty(value = "fee_code", dataType = "String")
    @Length(max = 64, message = "fee_code(feeCode)长度不能超过{max}个字符", groups = {Default.class})
    private String feeCode;

    /**
     * exclusive
     */
    @ApiModelProperty(value = "exclusive", dataType = "Boolean", required = true)
    @NotNull(message = "exclusive(exclusive)为空", groups = {InsertGroup.class})
    private Boolean exclusive;

    /**
     * index_price
     */
    @ApiModelProperty(value = "index_price", dataType = "BigDecimal")
    private BigDecimal indexPrice;

    /**
     * maker_fee
     */
    @ApiModelProperty(value = "maker_fee", dataType = "Long", example = "1")
    private Long makerFee;


    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMarketId() {
        return this.marketId;
    }

    public void setMarketId(Long marketId) {
        this.marketId = marketId;
    }

    public String getMarketCode() {
        return this.marketCode;
    }

    public void setMarketCode(String marketCode) {
        this.marketCode = marketCode;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMarketType() {
        return this.marketType;
    }

    public void setMarketType(String marketType) {
        this.marketType = marketType;
    }

    public String getSpreadType() {
        return this.spreadType;
    }

    public void setSpreadType(String spreadType) {
        this.spreadType = spreadType;
    }

    public Long getBaseId() {
        return this.baseId;
    }

    public void setBaseId(Long baseId) {
        this.baseId = baseId;
    }

    public String getBaseInst() {
        return this.baseInst;
    }

    public void setBaseInst(String baseInst) {
        this.baseInst = baseInst;
    }

    public Long getCounterId() {
        return this.counterId;
    }

    public void setCounterId(Long counterId) {
        this.counterId = counterId;
    }

    public String getCounterInst() {
        return this.counterInst;
    }

    public void setCounterInst(String counterInst) {
        this.counterInst = counterInst;
    }

    public String getCollateralType() {
        return this.collateralType;
    }

    public void setCollateralType(String collateralType) {
        this.collateralType = collateralType;
    }

    public String getCycleType() {
        return this.cycleType;
    }

    public void setCycleType(String cycleType) {
        this.cycleType = cycleType;
    }

    public String getMarginCurrency() {
        return this.marginCurrency;
    }

    public void setMarginCurrency(String marginCurrency) {
        this.marginCurrency = marginCurrency;
    }

    public String getContractValCurrency() {
        return this.contractValCurrency;
    }

    public void setContractValCurrency(String contractValCurrency) {
        this.contractValCurrency = contractValCurrency;
    }

    public String getReferencePair() {
        return this.referencePair;
    }

    public void setReferencePair(String referencePair) {
        this.referencePair = referencePair;
    }

    public String getMarketGroup() {
        return this.marketGroup;
    }

    public void setMarketGroup(String marketGroup) {
        this.marketGroup = marketGroup;
    }

    public String getLinkedMarket() {
        return this.linkedMarket;
    }

    public void setLinkedMarket(String linkedMarket) {
        this.linkedMarket = linkedMarket;
    }

    public String getRiskOrderbookA() {
        return this.riskOrderbookA;
    }

    public void setRiskOrderbookA(String riskOrderbookA) {
        this.riskOrderbookA = riskOrderbookA;
    }

    public String getRiskOrderbookB() {
        return this.riskOrderbookB;
    }

    public void setRiskOrderbookB(String riskOrderbookB) {
        this.riskOrderbookB = riskOrderbookB;
    }

    public BigDecimal getTickSize() {
        return this.tickSize;
    }

    public void setTickSize(BigDecimal tickSize) {
        this.tickSize = tickSize;
    }

    public BigDecimal getQtyIncrement() {
        return this.qtyIncrement;
    }

    public void setQtyIncrement(BigDecimal qtyIncrement) {
        this.qtyIncrement = qtyIncrement;
    }

    public String getPricingSource() {
        return this.pricingSource;
    }

    public void setPricingSource(String pricingSource) {
        this.pricingSource = pricingSource;
    }

    public String getUpperPriceType() {
        return this.upperPriceType;
    }

    public void setUpperPriceType(String upperPriceType) {
        this.upperPriceType = upperPriceType;
    }

    public BigDecimal getUpperPriceBound() {
        return this.upperPriceBound;
    }

    public void setUpperPriceBound(BigDecimal upperPriceBound) {
        this.upperPriceBound = upperPriceBound;
    }

    public String getLowerPriceType() {
        return this.lowerPriceType;
    }

    public void setLowerPriceType(String lowerPriceType) {
        this.lowerPriceType = lowerPriceType;
    }

    public BigDecimal getLowerPriceBound() {
        return this.lowerPriceBound;
    }

    public void setLowerPriceBound(BigDecimal lowerPriceBound) {
        this.lowerPriceBound = lowerPriceBound;
    }

    public BigDecimal getPriceBound() {
        return this.priceBound;
    }

    public void setPriceBound(BigDecimal priceBound) {
        this.priceBound = priceBound;
    }

    public String getPriceBoundType() {
        return this.priceBoundType;
    }

    public void setPriceBoundType(String priceBoundType) {
        this.priceBoundType = priceBoundType;
    }

    public BigDecimal getMaxLeverage() {
        return this.maxLeverage;
    }

    public void setMaxLeverage(BigDecimal maxLeverage) {
        this.maxLeverage = maxLeverage;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Date getListingDate() {
        return this.listingDate;
    }

    public void setListingDate(Date listingDate) {
        this.listingDate = listingDate;
    }

    public Integer getDaysListing() {
        return this.daysListing;
    }

    public void setDaysListing(Integer daysListing) {
        this.daysListing = daysListing;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Long getRefInstrumentId() {
        return this.refInstrumentId;
    }

    public void setRefInstrumentId(Long refInstrumentId) {
        this.refInstrumentId = refInstrumentId;
    }

    public Date getCreated() {
        return this.created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Long getCreator() {
        return this.creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public Date getLastUpdated() {
        return this.lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Long getLastUpdator() {
        return this.lastUpdator;
    }

    public void setLastUpdator(Long lastUpdator) {
        this.lastUpdator = lastUpdator;
    }

    public BigDecimal getMarketPrice() {
        return this.marketPrice;
    }

    public void setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
    }

    public String getTag() {
        return this.tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDelistingDate() {
        return this.delistingDate;
    }

    public void setDelistingDate(Date delistingDate) {
        this.delistingDate = delistingDate;
    }

    public Boolean getIsDelisting() {
        return this.isDelisting;
    }

    public void setIsDelisting(Boolean isDelisting) {
        this.isDelisting = isDelisting;
    }

    public Integer getZone() {
        return this.zone;
    }

    public void setZone(Integer zone) {
        this.zone = zone;
    }

    public String getFeeCode() {
        return this.feeCode;
    }

    public void setFeeCode(String feeCode) {
        this.feeCode = feeCode;
    }

    public Boolean getExclusive() {
        return this.exclusive;
    }

    public void setExclusive(Boolean exclusive) {
        this.exclusive = exclusive;
    }

    public BigDecimal getIndexPrice() {
        return this.indexPrice;
    }

    public void setIndexPrice(BigDecimal indexPrice) {
        this.indexPrice = indexPrice;
    }

    public Long getMakerFee() {
        return this.makerFee;
    }

    public void setMakerFee(Long makerFee) {
        this.makerFee = makerFee;
    }

}