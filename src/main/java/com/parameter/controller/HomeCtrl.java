package com.parameter.controller;

import com.ej.common.anno.auth.Sign;
import com.ej.common.anno.bind.RequestAttr;
import com.ej.common.model.ResponseDataPackage;
import com.parameter.util.ParcelDataPackage;
import org.apache.commons.lang3.Validate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 杨森霖
 * @author 2020/8/20 0020 下午 14:44
 */
@RestController
public class HomeCtrl {

    @RequestMapping(value = "/do/login")
    @Sign
    void doLogin(@RequestAttr ResponseDataPackage resultData, @RequestBody ParcelDataPackage rd) {
        Validate.notEmpty("123", "手机号码不能为空");
    }




}
