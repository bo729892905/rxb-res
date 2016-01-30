package com.rxb.res.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by rxb on 2016/1/31.
 */
@Controller
@RequestMapping("main")
public class TemplateController {
    @RequestMapping(value = "{reqName}")
    public ModelAndView testFreemarker(HttpServletRequest request, @PathVariable String reqName) {
        ModelAndView mav=new ModelAndView("hello");
        mav.addObject("name", reqName);
        return mav;
    }
}
