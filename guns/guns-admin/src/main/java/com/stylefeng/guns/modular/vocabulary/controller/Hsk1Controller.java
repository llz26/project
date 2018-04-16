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
import com.stylefeng.guns.modular.system.model.Hsk1;
import com.stylefeng.guns.modular.vocabulary.service.IHsk1Service;

/**
 * HSK1控制器
 *
 * @author fengshuonan
 * @Date 2018-04-14 13:49:08
 */
@Controller
@RequestMapping("/hsk1")
public class Hsk1Controller extends BaseController {

    private String PREFIX = "/vocabulary/hsk1/";

    @Autowired
    private IHsk1Service hsk1Service;

    /**
     * 跳转到HSK1首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "hsk1.html";
    }

    /**
     * 跳转到添加HSK1
     */
    @RequestMapping("/hsk1_add")
    public String hsk1Add() {
        return PREFIX + "hsk1_add.html";
    }

    /**
     * 跳转到修改HSK1
     */
    @RequestMapping("/hsk1_update/{hsk1Id}")
    public String hsk1Update(@PathVariable Integer hsk1Id, Model model) {
        Hsk1 hsk1 = hsk1Service.selectById(hsk1Id);
        model.addAttribute("item",hsk1);
        LogObjectHolder.me().set(hsk1);
        return PREFIX + "hsk1_edit.html";
    }

    /**
     * 获取HSK1列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return hsk1Service.selectList(null);
    }

    /**
     * 新增HSK1
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Hsk1 hsk1) {
        hsk1Service.insert(hsk1);
        return SUCCESS_TIP;
    }

    /**
     * 删除HSK1
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer hsk1Id) {
        hsk1Service.deleteById(hsk1Id);
        return SUCCESS_TIP;
    }

    /**
     * 修改HSK1
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Hsk1 hsk1) {
        hsk1Service.updateById(hsk1);
        return SUCCESS_TIP;
    }

    /**
     * HSK1详情
     */
    @RequestMapping(value = "/detail/{hsk1Id}")
    @ResponseBody
    public Object detail(@PathVariable("hsk1Id") Integer hsk1Id) {
        return hsk1Service.selectById(hsk1Id);
    }
}
