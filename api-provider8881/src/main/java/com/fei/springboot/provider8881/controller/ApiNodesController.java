package com.fei.springboot.provider8881.controller;

import com.alibaba.fastjson.JSONObject;
import com.fei.springboot.annotation.IgnoreAuth;
import com.fei.springboot.annotation.LoginUser;
import com.fei.springboot.domain.AdVo;
import com.fei.springboot.domain.ChannelVo;
import com.fei.springboot.domain.NodesVo;
import com.fei.springboot.domain.UserVo;
import com.fei.springboot.provider8882.service.ApiAdService;
import com.fei.springboot.provider8882.service.ApiChannelService;
import com.fei.springboot.provider8882.service.ApiNodesService;
import com.fei.springboot.provider8882.util.ApiBaseAction;
import com.fei.springboot.util.Query;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Controller
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2019-02-26 09:49:13
 */
@RestController
@RequestMapping("/api/nodes")
public class ApiNodesController  extends ApiBaseAction {
    @Autowired
    private ApiNodesService nodesService;
    @Autowired
    private ApiAdService adService;
    @Autowired
    private ApiChannelService channelService;

    /**
     * 查看列表
     */
    @IgnoreAuth
    @PostMapping("list")
    public Object list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                       @RequestParam(value = "size", defaultValue = "10") Integer size,
                       @RequestParam(value = "type", defaultValue = "1") Integer type) {
        Map<String, Object> resultObj = new HashMap<String, Object>();
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("ad_position_id", 2);
        List<AdVo> banner = this.adService.queryList(params);
        resultObj.put("banner", banner);

        Map paramChannel = new HashMap();
        paramChannel.put("sidx", "sort_order ");
        paramChannel.put("order", "asc ");
        paramChannel.put("type", 2);
        List<ChannelVo> channel = this.channelService.queryList(paramChannel);
        resultObj.put("channel", channel);

        Map param = new HashMap();
        param.put("page", page);
        param.put("limit", size);
        param.put("sidx", "id");
        param.put("order", "desc");
        Query query = new Query(param);
        List<NodesVo> nodesList = nodesService.queryList(query);
        int total = nodesService.queryTotal(query);
        resultObj.put("nodesList", nodesList);
        //ApiPageUtils pageUtil = new ApiPageUtils(resultObj, total, query.getLimit(), query.getPage());
        return toResponsSuccess(resultObj);
    }

    /**
     * 查看列表
     */
    @IgnoreAuth
    @PostMapping("changeList")
    public Object changelist(@RequestParam(value = "page", defaultValue = "1") Integer page,
                       @RequestParam(value = "size", defaultValue = "10") Integer size,
                       @RequestParam(value = "type", defaultValue = "1") Integer type) {
        Map<String, Object> resultObj = new HashMap<String, Object>();
        Map param = new HashMap();
        param.put("page", page);
        param.put("limit", size);
        param.put("type", type);
        param.put("sidx", "id");
        param.put("order", "desc");
        Query query = new Query(param);
        List<NodesVo> nodesList = nodesService.queryList(query);
        int total = nodesService.queryTotal(query);
        resultObj.put("nodesList", nodesList);
        //ApiPageUtils pageUtil = new ApiPageUtils(resultObj, total, query.getLimit(), query.getPage());
        return toResponsSuccess(resultObj);
    }

    /**
     * 查看信息
     */
    @IgnoreAuth
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "笔记ID", required = true, dataType = "Integer")})
    @PostMapping("detail")
    public Object detail(@LoginUser UserVo loginUser, Integer id) {
        NodesVo nodes = nodesService.queryObject(id);
        return toResponsSuccess(nodes);
    }

    /**
     * 保存
     */
    @ApiOperation(value = "保存")
    @PostMapping("save")
    public Object save(@RequestBody NodesVo nodes,String stringParam) {
        JSONObject addressJson = JSONObject.parseObject(stringParam);
        NodesVo entity = new NodesVo();
        if (null != addressJson) {
            entity.setId(addressJson.getInteger("id"));
        }
        if (null == entity.getId() || entity.getId() == 0) {
            entity.setId(null);
            this.nodesService.save(entity);
        } else {
            this.nodesService.update(entity);
        }
        return toResponsSuccess(entity);
    }

    /**
     * 删除
     */
    @ApiOperation(value = "删除指定的记录", response = Map.class)
    @PostMapping("delete")
    public Object delete(@LoginUser UserVo loginUser,String stringParam) {
        JSONObject jsonParam = JSONObject.parseObject(stringParam);
        Integer id = jsonParam.getIntValue("id");

        NodesVo entity = this.nodesService.queryObject(id);
        //判断越权行为
        if (!entity.getUserid().equals(loginUser.getUserId())) {
            return toResponsObject(403, "您无权删除", "");
        }
        this.nodesService.delete(id);
        return toResponsSuccess("");
    }
}
