package com.xyz.product.prodkart.service.impl;

import com.xyz.product.prodkart.dataaccessobject.ProductRepository;
import com.xyz.product.prodkart.domainobject.BrandDO;
import com.xyz.product.prodkart.domainobject.ClientDO;
import com.xyz.product.prodkart.domainobject.ProductDO;
import com.xyz.product.prodkart.domainobject.SellerDO;
import com.xyz.product.prodkart.domainobject.SkuDO;
import com.xyz.product.prodkart.domainvalue.BrandVO;
import com.xyz.product.prodkart.domainvalue.ColorEnum;
import com.xyz.product.prodkart.domainvalue.GroupBy;
import com.xyz.product.prodkart.domainvalue.ProductCategory;
import com.xyz.product.prodkart.domainvalue.ProductVO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ProductServiceImplTest {

    @Mock
    private ProductRepository repository;

    @InjectMocks
    private ProductServiceImpl service;


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findProducts() {
        ClientDO clientDO = mock(ClientDO.class);
        SellerDO sellerDO = mock(SellerDO.class);
        SkuDO skuDO = mock(SkuDO.class);
        ProductDO productDO = mock(ProductDO.class);
        BrandDO brandDO = mock(BrandDO.class);
        when(brandDO.getBrandName()).thenReturn("John Player");
        when(productDO.getProductName()).thenReturn("Sleeveless Tshirt - Cotton");
        when(productDO.getColor()).thenReturn(ColorEnum.BLACK);
        when(productDO.getProductCategory()).thenReturn(ProductCategory.TSHIRTS);
        when(productDO.getBrand()).thenReturn(brandDO);

        ProductDO productDO1 = mock(ProductDO.class);
        BrandDO brandDO1 = mock(BrandDO.class);
        when(brandDO1.getBrandName()).thenReturn("John Player");
        when(productDO1.getProductName()).thenReturn("Sleeveless Tshirt - Cotton");
        when(productDO1.getColor()).thenReturn(ColorEnum.GREEN);
        when(productDO1.getProductCategory()).thenReturn(ProductCategory.TSHIRTS);
        when(productDO1.getBrand()).thenReturn(brandDO1);

        ProductDO productDO2 = mock(ProductDO.class);
        BrandDO brandDO2 = mock(BrandDO.class);
        when(brandDO2.getBrandName()).thenReturn("Adidas");
        when(productDO2.getProductName()).thenReturn("Tshirt printed");
        when(productDO2.getColor()).thenReturn(ColorEnum.BLACK);
        when(productDO2.getProductCategory()).thenReturn(ProductCategory.TSHIRTS);
        when(productDO2.getBrand()).thenReturn(brandDO2);

        when(productDO.getClient()).thenReturn(clientDO);
        when(productDO.getSeller()).thenReturn(sellerDO);
        when(productDO.getSku()).thenReturn(skuDO);
        when(productDO1.getClient()).thenReturn(clientDO);
        when(productDO1.getSeller()).thenReturn(sellerDO);
        when(productDO1.getSku()).thenReturn(skuDO);
        when(productDO2.getClient()).thenReturn(clientDO);
        when(productDO2.getSeller()).thenReturn(sellerDO);
        when(productDO2.getSku()).thenReturn(skuDO);

        when(repository.findByProductCategory(any(ProductCategory.class))).thenReturn(Arrays.asList(productDO, productDO1, productDO2));

        Map<String, List<ProductVO>> actual = service.findProducts(ProductCategory.TSHIRTS.name(), GroupBy.BRAND.name());
        assertNotNull(actual);
        assertEquals(2, actual.get("John Player").size());
        assertEquals(1, actual.get("Adidas").size());

    }

    @Test
    public void createProduct() {
    }
}