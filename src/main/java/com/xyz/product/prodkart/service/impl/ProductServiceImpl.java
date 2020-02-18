package com.xyz.product.prodkart.service.impl;

import com.xyz.product.prodkart.dataaccessobject.ProductRepository;
import com.xyz.product.prodkart.domainobject.ProductDO;
import com.xyz.product.prodkart.domainvalue.GroupBy;
import com.xyz.product.prodkart.domainvalue.ProductCategory;
import com.xyz.product.prodkart.domainvalue.ProductVO;
import com.xyz.product.prodkart.exception.ProductNotFoundException;
import com.xyz.product.prodkart.mapper.ProductMapper;
import com.xyz.product.prodkart.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Map<String, List<ProductVO>> findProducts(String productCategory, String groupBy) {
        List<ProductDO> products = productRepository.findByProductCategory(ProductCategory.valueOf(productCategory));
        if (products != null && products.size() > 0) {
            List<ProductVO> productList = products.stream().map(ProductMapper::mapDomainObjectToDomainValue).collect(Collectors.toList());
            return groupValues(productList, GroupBy.valueOf(groupBy));
        } else {
            LOGGER.error("Unable to find the product for the ctaegory - {}", productCategory);
            throw new ProductNotFoundException("Products could not be found for the category");
        }
    }

    @Override
    public ProductVO createProduct(ProductVO productVO) {
        try {
            return ProductMapper.mapDomainObjectToDomainValue(productRepository.save(ProductMapper.mapDomainObjectToDomainValue(productVO)));
        } catch (Exception e) {
            LOGGER.error("Error saving product details");
            throw e;
        }
    }

    private Map<String, List<ProductVO>> groupValues(final List<ProductVO> products, final GroupBy groupBy) {

        switch (groupBy) {
            case BRAND:
                return products.stream().collect(Collectors.groupingBy(w -> w.getBrand().getBrandName()));
            case CLIENT:
                return products.stream().collect(Collectors.groupingBy(w -> w.getClient().getClientName()));
            case COLOR:
                return products.stream().collect(Collectors.groupingBy(w -> w.getColor().name()));
            case SELLER:
                return products.stream().collect(Collectors.groupingBy(w -> w.getSeller().getSellerName()));
            case SIZE:
                return products.stream().collect(Collectors.groupingBy(w -> w.getSize()));
            case SKU:
                return products.stream().collect(Collectors.groupingBy(w -> w.getSku().getSku()));
            case PRICE:
                return products.stream().collect(Collectors.groupingBy(w -> w.getPrice().toString()));
            default:
                throw new UnsupportedOperationException("Invalid group by.");
        }
    }
}
