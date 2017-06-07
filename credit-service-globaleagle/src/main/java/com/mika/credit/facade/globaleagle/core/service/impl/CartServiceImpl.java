//package com.mika.credit.facade.globaleagle.core.service.impl;
//
//import com.github.pagehelper.PageHelper;
//import com.mika.credit.common.entity.BootGrid;
//import com.mika.credit.common.entity.ResponseResult;
//import com.mika.credit.facade.globaleagle.core.dao.CartMapper;
//import com.mika.credit.facade.globaleagle.core.dao.CompanyInfoMapper;
//import com.mika.credit.facade.globaleagle.core.dao.CountryMapper;
//import com.mika.credit.facade.globaleagle.core.model.Cart;
//import com.mika.credit.facade.globaleagle.core.model.CompanyInfo;
//import com.mika.credit.facade.globaleagle.core.model.Customer;
//import com.mika.credit.facade.globaleagle.core.service.CartService;
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Date;
//import java.util.List;
//
//
//@Service("cartService")
//public class CartServiceImpl implements CartService {
//
//	private static Logger logger = Logger.getLogger(CartServiceImpl.class);
//	@Autowired
//	private CartMapper cartMapper;
//
//	@Autowired
//	private CompanyInfoMapper companyInfoMapper;
//
//	@Autowired
//	private CountryMapper countryMapper;
//
//	/**
//	 * 查询所有购物车信息
//	 * @param bootGrid
//	 * @param cart
//	 * @return
//	 */
//	public BootGrid<Cart> getCarts(BootGrid<Cart> bootGrid, Cart cart) {
//		PageHelper.startPage(bootGrid.getCurrent(), bootGrid.getRowCount());
//		bootGrid.setRows(cartMapper.selectSelective(cart));
//		bootGrid.setTotal(cartMapper.selectCountSelective(cart));
//		bootGrid.setResult(true);
//		return bootGrid;
//	}
//
//	/**
//	 * 通过id查购物车
//	 * @param i
//	 * @return
//	 */
//	public ResponseResult<Cart> getCartById(int i) {
//		ResponseResult<Cart> result = new ResponseResult<>();
//		result.setCode(true);
//		result.setMsg("查询成功");
//		result.setContent(cartMapper.selectByPrimaryKey(i));
//		return result;
//	}
//
//	/**
//	 * 通过客户信息查购物车
//	 * @param i
//	 * @return
//	 */
//	public int getCartByCustomerId(int i) {
//		Cart cart = new Cart();
//		cart.setCustomerId(i);
//		int cartCount = cartMapper.selectCountSelective(cart);
//		return cartCount;
//	}
//
//	/**
//	 * 添加购物车
//	 * @param cart
//	 * @param companyInfo
//	 * @return
//	 */
//	public ResponseResult<Cart> addCart(Cart cart,CompanyInfo companyInfo){
//		boolean r = true;
//		ResponseResult<Cart> result = new ResponseResult<>();
//		//比对是否和上一条cart记录一致
//		Cart c = cartMapper.selectLastRecord();
//		if (c!=null){
//			System.out.print(c.getCompanyInfoId()!=null);
//			//国家，名字，报告等级，是否是订购判断
//			if (cart.getCountryId()==c.getCountryId()&&cart.getCompanyName().equals(c.getCompanyName())&&c.getCompanyInfoId()!=null&&cart.getOrderLevel().equals(c.getOrderLevel())){
//				result.setCode(false);
//				result.setMsg("购物车已存在该订单，请直接下单");
//				return result;
//			}
//		}
//		if(companyInfo!=null){
//			r &= companyInfoMapper.insertSelective(companyInfo)>0;
//			cart.setCompanyInfoId(companyInfo.getId());
//		}
//
//		cart.setCreateDate(new Date());
//		r &= cartMapper.insertSelective(cart)>0;
//
//		if(r){
//			result.setCode(true);
//			result.setMsg("购物车添加成功");
//		}
//		else{
//			result.setCode(false);
//			result.setMsg("购物车添加失败");
//		}
//		return result;
//	}
//
//	/**
//	 * 登陆后把游客模式下的购物车复制到用户下
//	 * @param cart
//	 * @return
//	 */
//	public ResponseResult<Cart> addVisitorCart(Cart cart){
//		boolean r = true;
//		ResponseResult<Cart> result = new ResponseResult<>();
//		cart.setCreateDate(new Date());
//		r &= cartMapper.insertSelective(cart)>0;
//		if(r){
//			result.setCode(true);
//			result.setMsg("购物车添加成功");
//		}
//		else{
//			result.setCode(false);
//			result.setMsg("购物车添加失败");
//		}
//		return result;
//	}
//
//	/**
//	 * 用户模式下删除购物车
//	 * @param id
//	 * @return
//	 */
//	public ResponseResult<Cart> deleteCart(int id){
//		ResponseResult<Cart> result = new ResponseResult<>();
//		if(cartMapper.deleteByPrimaryKey(id)>0){
//			result.setCode(true);
//			result.setMsg("购物车删除成功");
//		}
//		else{
//			result.setCode(false);
//			result.setMsg("购物车删除失败");
//		}
//		return result;
//	}
//
//	/**
//	 * 游客模式下删除购物车
//	 * @param carts
//	 * @param cart
//	 * @return
//	 */
//	public ResponseResult<List<Cart>> deleteCartInList(List<Cart> carts,Cart cart){
//		ResponseResult<List<Cart>> result = new ResponseResult<>();
//		if (carts == null || carts.size() == 0 ) {
//			result.setMsg("数据丢失");
//			result.setCode(false);
//		}
//		else{
//			result.setCode(false);
//			result.setMsg("该记录已经删除!");
//			for (Cart c : carts) {
//				if (c.getId() == cart.getId()) {
//					carts.remove(c);
//					result.setCode(true);
//					result.setMsg("购物车删除成功!");
//					break;
//				}
//			}
//			result.setContent(carts);
//		}
//		return result;
//	}
//
//	/**
//	 * 用户模式下批量删除购物车
//	 * @param ids
//	 * @return
//	 */
//	public ResponseResult<Cart> deleteCarts(List<Integer> ids){
//		ResponseResult<Cart> result = new ResponseResult<>();
//		boolean flag = true;
//		for(int id : ids){
//			flag &= cartMapper.deleteByPrimaryKey(id)>0;
//		}
//		if(flag){
//			result.setCode(true);
//			result.setMsg("购物车删除成功");
//		}
//		else{
//			result.setCode(false);
//			result.setMsg("购物车删除失败");
//		}
//		return result;
//	}
//
//	/**
//	 * 游客模式下批量删除购物车
//	 * @param carts
//	 * @param ids
//	 * @return
//	 */
//	public ResponseResult<List<Cart>> deleteCartsInList(List<Cart> carts,List<Integer> ids){
//		ResponseResult<List<Cart>> result = new ResponseResult<>();
//		if (carts == null || carts.size() == 0 ) {
//			result.setMsg("数据丢失");
//			result.setCode(false);
//		}
//		else{
//			result.setCode(false);
//			result.setMsg("该记录已经删除!");
//			for (int id : ids) {
//				for (Cart c : carts) {
//					if (c.getId() == id) {
//						carts.remove(c);
//						result.setCode(true);
//						result.setMsg("购物车删除成功!");
//						break;
//					}
//				}
//			}
//			result.setContent(carts);
//		}
//		return result;
//	}
//
//	/**
//	 * 快速订购订单加入购物车
//	 * @param companyInfo
//	 * @param customer
//	 * @return
//	 */
//	@Override
//    public ResponseResult<CompanyInfo> addFastCart(CompanyInfo companyInfo,Customer customer) {
//		ResponseResult<CompanyInfo> result = new ResponseResult<>();
//        boolean flag = true;
//        flag &= companyInfoMapper.insertSelective(companyInfo)>0;
//        if(flag){
//            result.setCode(true);
//            result.setContent(companyInfo);
//            result.setMsg("信息添加成功");
//        }else{
//            result.setCode(false);
//            result.setMsg("信息添加失败");
//        }
//        return result;
//	}
//}
