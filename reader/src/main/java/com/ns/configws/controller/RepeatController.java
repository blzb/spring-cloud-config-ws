package com.ns.configws.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by apimentel on 3/7/17.
 */
@RefreshScope
@Controller
@RequestMapping("app")
public class RepeatController {
    @Value("${app.repeat: 1}")
    Long repeat;
    @Value("${app.label}")
    String label;

    @RequestMapping(value = "/repeat", method = RequestMethod.GET)
    @ResponseBody String getLabel(){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i< repeat; i++){
            stringBuilder.append(label).append("<br/>");
        }
        return stringBuilder.toString();
    }
}
