package com.xyz.product.prodkart.mapper;

import com.xyz.product.prodkart.domainobject.SellerDO;
import com.xyz.product.prodkart.domainvalue.SellerVO;

public class SellerMapper {
    public static SellerVO mapDomainObjectToDomainValue(final SellerDO sellerDO) {
        SellerVO sellerVO = new SellerVO();
        sellerVO.setSellerId(sellerDO.getSellerId());
        sellerVO.setSellerName(sellerDO.getSellerName());
        return sellerVO;
    }

    public static SellerDO mapDomainValueToDomainObject(final SellerVO sellerVO) {
        SellerDO sellerDO = new SellerDO();
        sellerDO.setSellerId(sellerVO.getSellerId());
        sellerDO.setSellerName(sellerVO.getSellerName());
        return sellerDO;
    }
}
