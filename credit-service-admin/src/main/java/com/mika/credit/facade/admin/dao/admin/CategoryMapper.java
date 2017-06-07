package com.mika.credit.facade.admin.dao.admin;

import com.mika.credit.facade.admin.model.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by credit on 2017/3/15.
 */
@Repository
public interface CategoryMapper {
    Category queryById(String id);
    List<Category> queryAll();
    List<Category> querySelective(Category category);
    int save(Category category);
    int update(Category category);
    int updateByIdSelective(Category category);
    int deleteById(String id);
    int delete(Category category);
    int selectCountBySystem(String id);
}
