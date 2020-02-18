package com.xyz.product.prodkart.service;

import com.xyz.product.prodkart.domainvalue.BrandVO;

public interface BrandService {
    void addBrand(final BrandVO brandVO);

    void deleteBrand(final String brandName);

    BrandVO findBrand(String brandName);
}
