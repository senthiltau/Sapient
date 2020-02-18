package com.xyz.product.prodkart.service.impl;

import com.xyz.product.prodkart.dataaccessobject.ProductRepository;
import com.xyz.product.prodkart.dataaccessobject.SellerRepository;
import com.xyz.product.prodkart.domainobject.ProductDO;
import com.xyz.product.prodkart.domainobject.SellerDO;
import com.xyz.product.prodkart.domainvalue.SellerVO;
import com.xyz.product.prodkart.mapper.SellerMapper;
import com.xyz.product.prodkart.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    @Autowired
    private ProductRepository productRepository;

    public void addSeller(final SellerVO sellerVO) {
        sellerRepository.save(SellerMapper.mapDomainValueToDomainObject(sellerVO));
    }

    public void deleteSeller(final String sellerName) {
        SellerDO sellerDO = sellerRepository.findByName(sellerName);
        sellerRepository.delete(sellerDO);
        deleteProductBySeller(sellerDO);
    }

    private void deleteProductBySeller(SellerDO sellerDO) {
        List<ProductDO> products = productRepository.findBySeller(sellerDO);
        productRepository.deleteAll(products);
    }

    @Override
    public SellerVO findSeller(String sellerName) {
        return SellerMapper.mapDomainObjectToDomainValue(sellerRepository.findByName(sellerName));
    }
}
