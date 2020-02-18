package com.xyz.product.prodkart.domainvalue;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BrandVO {
    private Long brandId;

    @ApiModelProperty(value = "Brand name")
    @NotNull(message = "Brand name cannot null")
    private String brandName;

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BrandVO brandVO = (BrandVO) o;
        return Objects.equals(brandId, brandVO.brandId) &&
                Objects.equals(brandName, brandVO.brandName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brandId, brandName);
    }

    @Override
    public String toString() {
        return "BrandVO{" +
                "brandId=" + brandId +
                ", brandName='" + brandName + '\'' +
                '}';
    }
}
