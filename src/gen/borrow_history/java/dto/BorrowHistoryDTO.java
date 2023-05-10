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
 * borrow_historyDTO对象
 *
 * @author 
 */
public class BorrowHistoryDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @NotBlank(message = "id(id)为空")
    @Length(max = 40, message = "id(id)长度不能超过{max}个字符")
    private String id;

    /**
     * account_id
     */
    @NotNull(message = "account_id(accountId)为空")
    private Long accountId;

    /**
     * collateral
     */
    @NotBlank(message = "collateral(collateral)为空")
    @Length(max = 40, message = "collateral(collateral)长度不能超过{max}个字符")
    private String collateral;

    /**
     * quantity
     */
    private BigDecimal quantity;

    /**
     * amount
     */
    private BigDecimal amount;

    /**
     * created_at
     */
    @NotNull(message = "created_at(createdAt)为空")
    private Date createdAt;

    /**
     * business_type
     */
    @NotBlank(message = "business_type(businessType)为空")
    @Length(max = 40, message = "business_type(businessType)长度不能超过{max}个字符")
    private String businessType;

    /**
     * action_type
     */
    @NotBlank(message = "action_type(actionType)为空")
    @Length(max = 40, message = "action_type(actionType)长度不能超过{max}个字符")
    private String actionType;

    /**
     * execution_status
     */
    @Length(max = 40, message = "execution_status(executionStatus)长度不能超过{max}个字符")
    private String executionStatus;

    /**
     * last_updated_at
     */
    @NotNull(message = "last_updated_at(lastUpdatedAt)为空")
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