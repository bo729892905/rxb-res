package com.rxb.res.web.controller;

import com.rxb.res.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

/**
 * Created by rxb on 2016/1/31.
 */
@Controller
@RequestMapping("main")
public class TemplateController {
    @RequestMapping(value = "")
    public ModelAndView test() {
        return new ModelAndView("redirect:main/test1.html");
    }

    @RequestMapping(value = "{reqName}.html")
    public ModelAndView testFreemarker(HttpServletRequest request, @PathVariable String reqName) {
        ModelAndView mav=new ModelAndView("hello");
        mav.addObject("name", reqName);
        List<String> itemList= Arrays.asList("test1","test2");
        mav.addObject("itemList", itemList);
        User user = new User();
        user.setUsername("tom123");
        mav.addObject("user", user);
        return mav;
    }
}
