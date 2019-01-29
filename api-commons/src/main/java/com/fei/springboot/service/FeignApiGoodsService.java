package com.fei.springboot.service;

import com.fei.springboot.annotation.IgnoreAuth;
import com.fei.springboot.annotation.LoginUser;
import com.fei.springboot.domain.UserVo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value = "API-PROVIDER")
public interface FeignApiGoodsService {
    @PostMapping(value = "/api/goods/index")
    public Object index();

    /**
     * 获取商品规格信息，用于购物车编辑时选择规格
     */
    @PostMapping(value = "/api/goods/sku")
    public Object sku(@RequestParam("id") Integer id);

    /**
     * 商品详情页数据
     */
    @PostMapping(value = "/api/goods/detail")
    public Object detail(@RequestParam("id") Integer id,@RequestParam("referrer") Long referrer);

    /**
     * 　获取分类下的商品
     */
    @PostMapping(value = "/api/goods/category")
    public Object category(@RequestParam("id") Integer id, @RequestParam("isShow") Integer isShow);

    /**
     * 　　获取商品列表
     */
    @PostMapping(value = "/api/goods/list")
    public Object list(@RequestBody UserVo loginUser, @RequestParam("categoryId")Integer categoryId,
                       @RequestParam("brandId")Integer brandId, @RequestParam("keyword")String keyword, @RequestParam("isNew")Integer isNew, @RequestParam("isHot")Integer isHot,
                       @RequestParam("page") Integer page, @RequestParam("size") Integer size,
                       @RequestParam("sort")String sort, @RequestParam("order")String order);

    /**
     * 　　商品列表筛选的分类列表
     */
    @PostMapping(value = "/api/goods/filter")
    public Object filter(@RequestParam("categoryId") Integer categoryId,
                         @RequestParam("keyword") String keyword, @RequestParam("isNew") Integer isNew, @RequestParam("isHot") Integer isHot);

    /**
     * 　　新品首发
     */
    @PostMapping(value = "/api/goods/new")
    public Object newAction();

    /**
     * 　　人气推荐
     */
    @PostMapping(value = "/api/goods/hot")
    public Object hot();

    /**
     * 　　商品详情页的大家都在看的商品
     */
    @PostMapping(value = "/api/goods/related")
    public Object related(@RequestParam("id") Integer id);

    /**
     * 　　在售的商品总数
     */
    @PostMapping(value = "/api/goods/count")
    public Object count();

    /**
     * 　　获取商品列表
     */
    @PostMapping(value = "/api/goods/productlist")
    public Object productlist(@RequestParam("categoryId") Integer categoryId,
                              @RequestParam("isNew") Integer isNew, @RequestParam("discount") Integer discount,
                              @RequestParam("page") Integer page, @RequestParam("size") Integer size,
                              @RequestParam("sort")String sort, @RequestParam("order") String order);
}
