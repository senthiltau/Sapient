package com.xyz.product.prodkart.mapper;

import com.xyz.product.prodkart.domainobject.BrandDO;
import com.xyz.product.prodkart.domainvalue.BrandVO;

public class BrandMapper {

    public static BrandVO mapDomainObjectToDomainValue(final BrandDO brandDO) {
        BrandVO brandVO = new BrandVO();
        brandVO.setBrandId(brandDO.getBrandId());
        brandVO.setBrandName(brandDO.getBrandName());
        return brandVO;
    }

    public static BrandDO mapDomainValueToDomainObject(final BrandVO brandVO) {
        BrandDO brandDO = new BrandDO();
        brandDO.setBrandId(brandVO.getBrandId());
        brandDO.setBrandName(brandVO.getBrandName());
        return brandDO;
    }
}
