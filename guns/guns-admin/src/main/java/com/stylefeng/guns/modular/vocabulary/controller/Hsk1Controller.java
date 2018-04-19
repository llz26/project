package com.stylefeng.guns.modular.vocabulary.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.modular.vocabulary.Domain.HSK;
import com.stylefeng.guns.modular.vocabulary.service.HSKService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/hsk1")
public class HSK1Controller extends BaseController{
    private HSKService hskService;
    @Autowired
    public void setHskService(HSKService hskService) {
        this.hskService = hskService;
    }
    private String PREFIX = "/vocabulary/hsk1/";

    @RequestMapping(value="",method= RequestMethod.GET)
    public String index(Model model){
        List<HSK> hskList = hskService.getHskList(1);
        model.addAttribute("hskList",hskList);
        return PREFIX + "hsk1.html";
    }
}