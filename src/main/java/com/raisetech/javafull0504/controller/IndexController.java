package com.raisetech.javafull0504.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// @Controller アノテーションはHTMLなどのViewを返すようになる
@Controller
public class IndexController {

    //value に配列を入れると、複数のパスに同じ動作を一度に割り当てられる
    @RequestMapping(value = {"/", "/index", "index.html"} )
    public String noPath() {
        return "/index";
    }
//
}
