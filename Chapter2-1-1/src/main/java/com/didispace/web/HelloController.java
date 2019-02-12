package com.didispace.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 程序猿DD
 * @version 1.0.0
 * @blog http://blog.didispace.com
 *
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String index() {
        return "Hello World";
    }

    /*不知道为啥post 就不能访问到*/
    @RequestMapping(value = {"/getJson1"}, method = {RequestMethod.POST}, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getJson1() {
        //rsp.addHeader("Access-Control-Allow-Origin", "*");
        return "{\"url\":\"http://192.168.1.1/notify\"}";
    }


    @RequestMapping(value = {"/getJson"}, method = {RequestMethod.GET}, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getJson() {
        //rsp.addHeader("Access-Control-Allow-Origin", "*");
        return "{\"url\":\"http://192.168.1.1/notify\"}";
    }


}