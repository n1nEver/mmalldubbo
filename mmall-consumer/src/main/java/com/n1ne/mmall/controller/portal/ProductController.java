package com.n1ne.mmall.controller.portal;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.n1ne.mmall.common.ServerResponse;
import com.n1ne.mmall.service.IProductService;
import com.n1ne.mmall.vo.ProductDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/product/")
public class ProductController {

    @Reference
    private IProductService iProductService;



    @RequestMapping("detail.do")
    public ServerResponse<ProductDetailVo> detail(Integer productId){
        return iProductService.getProductDetail(productId);
    }

    @RequestMapping("list.do")
    public ServerResponse<PageInfo> list(@RequestParam(value = "keyword",required = false)String keyword,
                                         @RequestParam(value = "categoryId",required = false)Integer categoryId,
                                         @RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                         @RequestParam(value = "pageSize",defaultValue = "10") int pageSize,
                                         @RequestParam(value = "orderBy",defaultValue = "") String orderBy){
        return iProductService.getProductByKeywordCategory(keyword,categoryId,pageNum,pageSize,orderBy);
    }





}
