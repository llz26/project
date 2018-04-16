package com.stylefeng.guns.modular.pronunciation.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.system.model.Pronunciation;
import com.stylefeng.guns.modular.pronunciation.service.IPronunciationService;

/**
 * 控制器
 *
 * @author fengshuonan
 * @Date 2018-04-13 23:09:32
 */
@Controller
@RequestMapping("/intro")
public class IntroController extends BaseController {

    private String PREFIX = "/pronunciation/";

    @Autowired
    private IPronunciationService pronunciationService;

    /**
     * 跳转到首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "intro.html";
    }


}
