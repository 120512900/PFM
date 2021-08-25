package com.example.pfm.entity;

import java.math.BigDecimal;
import java.util.Date;

public class SpendRecord {
    private Integer id;

    private BigDecimal amount;

    private Integer spendCategoryId;

    private String description;

    private Integer accountId;

    private Date date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getSpendCategoryId() {
        return spendCategoryId;
    }

    public void setSpendCategoryId(Integer spendCategoryId) {
        this.spendCategoryId = spendCategoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", amount=").append(amount);
        sb.append(", spendCategoryId=").append(spendCategoryId);
        sb.append(", description=").append(description);
        sb.append(", accountId=").append(accountId);
        sb.append(", date=").append(date);
        sb.append("]");
        return sb.toString();
    }
}