package com.coinflex.api.mortgage.util;

import java.util.Map;
import java.util.LinkedHashMap;

import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;

import com.coinflex.api.mortgage.util.CommonConverter;
import com.coinflex.api.mortgage.vo.MarketVO;
import com.coinflex.api.mortgage.vo.MarketQueryVO;
import com.coinflex.api.mortgage.dto.MarketDTO;
import com.coinflex.api.mortgage.dto.MarketQueryDTO;
import com.coinflex.api.mortgage.domain.MarketDO;

/**
 * market对象转换工具
 *
 * @author 
 */
public class MarketConverter extends CommonConverter {

    //属性名->字段名
    private static final Map<String, String> fieldNameMap = new LinkedHashMap<>();
    static {
        fieldNameMap.put("id", "id");
        fieldNameMap.put("marketId", "market_id");
        fieldNameMap.put("marketCode", "market_code");
        fieldNameMap.put("name", "name");
        fieldNameMap.put("marketType", "market_type");
        fieldNameMap.put("spreadType", "spread_type");
        fieldNameMap.put("baseId", "base_id");
        fieldNameMap.put("baseInst", "base_inst");
        fieldNameMap.put("counterId", "counter_id");
        fieldNameMap.put("counterInst", "counter_inst");
        fieldNameMap.put("collateralType", "collateral_type");
        fieldNameMap.put("cycleType", "cycle_type");
        fieldNameMap.put("marginCurrency", "margin_currency");
        fieldNameMap.put("contractValCurrency", "contract_val_currency");
        fieldNameMap.put("referencePair", "reference_pair");
        fieldNameMap.put("marketGroup", "market_group");
        fieldNameMap.put("linkedMarket", "linked_market");
        fieldNameMap.put("riskOrderbookA", "risk_orderbook_a");
        fieldNameMap.put("riskOrderbookB", "risk_orderbook_b");
        fieldNameMap.put("tickSize", "tick_size");
        fieldNameMap.put("qtyIncrement", "qty_increment");
        fieldNameMap.put("pricingSource", "pricing_source");
        fieldNameMap.put("upperPriceType", "upper_price_type");
        fieldNameMap.put("upperPriceBound", "upper_price_bound");
        fieldNameMap.put("lowerPriceType", "lower_price_type");
        fieldNameMap.put("lowerPriceBound", "lower_price_bound");
        fieldNameMap.put("priceBound", "price_bound");
        fieldNameMap.put("priceBoundType", "price_bound_type");
        fieldNameMap.put("maxLeverage", "max_leverage");
        fieldNameMap.put("status", "status");
        fieldNameMap.put("active", "active");
        fieldNameMap.put("listingDate", "listing_date");
        fieldNameMap.put("daysListing", "days_listing");
        fieldNameMap.put("endDate", "end_date");
        fieldNameMap.put("refInstrumentId", "ref_instrument_id");
        fieldNameMap.put("created", "created");
        fieldNameMap.put("creator", "creator");
        fieldNameMap.put("lastUpdated", "last_updated");
        fieldNameMap.put("lastUpdator", "last_updator");
        fieldNameMap.put("marketPrice", "market_price");
        fieldNameMap.put("tag", "tag");
        fieldNameMap.put("description", "description");
        fieldNameMap.put("delistingDate", "delisting_date");
        fieldNameMap.put("isDelisting", "is_delisting");
        fieldNameMap.put("zone", "zone");
        fieldNameMap.put("feeCode", "fee_code");
        fieldNameMap.put("exclusive", "exclusive");
        fieldNameMap.put("indexPrice", "index_price");
        fieldNameMap.put("makerFee", "maker_fee");
    }

    /**
     * 判断属性名是否存在
     *
     * @param fieldName 属性名
     * @return 是否存在
     */
    public static boolean isFieldExists(String fieldName) {
        return StringUtils.isNotBlank(fieldName) && fieldNameMap.containsKey(fieldName);
    }

    /**
     * 获取排序字段名
     *
     * @param fieldName 排序属性名
     * @return 排序字段名
     */
    public static String getOrderColumn(String fieldName) {
        return isFieldExists(fieldName) ? fieldNameMap.get(fieldName) : null;
    }

    //VO转DTO
    public static MarketQueryDTO voToQueryDTO(MarketQueryVO src) {
        return convert(src, MarketQueryDTO.class);
    }

    //VO转DTO
    public static MarketDTO voToDTO(MarketVO src) {
        return convert(src, MarketDTO.class);
    }

    //DTO转VO
    public static MarketVO dtoToVO(MarketDTO src) {
        return convert(src, MarketVO.class);
    }

    //PageInfo转换
    public static PageInfo<MarketVO> toVOPageInfo(PageInfo<MarketDTO> pageInfo) {
        return convertPageInfo(pageInfo, MarketVO.class);
    }

    //PageInfo转换
    public static PageInfo<MarketDTO> toDTOPageInfo(PageInfo<MarketDO> pageInfo) {
         return convertPageInfo(pageInfo, MarketDTO.class);
    }

    //DTO转DO
    public static MarketDO dtoToDomain(MarketDTO src) {
        return convert(src, MarketDO.class);
    }

    //DO转DTO
    public static MarketDTO domainToDTO(MarketDO src) {
        return convert(src, MarketDTO.class);
    }
}