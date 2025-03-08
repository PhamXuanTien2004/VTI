package com.vti.testing.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // đánh dấu class thuộc layer Controller
@RequestMapping("hello") // tạo đường dẫn tới Controller
public class HelloController {
    @GetMapping // đánh dấu method xử lý cho phương thức GET
    public String helloWorld() {
        return "Hello Spring";
    }
}