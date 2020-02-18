package com.xyz.product.prodkart.domainobject;


import com.xyz.product.prodkart.domainvalue.ColorEnum;
import com.xyz.product.prodkart.domainvalue.ProductCategory;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "PRODUCT")
public class ProductDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_ID")
    private Long productId;

    @Column(name = "PRODUCT_NAME", nullable = false)
    @NotNull(message = "Product name cannot be null")
    private String productName;

    @Enumerated(EnumType.STRING)
    @Column(name = "COLOR", nullable = false)
    private ColorEnum color;

    @Enumerated(EnumType.STRING)
    @Column(name = "PRODUCT_CATEGORY", nullable = false)
    private ProductCategory productCategory;

    @Column(name = "SIZE", nullable = false)
    @NotNull(message = "Size cannot be null")
    private String size;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CLIENT_ID")
    private ClientDO client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BRAND_ID")
    private BrandDO brand;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SELLER_ID")
    private SellerDO seller;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SKU_ID")
    private SkuDO sku;

    public ProductDO() {
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

    public ClientDO getClient() {
        return client;
    }

    public void setClient(ClientDO client) {
        this.client = client;
    }

    public BrandDO getBrand() {
        return brand;
    }

    public void setBrand(BrandDO brand) {
        this.brand = brand;
    }

    public SellerDO getSeller() {
        return seller;
    }

    public void setSeller(SellerDO seller) {
        this.seller = seller;
    }

    public SkuDO getSku() {
        return sku;
    }

    public void setSku(SkuDO sku) {
        this.sku = sku;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }
}

