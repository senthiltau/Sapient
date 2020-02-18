package com.xyz.product.prodkart.controller;

import com.xyz.product.prodkart.domainvalue.SellerVO;
import com.xyz.product.prodkart.service.impl.SellerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("seller")
public class SellerController {

    @Autowired
    private SellerServiceImpl sellerServiceImpl;

    @PostMapping("/addSeller")
    public void addSeller(@RequestBody final SellerVO seller) {
        sellerServiceImpl.addSeller(seller);
    }

    @DeleteMapping("/deleteSeller")
    public void deleteSeller(@RequestParam final String sellerName) {
        sellerServiceImpl.deleteSeller(sellerName);
    }

    @GetMapping("/getByName")
    public SellerVO getBrands(@RequestParam final String sellerName) {
        return sellerServiceImpl.findSeller(sellerName);
    }
}
