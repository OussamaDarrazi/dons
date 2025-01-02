package com.tbs.dons.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommunController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

}
