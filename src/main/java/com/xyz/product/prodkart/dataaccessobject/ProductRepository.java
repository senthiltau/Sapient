package com.xyz.product.prodkart.dataaccessobject;

import com.xyz.product.prodkart.domainobject.BrandDO;
import com.xyz.product.prodkart.domainobject.ProductDO;
import com.xyz.product.prodkart.domainobject.SellerDO;
import com.xyz.product.prodkart.domainvalue.ColorEnum;
import com.xyz.product.prodkart.domainvalue.ProductCategory;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<ProductDO, Long> {

    List<ProductDO> findByColor(ColorEnum colorEnum);

    List<ProductDO> findByProductCategory(ProductCategory productCategory);

    List<ProductDO> findByBrand(BrandDO productCategory);

    List<ProductDO> findBySeller(SellerDO productCategory);


}
