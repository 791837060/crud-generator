package com.coinflex.api.mortgage.dto;

import java.io.Serializable;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import java.math.BigDecimal;
import java.util.Date;

/**
 * marketDTO对象
 *
 * @author 
 */
public class MarketDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @NotNull(message = "id(id)为空")
    private Long id;

    /**
     * market_id
     */
    @NotNull(message = "market_id(marketId)为空")
    private Long marketId;

    /**
     * market_code
     */
    @NotBlank(message = "market_code(marketCode)为空")
    @Length(max = 32, message = "market_code(marketCode)长度不能超过{max}个字符")
    private String marketCode;

    /**
     * name
     */
    @NotBlank(message = "name(name)为空")
    @Length(max = 60, message = "name(name)长度不能超过{max}个字符")
    private String name;

    /**
     * market_type
     */
    @NotBlank(message = "market_type(marketType)为空")
    @Length(max = 12, message = "market_type(marketType)长度不能超过{max}个字符")
    private String marketType;

    /**
     * spread_type
     */
    @Length(max = 12, message = "spread_type(spreadType)长度不能超过{max}个字符")
    private String spreadType;

    /**
     * base_id
     */
    private Long baseId;

    /**
     * base_inst
     */
    @NotBlank(message = "base_inst(baseInst)为空")
    @Length(max = 32, message = "base_inst(baseInst)长度不能超过{max}个字符")
    private String baseInst;

    /**
     * counter_id
     */
    private Long counterId;

    /**
     * counter_inst
     */
    @NotBlank(message = "counter_inst(counterInst)为空")
    @Length(max = 32, message = "counter_inst(counterInst)长度不能超过{max}个字符")
    private String counterInst;

    /**
     * collateral_type
     */
    @Length(max = 12, message = "collateral_type(collateralType)长度不能超过{max}个字符")
    private String collateralType;

    /**
     * cycle_type
     */
    @Length(max = 12, message = "cycle_type(cycleType)长度不能超过{max}个字符")
    private String cycleType;

    /**
     * margin_currency
     */
    @Length(max = 12, message = "margin_currency(marginCurrency)长度不能超过{max}个字符")
    private String marginCurrency;

    /**
     * contract_val_currency
     */
    @Length(max = 12, message = "contract_val_currency(contractValCurrency)长度不能超过{max}个字符")
    private String contractValCurrency;

    /**
     * reference_pair
     */
    @Length(max = 32, message = "reference_pair(referencePair)长度不能超过{max}个字符")
    private String referencePair;

    /**
     * market_group
     */
    @Length(max = 12, message = "market_group(marketGroup)长度不能超过{max}个字符")
    private String marketGroup;

    /**
     * linked_market
     */
    @Length(max = 32, message = "linked_market(linkedMarket)长度不能超过{max}个字符")
    private String linkedMarket;

    /**
     * risk_orderbook_a
     */
    @Length(max = 32, message = "risk_orderbook_a(riskOrderbookA)长度不能超过{max}个字符")
    private String riskOrderbookA;

    /**
     * risk_orderbook_b
     */
    @Length(max = 32, message = "risk_orderbook_b(riskOrderbookB)长度不能超过{max}个字符")
    private String riskOrderbookB;

    /**
     * tick_size
     */
    private BigDecimal tickSize;

    /**
     * qty_increment
     */
    private BigDecimal qtyIncrement;

    /**
     * pricing_source
     */
    @Length(max = 128, message = "pricing_source(pricingSource)长度不能超过{max}个字符")
    private String pricingSource;

    /**
     * upper_price_type
     */
    @Length(max = 12, message = "upper_price_type(upperPriceType)长度不能超过{max}个字符")
    private String upperPriceType;

    /**
     * upper_price_bound
     */
    private BigDecimal upperPriceBound;

    /**
     * lower_price_type
     */
    @Length(max = 12, message = "lower_price_type(lowerPriceType)长度不能超过{max}个字符")
    private String lowerPriceType;

    /**
     * lower_price_bound
     */
    private BigDecimal lowerPriceBound;

    /**
     * price_bound
     */
    private BigDecimal priceBound;

    /**
     * price_bound_type
     */
    @Length(max = 12, message = "price_bound_type(priceBoundType)长度不能超过{max}个字符")
    private String priceBoundType;

    /**
     * max_leverage
     */
    private BigDecimal maxLeverage;

    /**
     * status
     */
    @Length(max = 12, message = "status(status)长度不能超过{max}个字符")
    private String status;

    /**
     * active
     */
    private Boolean active;

    /**
     * listing_date
     */
    private Date listingDate;

    /**
     * days_listing
     */
    private Integer daysListing;

    /**
     * end_date
     */
    private Date endDate;

    /**
     * ref_instrument_id
     */
    private Long refInstrumentId;

    /**
     * created
     */
    private Date created;

    /**
     * creator
     */
    private Long creator;

    /**
     * last_updated
     */
    private Date lastUpdated;

    /**
     * last_updator
     */
    private Long lastUpdator;

    /**
     * market_price
     */
    private BigDecimal marketPrice;

    /**
     * tag
     */
    private String tag;

    /**
     * description
     */
    @Length(max = 60, message = "description(description)长度不能超过{max}个字符")
    private String description;

    /**
     * delisting_date
     */
    private Date delistingDate;

    /**
     * is_delisting
     */
    private Boolean isDelisting;

    /**
     * zone
     */
    @NotNull(message = "zone(zone)为空")
    private Integer zone;

    /**
     * fee_code
     */
    @Length(max = 64, message = "fee_code(feeCode)长度不能超过{max}个字符")
    private String feeCode;

    /**
     * exclusive
     */
    @NotNull(message = "exclusive(exclusive)为空")
    private Boolean exclusive;

    /**
     * index_price
     */
    private BigDecimal indexPrice;

    /**
     * maker_fee
     */
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