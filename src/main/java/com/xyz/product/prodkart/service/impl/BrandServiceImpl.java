package com.xyz.product.prodkart.service.impl;

import com.xyz.product.prodkart.dataaccessobject.BrandRepository;
import com.xyz.product.prodkart.dataaccessobject.ProductRepository;
import com.xyz.product.prodkart.domainobject.BrandDO;
import com.xyz.product.prodkart.domainobject.ProductDO;
import com.xyz.product.prodkart.domainvalue.BrandVO;
import com.xyz.product.prodkart.mapper.BrandMapper;
import com.xyz.product.prodkart.service.BrandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    private static final Logger LOGGER = LoggerFactory.getLogger(BrandServiceImpl.class);

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private ProductRepository productRepository;

    public void addBrand(final BrandVO brandVO) {
        try {
            brandRepository.save(BrandMapper.mapDomainValueToDomainObject(brandVO));
        } catch (Exception e) {
            LOGGER.error("Unable to add a brand", e);
        }
    }

    public void deleteBrand(final String brandName) {
        BrandDO brandDO = brandRepository.findByName(brandName);
        try {
            brandRepository.delete(brandDO);
        } catch (Exception e) {
            LOGGER.error("Unable to delete the brand", e);
        }
        deleteProductByBrand(brandDO);
    }

    private void deleteProductByBrand(BrandDO brandDO) {
        List<ProductDO> products = productRepository.findByBrand(brandDO);
        productRepository.deleteAll(products);
    }

    public BrandVO findBrand(String brandName) {
        try {
            return BrandMapper.mapDomainObjectToDomainValue(brandRepository.findByName(brandName));
        } catch (Exception e) {
            LOGGER.error("Brand could not be found");
            throw e;
        }
    }
}
