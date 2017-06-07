package com.mika.credit.facade.order.dao;

import com.mika.credit.common.entity.order.ProductModule;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by credit on 2017/3/2.
 */
@Repository
public interface ProductModuleMapper extends BaseMapper<ProductModule> {
    List<ProductModule> selectByProductId(Integer id);
    int queryCountList(ProductModule productBlock);
    int delete(Integer id);
    int deleteByProductId(Integer productId);

}
