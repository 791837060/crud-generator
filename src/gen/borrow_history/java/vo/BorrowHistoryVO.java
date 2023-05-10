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
 * borrow_historyVO对象
 *
 * @author 
 */
@ApiModel(value = "borrow_historyVO对象", description = "borrow_historyVO对象")
public class BorrowHistoryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ApiModelProperty(value = "id", dataType = "String", required = true)
    @NotBlank(message = "id(id)为空", groups = {UpdateGroup.class})
    @Length(max = 40, message = "id(id)长度不能超过{max}个字符", groups = {Default.class})
    private String id;

    /**
     * account_id
     */
    @ApiModelProperty(value = "account_id", dataType = "Long", required = true, example = "1")
    @NotNull(message = "account_id(accountId)为空", groups = {InsertGroup.class})
    private Long accountId;

    /**
     * collateral
     */
    @ApiModelProperty(value = "collateral", dataType = "String", required = true)
    @NotBlank(message = "collateral(collateral)为空", groups = {InsertGroup.class})
    @Length(max = 40, message = "collateral(collateral)长度不能超过{max}个字符", groups = {Default.class})
    private String collateral;

    /**
     * quantity
     */
    @ApiModelProperty(value = "quantity", dataType = "BigDecimal")
    private BigDecimal quantity;

    /**
     * amount
     */
    @ApiModelProperty(value = "amount", dataType = "BigDecimal")
    private BigDecimal amount;

    /**
     * created_at
     */
    @ApiModelProperty(value = "created_at", dataType = "Date", required = true)
    @NotNull(message = "created_at(createdAt)为空", groups = {InsertGroup.class})
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdAt;

    /**
     * business_type
     */
    @ApiModelProperty(value = "business_type", dataType = "String", required = true)
    @NotBlank(message = "business_type(businessType)为空", groups = {InsertGroup.class})
    @Length(max = 40, message = "business_type(businessType)长度不能超过{max}个字符", groups = {Default.class})
    private String businessType;

    /**
     * action_type
     */
    @ApiModelProperty(value = "action_type", dataType = "String", required = true)
    @NotBlank(message = "action_type(actionType)为空", groups = {InsertGroup.class})
    @Length(max = 40, message = "action_type(actionType)长度不能超过{max}个字符", groups = {Default.class})
    private String actionType;

    /**
     * execution_status
     */
    @ApiModelProperty(value = "execution_status", dataType = "String")
    @Length(max = 40, message = "execution_status(executionStatus)长度不能超过{max}个字符", groups = {Default.class})
    private String executionStatus;

    /**
     * last_updated_at
     */
    @ApiModelProperty(value = "last_updated_at", dataType = "Date", required = true)
    @NotNull(message = "last_updated_at(lastUpdatedAt)为空", groups = {InsertGroup.class})
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastUpdatedAt;


    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getAccountId() {
        return this.accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getCollateral() {
        return this.collateral;
    }

    public void setCollateral(String collateral) {
        this.collateral = collateral;
    }

    public BigDecimal getQuantity() {
        return this.quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getAmount() {
        return this.amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getBusinessType() {
        return this.businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getActionType() {
        return this.actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public String getExecutionStatus() {
        return this.executionStatus;
    }

    public void setExecutionStatus(String executionStatus) {
        this.executionStatus = executionStatus;
    }

    public Date getLastUpdatedAt() {
        return this.lastUpdatedAt;
    }

    public void setLastUpdatedAt(Date lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
    }

}