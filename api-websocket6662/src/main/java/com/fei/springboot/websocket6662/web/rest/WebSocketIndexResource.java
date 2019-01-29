package com.fei.springboot.websocket6662.web.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@RestController
public class WebSocketIndexResource {
	
	@GetMapping("/2")
    public ModelAndView PointToPoint(Map<String, Object> map) {
        ModelAndView res = new ModelAndView("PointToPoint2");
        return res;
    }	
}