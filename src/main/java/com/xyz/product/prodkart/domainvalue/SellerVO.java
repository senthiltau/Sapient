package com.xyz.product.prodkart.domainvalue;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SellerVO {

    private Long sellerId;

    @ApiModelProperty(value = "Seller name")
    @NotNull(message = "Seller name cannot null")
    private String sellerName;

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SellerVO sellerVO = (SellerVO) o;
        return Objects.equals(sellerId, sellerVO.sellerId) &&
                Objects.equals(sellerName, sellerVO.sellerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sellerId, sellerName);
    }

    @Override
    public String toString() {
        return "SellerVO{" +
                "sellerId=" + sellerId +
                ", sellerName='" + sellerName + '\'' +
                '}';
    }
}
