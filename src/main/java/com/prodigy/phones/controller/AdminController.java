package com.prodigy.phones.controller;

import com.prodigy.phones.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@RequestMapping(value = "admin")
public class AdminController {


    @Autowired
    private PhoneService service;

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error) {

        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid username or password!");
        }

        model.setViewName("admin");

        return model;

    }

    @RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
    public ModelAndView accesssDenied(Principal user) {

        ModelAndView model = new ModelAndView();

        if (user != null) {
            model.addObject("errorMsg", user.getName() + ", you don't have access to this page!");
        } else {
            model.addObject("errorMsg", "You don't have access to this page!");
        }

        model.setViewName("admin/accessDenied");
        return model;

    }


    @RequestMapping(value = "/success")
    public String success() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userName = auth.getName(); //
//        String userPass = auth.getCredentials().toString();

//        service.addUser(new User(userName, "pass", true));

        return "redirect:/admin/main";
    }

    @RequestMapping(value = "/main")
    public String main(Model model) {


        return "admin/index";
    }


}
