//package com.mika.credit.facade.globalsearch.core.service;
//
//import com.mika.credit.common.entity.BootGrid;
//import com.mika.credit.common.entity.ResponseResult;
//import com.mika.credit.facade.globalsearch.core.model.Cart;
//import com.mika.credit.facade.globalsearch.core.model.CompanyInfo;
//import com.mika.credit.facade.globalsearch.core.model.Customer;
//
//import java.util.List;
//
///**
// * Created by mika on 2016/7/27.
// */
//public interface CartService {
//
//    ResponseResult<Cart> addCart(Cart cart, CompanyInfo companyInfo);
//
//    ResponseResult<Cart> addVisitorCart(Cart cart);
//
//    ResponseResult<Cart> deleteCart(int id);
//
//    ResponseResult<List<Cart>> deleteCartInList(List<Cart> carts, Cart cart);
//
//    ResponseResult<Cart> deleteCarts(List<Integer> ids);
//
//    ResponseResult<List<Cart>> deleteCartsInList(List<Cart> carts, List<Integer> ids);
//
//    ResponseResult<Cart> getCartById(int i);
//
//    //根据用户名查购物车数量
//    int getCartByCustomerId(int i);
//
//    BootGrid<Cart> getCarts(BootGrid<Cart> bootGrid, Cart cart);
//
//	//快速订购 加入购物车
//    ResponseResult<CompanyInfo> addFastCart(CompanyInfo companyInfo, Customer customer);
//
//
//}
