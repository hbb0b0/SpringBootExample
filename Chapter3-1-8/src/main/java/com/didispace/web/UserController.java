package com.didispace.web;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author 程序猿DD
 * @version 1.0.0
 * @blog http://blog.didispace.com
 *
 */
@Controller
public class UserController {

    /*
    以下两种xml 都是兼容的
    node:
    <?xml version="1.0" encoding="UTF-8"?>
	<User>
		<name>hbb0b0</name>
		<age>14</age>
	</User>
	property:
	<?xml version="1.0" encoding="UTF-8"?>
	<User name="hbb0b0" age="10">
	</User>

	输出：
	<User>
    <name>didispace.com : hbb0b0</name>
    <age>110</age>
</User>
	*/
    @PostMapping(value = "/user", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public User create(@RequestBody User user) {
        user.setName("didispace.com : " + user.getName());
        user.setAge(user.getAge() + 100);
        return user;
    }

}