package com.xyz.product.prodkart.service;

import com.xyz.product.prodkart.domainvalue.ProductVO;

import java.util.List;
import java.util.Map;

public interface ProductService {

    Map<String, List<ProductVO>> findProducts(final String productCategory, final String groupBy);

    ProductVO createProduct(ProductVO productVO);
}
