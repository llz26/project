package com.stylefeng.guns.modular.pronunciation.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.modular.pronunciation.service.IPronunciationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 控制器
 *
 * @author fengshuonan
 * @Date 2018-04-13 23:09:32
 */
@Controller
@RequestMapping("/vowel")
public class VowelController extends BaseController {

    private String PREFIX = "/pronunciation/";

    @Autowired
    private IPronunciationService pronunciationService;

    /**
     * 跳转到首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "vowel.html";
    }


}
