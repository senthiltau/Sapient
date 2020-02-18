package com.xyz.product.prodkart.service;

import com.xyz.product.prodkart.domainvalue.SellerVO;

public interface SellerService {
    void addSeller(final SellerVO sellerVO);

    void deleteSeller(final String sellerName);

    SellerVO findSeller(String sellerName);
}
