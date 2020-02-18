package com.xyz.product.prodkart.domainvalue;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SkuVO {

    private Long skkuId;

    @ApiModelProperty(value = "SKU")
    @NotNull(message = "SKU cannot null")
    private String sku;

    public Long getSkuId() {
        return skkuId;
    }

    public void setSkuId(Long skkuId) {
        this.skkuId = skkuId;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SkuVO skuVO = (SkuVO) o;
        return Objects.equals(skkuId, skuVO.skkuId) &&
                Objects.equals(sku, skuVO.sku);
    }

    @Override
    public int hashCode() {
        return Objects.hash(skkuId, sku);
    }

    @Override
    public String toString() {
        return "SkuVO{" +
                "skkuId=" + skkuId +
                ", sku='" + sku + '\'' +
                '}';
    }
}
