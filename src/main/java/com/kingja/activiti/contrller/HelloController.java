package com.kingja.activiti.contrller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:TODO
 * Create Time:2020/8/26 0026 上午 10:54
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
@RestController
public class HelloController {
    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String hello() {
        return "Activiti7欢迎你";
    }


}
