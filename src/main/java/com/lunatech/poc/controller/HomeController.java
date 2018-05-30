package com.lunatech.poc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lunatech.poc.util.ReturnPath;


@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET )
    public String home() {
        return ReturnPath.HOME_PAGE;
    }

}
