package com.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    // 템플릿의 main으로 이동 하는 것
    @GetMapping("/")
    public String main() {
        return "main";
    }
}
