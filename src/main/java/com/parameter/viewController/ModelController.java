package com.parameter.viewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 杨森霖
 * @author 2020/10/9 0009 下午 12:47
 */
@Controller
public class ModelController {

    @RequestMapping("hello")
    public String hello(){
        return "index";
    }
}
