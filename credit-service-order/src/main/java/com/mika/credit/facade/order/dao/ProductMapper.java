package com.mika.credit.facade.order.dao;

import com.mika.credit.common.entity.order.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by credit on 2017/3/2.
 */
@Repository
public interface ProductMapper extends BaseMapper<Product>{
    int queryCountList(Product product);


}
