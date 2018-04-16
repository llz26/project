package com.stylefeng.guns.modular.vocabulary.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.system.model.Hsk2;
import com.stylefeng.guns.modular.vocabulary.service.IHsk2Service;

/**
 * HSK2控制器
 *
 * @author fengshuonan
 * @Date 2018-04-14 14:33:44
 */
@Controller
@RequestMapping("/hsk2")
public class Hsk2Controller extends BaseController {

    private String PREFIX = "/vocabulary/hsk2/";

    @Autowired
    private IHsk2Service hsk2Service;

    /**
     * 跳转到HSK2首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "hsk2.html";
    }

    /**
     * 跳转到添加HSK2
     */
    @RequestMapping("/hsk2_add")
    public String hsk2Add() {
        return PREFIX + "hsk2_add.html";
    }

    /**
     * 跳转到修改HSK2
     */
    @RequestMapping("/hsk2_update/{hsk2Id}")
    public String hsk2Update(@PathVariable Integer hsk2Id, Model model) {
        Hsk2 hsk2 = hsk2Service.selectById(hsk2Id);
        model.addAttribute("item",hsk2);
        LogObjectHolder.me().set(hsk2);
        return PREFIX + "hsk2_edit.html";
    }

    /**
     * 获取HSK2列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return hsk2Service.selectList(null);
    }

    /**
     * 新增HSK2
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Hsk2 hsk2) {
        hsk2Service.insert(hsk2);
        return SUCCESS_TIP;
    }

    /**
     * 删除HSK2
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer hsk2Id) {
        hsk2Service.deleteById(hsk2Id);
        return SUCCESS_TIP;
    }

    /**
     * 修改HSK2
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Hsk2 hsk2) {
        hsk2Service.updateById(hsk2);
        return SUCCESS_TIP;
    }

    /**
     * HSK2详情
     */
    @RequestMapping(value = "/detail/{hsk2Id}")
    @ResponseBody
    public Object detail(@PathVariable("hsk2Id") Integer hsk2Id) {
        return hsk2Service.selectById(hsk2Id);
    }
}
