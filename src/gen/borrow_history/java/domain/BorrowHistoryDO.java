package com.coinflex.api.mortgage.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * borrow_history实体类
 * (该文件自动生成，请勿修改)
 *
 * @author 
 */
public class BorrowHistoryDO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private String id;

    /**
     * account_id
     */
    private Long accountId;

    /**
     * collateral
     */
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
    private Date createdAt;

    /**
     * business_type
     */
    private String businessType;

    /**
     * action_type
     */
    private String actionType;

    /**
     * execution_status
     */
    private String executionStatus;

    /**
     * last_updated_at
     */
    private Date lastUpdatedAt;

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