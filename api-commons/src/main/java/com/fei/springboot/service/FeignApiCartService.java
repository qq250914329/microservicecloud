package com.fei.springboot.service;

import com.fei.springboot.annotation.LoginUser;
import com.fei.springboot.config.FeignConfiguration;
import com.fei.springboot.domain.UserVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient(value = "API-PROVIDER",  configuration = FeignConfiguration.class)
public interface FeignApiCartService {
    /**
     * 获取购物车中的数据
     */
    @PostMapping("/api/cart/getCart")
    public Object getCart(@RequestBody UserVo loginUser);

    /**
     * 获取购物车信息，所有对购物车的增删改操作，都要重新返回购物车的信息
     */
    @PostMapping("/api/cart/index")
    public Object index(@RequestBody  UserVo loginUser);
    /**
     * 添加商品到购物车
     */
    @RequestMapping(value = "/api/cart/add", method = RequestMethod.POST ,consumes = "application/json")
    public Object add(@RequestBody  UserVo loginUser,@RequestParam("stringParam")String stringParam);
    /**
     * 减少商品到购物车
     */
    @RequestMapping(value = "/api/cart/minus", method = RequestMethod.POST ,consumes = "application/json")
    public Object minus(@RequestBody  UserVo loginUser,@RequestParam("stringParam")String stringParam);
    /**
     * 更新指定的购物车信息
     */
    @RequestMapping(value = "/api/cart/update", method = RequestMethod.POST ,consumes = "application/json")
    public Object update(@RequestBody  UserVo loginUser,@RequestParam("stringParam")String stringParam);
    /**
     * 是否选择商品，如果已经选择，则取消选择，批量操作
     */
    @RequestMapping(value = "/api/cart/checked", method = RequestMethod.POST ,consumes = "application/json")
    public Object checked(@RequestBody  UserVo loginUser,@RequestParam("stringParam")String stringParam);

    @RequestMapping(value = "/api/cart/delete", method = RequestMethod.POST ,consumes = "application/json")
    public Object delete(@RequestBody  UserVo loginUser,@RequestParam("stringParam")String stringParam);
    //  获取购物车商品的总件件数
    @PostMapping("/api/cart/goodscount")
    public Object goodscount(@RequestBody  UserVo loginUser);
    /**
     * 订单提交前的检验和填写相关订单信息
     */
    @PostMapping("/api/cart/checkout")
    public Object checkout(@RequestBody  UserVo loginUser, @RequestParam("couponId")Integer couponId, @RequestParam("cart") String type);
    /**
     * 选择优惠券列表
     */
    @PostMapping("/api/cart/checkedCouponList")
    public Object checkedCouponList(@RequestBody UserVo loginUser);
}
