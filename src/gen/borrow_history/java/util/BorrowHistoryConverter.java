package com.coinflex.api.mortgage.util;

import java.util.Map;
import java.util.LinkedHashMap;

import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;

import com.coinflex.api.mortgage.util.CommonConverter;
import com.coinflex.api.mortgage.vo.BorrowHistoryVO;
import com.coinflex.api.mortgage.vo.BorrowHistoryQueryVO;
import com.coinflex.api.mortgage.dto.BorrowHistoryDTO;
import com.coinflex.api.mortgage.dto.BorrowHistoryQueryDTO;
import com.coinflex.api.mortgage.domain.BorrowHistoryDO;

/**
 * borrow_history对象转换工具
 *
 * @author 
 */
public class BorrowHistoryConverter extends CommonConverter {

    //属性名->字段名
    private static final Map<String, String> fieldNameMap = new LinkedHashMap<>();
    static {
        fieldNameMap.put("id", "id");
        fieldNameMap.put("accountId", "account_id");
        fieldNameMap.put("collateral", "collateral");
        fieldNameMap.put("quantity", "quantity");
        fieldNameMap.put("amount", "amount");
        fieldNameMap.put("createdAt", "created_at");
        fieldNameMap.put("businessType", "business_type");
        fieldNameMap.put("actionType", "action_type");
        fieldNameMap.put("executionStatus", "execution_status");
        fieldNameMap.put("lastUpdatedAt", "last_updated_at");
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
    public static BorrowHistoryQueryDTO voToQueryDTO(BorrowHistoryQueryVO src) {
        return convert(src, BorrowHistoryQueryDTO.class);
    }

    //VO转DTO
    public static BorrowHistoryDTO voToDTO(BorrowHistoryVO src) {
        return convert(src, BorrowHistoryDTO.class);
    }

    //DTO转VO
    public static BorrowHistoryVO dtoToVO(BorrowHistoryDTO src) {
        return convert(src, BorrowHistoryVO.class);
    }

    //PageInfo转换
    public static PageInfo<BorrowHistoryVO> toVOPageInfo(PageInfo<BorrowHistoryDTO> pageInfo) {
        return convertPageInfo(pageInfo, BorrowHistoryVO.class);
    }

    //PageInfo转换
    public static PageInfo<BorrowHistoryDTO> toDTOPageInfo(PageInfo<BorrowHistoryDO> pageInfo) {
         return convertPageInfo(pageInfo, BorrowHistoryDTO.class);
    }

    //DTO转DO
    public static BorrowHistoryDO dtoToDomain(BorrowHistoryDTO src) {
        return convert(src, BorrowHistoryDO.class);
    }

    //DO转DTO
    public static BorrowHistoryDTO domainToDTO(BorrowHistoryDO src) {
        return convert(src, BorrowHistoryDTO.class);
    }
}