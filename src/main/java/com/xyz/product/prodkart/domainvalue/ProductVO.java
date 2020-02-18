package com.xyz.product.prodkart.domainvalue;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductVO {

    private Long productId;

    @ApiModelProperty(value = "Product Name")
    @NotBlank(message = "Product Name cannot be null")
    private String productName;

    @ApiModelProperty(value = "Color of the product")
    @NotNull(message = "Color cannot be null")
    private ColorEnum color;

    @ApiModelProperty(value = "Product size")
    @NotNull(message = "Product size cannot be null")
    private String size;

    @ApiModelProperty(value = "Client of the product")
    @NotNull(message = "Client cannot be null")
    private ClientVO client;

    @ApiModelProperty(value = "Seller of the product")
    @NotNull(message = "Seller cannot be null")
    private SellerVO seller;

    @ApiModelProperty(value = "SKU of the product")
    @NotNull(message = "SKU cannot by null")
    private SkuVO sku;

    @ApiModelProperty(value = "Brand of the product")
    @NotNull(message = "Brand cannot be null")
    private BrandVO brand;

    @ApiModelProperty(value = "Price of the product")
    @NotNull(message = "Price of the product cannot be null")
    private BigInteger price;

    @ApiModelProperty(value = "Product category")
    @NotNull(message = "Product category cannot be null")
    private ProductCategory productCategory;

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public BigInteger getPrice() {
        return price;
    }

    public void setPrice(BigInteger price) {
        this.price = price;
    }

    public BrandVO getBrand() {
        return brand;
    }

    public void setBrand(BrandVO brand) {
        this.brand = brand;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public ColorEnum getColor() {
        return color;
    }

    public void setColor(ColorEnum color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public ClientVO getClient() {
        return client;
    }

    public void setClient(ClientVO client) {
        this.client = client;
    }

    public SellerVO getSeller() {
        return seller;
    }

    public void setSeller(SellerVO seller) {
        this.seller = seller;
    }

    public SkuVO getSku() {
        return sku;
    }

    public void setSku(SkuVO sku) {
        this.sku = sku;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductVO productVO = (ProductVO) o;
        return Objects.equals(productId, productVO.productId) &&
                Objects.equals(productName, productVO.productName) &&
                color == productVO.color &&
                Objects.equals(size, productVO.size) &&
                Objects.equals(client, productVO.client) &&
                Objects.equals(seller, productVO.seller) &&
                Objects.equals(sku, productVO.sku) &&
                Objects.equals(brand, productVO.brand) &&
                Objects.equals(price, productVO.price) &&
                productCategory == productVO.productCategory;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productName, color, size, client, seller, sku, brand, price, productCategory);
    }

    @Override
    public String toString() {
        return "ProductVO{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", color=" + color +
                ", size='" + size + '\'' +
                ", client=" + client +
                ", seller=" + seller +
                ", sku=" + sku +
                ", brand=" + brand +
                ", price=" + price +
                ", productCategory=" + productCategory +
                '}';
    }
}
