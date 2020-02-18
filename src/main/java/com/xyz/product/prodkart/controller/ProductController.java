package com.xyz.product.prodkart.controller;

import com.xyz.product.prodkart.domainvalue.ProductVO;
import com.xyz.product.prodkart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/group-by")
    public Map<String, List<ProductVO>> getProducts(@RequestParam final String productCategory,
                                                    @RequestParam final String groupBy) {
        return productService.findProducts(productCategory, groupBy);
    }

    @PostMapping("/addProduct")
    public void addProduct(@RequestBody final ProductVO productVO) {
        productService.createProduct(productVO);
    }
}
