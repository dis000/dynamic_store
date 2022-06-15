package com.shop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("model")
public class AboutController {

    @GetMapping("faq")
    public String getFaq() {
        return "faq";
    }

    @GetMapping("contact")
    public String getContact() {
        return "contact";
    }
}
