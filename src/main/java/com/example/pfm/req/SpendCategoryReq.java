package com.example.pfm.req;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

public class SpendCategoryReq {
    @ApiModelProperty(hidden = true)
    private Integer id;

    private String name;

    private BigDecimal budget;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", budget=").append(budget);
        sb.append("]");
        return sb.toString();
    }
}