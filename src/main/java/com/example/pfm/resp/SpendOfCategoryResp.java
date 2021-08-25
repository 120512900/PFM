package com.example.pfm.resp;

import java.math.BigDecimal;

public class SpendOfCategoryResp {


    private BigDecimal total;

    private Integer incomeCategoryId;


    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Integer getIncomeCategoryId() {
        return incomeCategoryId;
    }

    public void setIncomeCategoryId(Integer incomeCategoryId) {
        this.incomeCategoryId = incomeCategoryId;
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());


        sb.append(", incomeCategoryId=").append(incomeCategoryId);

        sb.append("]");
        return sb.toString();
    }
}