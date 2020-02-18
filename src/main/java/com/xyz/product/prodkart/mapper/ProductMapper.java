package com.xyz.product.prodkart.mapper;

import com.xyz.product.prodkart.domainobject.ProductDO;
import com.xyz.product.prodkart.domainvalue.ProductVO;

public class ProductMapper {

    public static ProductVO mapDomainObjectToDomainValue(final ProductDO productDO) {
        ProductVO productVO = new ProductVO();
        productVO.setBrand(BrandMapper.mapDomainObjectToDomainValue(productDO.getBrand()));
        productVO.setClient(ClientMapper.mapDomainObjectToDomainValue(productDO.getClient()));
        productVO.setSeller(SellerMapper.mapDomainObjectToDomainValue(productDO.getSeller()));
        productVO.setSku(SKUMapper.mapDomainObjectToDomainValue(productDO.getSku()));
        return productVO;
    }

    public static ProductDO mapDomainObjectToDomainValue(final ProductVO productVo) {
        ProductDO productDO = new ProductDO();
        productDO.setBrand(BrandMapper.mapDomainValueToDomainObject(productVo.getBrand()));
        productDO.setClient(ClientMapper.mapDomainValueToDomainObject(productVo.getClient()));
        productDO.setSeller(SellerMapper.mapDomainValueToDomainObject(productVo.getSeller()));
        productDO.setSku(SKUMapper.mapDomainValueToDomainObject(productVo.getSku()));
        return productDO;
    }
}
