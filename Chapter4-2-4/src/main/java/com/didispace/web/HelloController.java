package com.didispace.web;

import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;

/**
 * @author 程序猿DD
 * @version 1.0.0
 * @date 16/5/19 下午1:27.
 * @blog http://blog.didispace.com
 */
@RestController
public class HelloController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String hello(@RequestParam String name) {
        return "Hello " + name;
    }

    @RequestMapping(value = "/getUserInfo", method = RequestMethod.GET)
    @ResponseBody
    public UserInfo getUserInfo() {

        long id =new Date().getTime();
        UUID uuid = UUID.randomUUID();
        UserInfo userInfo=new UserInfo(id,uuid.toString());
        return userInfo;
    }

}

 class UserInfo
{


    private long id;
    private String userName;

    public UserInfo(long id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
