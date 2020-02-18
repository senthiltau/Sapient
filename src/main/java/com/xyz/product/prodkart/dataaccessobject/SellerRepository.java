package com.xyz.product.prodkart.dataaccessobject;

import com.xyz.product.prodkart.domainobject.SellerDO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface SellerRepository extends CrudRepository<SellerDO, Long> {
    @Query("SELECT distinct seller from SellerDO seller where seller.sellerName = :sellerName")
    SellerDO findByName(@Param(("sellerName")) final String sellerName);
}
