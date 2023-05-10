package com.coinflex.api.mortgage.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * market实体类
 * (该文件自动生成，请勿修改)
 *
 * @author 
 */
public class MarketDO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * market_id
     */
    private Long marketId;

    /**
     * market_code
     */
    private String marketCode;

    /**
     * name
     */
    private String name;

    /**
     * market_type
     */
    private String marketType;

    /**
     * spread_type
     */
    private String spreadType;

    /**
     * base_id
     */
    private Long baseId;

    /**
     * base_inst
     */
    private String baseInst;

    /**
     * counter_id
     */
    private Long counterId;

    /**
     * counter_inst
     */
    private String counterInst;

    /**
     * collateral_type
     */
    private String collateralType;

    /**
     * cycle_type
     */
    private String cycleType;

    /**
     * margin_currency
     */
    private String marginCurrency;

    /**
     * contract_val_currency
     */
    private String contractValCurrency;

    /**
     * reference_pair
     */
    private String referencePair;

    /**
     * market_group
     */
    private String marketGroup;

    /**
     * linked_market
     */
    private String linkedMarket;

    /**
     * risk_orderbook_a
     */
    private String riskOrderbookA;

    /**
     * risk_orderbook_b
     */
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
    private String pricingSource;

    /**
     * upper_price_type
     */
    private String upperPriceType;

    /**
     * upper_price_bound
     */
    private BigDecimal upperPriceBound;

    /**
     * lower_price_type
     */
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
    private String priceBoundType;

    /**
     * max_leverage
     */
    private BigDecimal maxLeverage;

    /**
     * status
     */
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
    private Integer zone;

    /**
     * fee_code
     */
    private String feeCode;

    /**
     * exclusive
     */
    private Boolean exclusive;

    /**
     * index_price
     */
    private BigDecimal indexPrice;

    /**
     * maker_fee
     */
    private Long makerFee;

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