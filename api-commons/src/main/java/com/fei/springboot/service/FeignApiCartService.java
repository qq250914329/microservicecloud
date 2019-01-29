package com.fei.springboot.service;

import com.fei.springboot.annotation.LoginUser;
import com.fei.springboot.domain.UserVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value = "API-PROVIDER")
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
    @PostMapping("/api/cart/add")
    public Object add(@RequestBody  UserVo loginUser);
    /**
     * 减少商品到购物车
     */
    @PostMapping("/api/cart/minus")
    public Object minus(@RequestBody  UserVo loginUser);
    /**
     * 更新指定的购物车信息
     */
    @PostMapping("/api/cart/update")
    public Object update(@RequestBody  UserVo loginUser);
    /**
     * 是否选择商品，如果已经选择，则取消选择，批量操作
     */
    @PostMapping("/api/cart/checked")
    public Object checked(@RequestBody  UserVo loginUser);

    @PostMapping("/api/cart/delete")
    public Object delete(@RequestBody  UserVo loginUser);
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
