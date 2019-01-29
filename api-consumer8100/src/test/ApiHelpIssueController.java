package com.fei.springboot.controller;

import com.fei.springboot.annotation.IgnoreAuth;
import com.fei.springboot.domain.HelpIssueVo;
import com.fei.springboot.domain.HelpTypeVo;
import com.fei.springboot.service.ApiHelpIssueService;
import com.fei.springboot.service.ApiHelpTypeService;
import com.fei.springboot.util.ApiBaseAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Controller
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2018-11-07 11:04:20
 */
@RestController
@RequestMapping("api/helpissue")
public class ApiHelpIssueController extends ApiBaseAction {
    /**
     * 查看帮助类型列表
     */
    @RequestMapping("/typeList")
    @IgnoreAuth
    public Object typeList() {
        return toResponsSuccess(list);
    }

    /**
     * 查看问题列表
     */
    @RequestMapping("/issueList")
    @IgnoreAuth
    public Object issueList(Long type_id) {
        return toResponsSuccess(helpIssueList);
    }
}
