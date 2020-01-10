package com.note.code.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/hello")

public class Hello {
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    //    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    String hello(@PathVariable String id) {
    return "Hello, " + id + "!";
    }
}
