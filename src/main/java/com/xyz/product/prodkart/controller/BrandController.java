package com.xyz.product.prodkart.controller;

import com.xyz.product.prodkart.domainvalue.BrandVO;
import com.xyz.product.prodkart.service.impl.BrandServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("brand")
public class BrandController {

    @Autowired
    private BrandServiceImpl brandServiceImpl;

    @PostMapping("/addBrand")
    public void addBrand(@RequestBody final BrandVO brand) {
        brandServiceImpl.addBrand(brand);
    }

    @DeleteMapping("/deleteBrand")
    public void deleteBrand(@RequestParam final String brandName) {
        brandServiceImpl.deleteBrand(brandName);
    }

    @GetMapping("/getByName")
    public BrandVO getBrands(@RequestParam final String brandName) {
        return brandServiceImpl.findBrand(brandName);
    }
}
