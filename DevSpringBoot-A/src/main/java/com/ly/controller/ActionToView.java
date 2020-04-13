package com.ly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ActionToView {
    @RequestMapping("/getPath.do")
    public String getPath(){
        return "uu";
    }
}