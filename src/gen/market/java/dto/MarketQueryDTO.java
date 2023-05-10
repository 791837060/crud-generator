package com.coinflex.api.mortgage.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import com.coinflex.api.mortgage.dto.MarketDTO;

/**
 * market查询条件
 *
 * @author 
 */
public class MarketQueryDTO extends MarketDTO {
    private static final long serialVersionUID = 1L;

    /**
     * 页码
     */
    private Integer pageNo;

    /**
     * 分页大小
     */
    private Integer pageSize;

    /**
     * 排序属性名称
     */
    private String orderBy;

    /**
     * 排序方向: asc或desc
     */
    private String orderDirection = "desc";

    public Integer getPageNo() {
        return pageNo != null && pageNo > 0 ? pageNo : 1;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize != null && pageSize > 0 ? pageSize : 10;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getOrderDirection() {
        return orderDirection;
    }

    public void setOrderDirection(String orderDirection) {
        this.orderDirection = orderDirection;
    }

















































}