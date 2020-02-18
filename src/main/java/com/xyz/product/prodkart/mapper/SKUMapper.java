package com.xyz.product.prodkart.mapper;

import com.xyz.product.prodkart.domainobject.SkuDO;
import com.xyz.product.prodkart.domainvalue.SkuVO;

public class SKUMapper {

    public static SkuVO mapDomainObjectToDomainValue(final SkuDO skuDO) {
        SkuVO skuVO = new SkuVO();
        skuVO.setSkuId(skuDO.getSkuId());
        skuVO.setSku(skuDO.getSku());
        return skuVO;
    }

    public static SkuDO mapDomainValueToDomainObject(final SkuVO skuVO) {
        SkuDO skuDO = new SkuDO();
        skuDO.setSkuId(skuVO.getSkuId());
        skuDO.setSku(skuVO.getSku());
        return skuDO;
    }
}
