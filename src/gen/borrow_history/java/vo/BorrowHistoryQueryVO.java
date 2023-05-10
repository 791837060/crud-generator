package com.coinflex.api.mortgage.vo;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.groups.Default;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.coinflex.api.mortgage.vo.BorrowHistoryVO;

/**
 * borrow_history查询条件
 *
 * @author 
 */
@ApiModel(value = "borrow_history查询条件", description = "borrow_history查询条件")
public class BorrowHistoryQueryVO extends BorrowHistoryVO {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "页码", dataType = "Integer", example = "1")
    @NotNull(message = "页码为空", groups = {Default.class})
    @Min(value = 1, message = "页码必须大于或等于{value}", groups = {Default.class})
    @Max(value = 2147483646, message = "页码不能大于{value}", groups = {Default.class})
    private Integer pageNo = 1;

    @ApiModelProperty(value = "分页大小", dataType = "Integer", example = "10")
    @NotNull(message = "分页大小为空", groups = {Default.class})
    @Min(value = 1, message = "分页大小必须大于或等于{value}", groups = {Default.class})
    @Max(value = 2147483646, message = "分页大小不能大于{value}", groups = {Default.class})
    private Integer pageSize = 10;

    @ApiModelProperty(value = "排序字段名", dataType = "String")
    @Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9_]*$", message = "排序字段名无效", groups = {Default.class})
    private String orderBy;

    @ApiModelProperty(value = "排序方向: asc或desc", dataType = "String", example = "desc")
    @Pattern(regexp = "(?i)asc|desc", message = "排序方向必须是asc或desc", groups = {Default.class})
    private String orderDirection = "desc";

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
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