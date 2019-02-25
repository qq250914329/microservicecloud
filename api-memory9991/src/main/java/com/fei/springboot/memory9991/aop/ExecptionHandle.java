package com.fei.springboot.memory9991.aop;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2019/1/7.
 */
@ControllerAdvice
public class ExecptionHandle {
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Map<String, Object> exceptionHandler(RuntimeException e, HttpServletResponse response) {
        if("请先登录".equals(e.getMessage())){
            Map<String, Object> rp = toResponsObject(401, "请先登录", "");
            response.setStatus(401);
            return rp;
        }
        Map map = new HashMap();
        map.put("错误信息",e.toString());
        e.printStackTrace();
        return map;
    }
    public Map<String, Object> toResponsObject(int requestCode, String msg, Object data) {
        Map<String, Object> obj = new HashMap<String, Object>();
        obj.put("errno", requestCode);
        obj.put("errmsg", msg);
        if (data != null)
            obj.put("data", data);
        return obj;
    }
}