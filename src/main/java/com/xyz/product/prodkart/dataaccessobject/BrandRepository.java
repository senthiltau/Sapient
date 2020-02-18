package com.xyz.product.prodkart.dataaccessobject;

import com.xyz.product.prodkart.domainobject.BrandDO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface BrandRepository extends CrudRepository<BrandDO, Long> {

    @Query("SELECT distinct brand from BrandDO brand where brand.brandName = :brandName")
    BrandDO findByName(@Param("brandName") final String brandName);
}
