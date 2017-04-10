package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Raghu on 06-Mar-16.
 */

@Controller
public class IndexController {

    @RequestMapping("/hello")
    String index() {
        return "index";
    }

    @RequestMapping("/fit")
    String fit() {
        return "fitness";
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginForm(Model model) {
        model.addAttribute("login", new Login());
        System.out.print("Login Call");
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginSubmit(@ModelAttribute Login login, Model model) {
        model.addAttribute("login", login);

       /* model.addAttribute("userId", login.getUserId());
        model.addAttribute("password", login.getPassword());
*/
        System.out.println("Login result Call" + login.getUserId() + " \n" + login.getPassword());
        return "welcome";
    }

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        System.out.print("FirstCall to greeting");
        return "greeting";
    }

    @RequestMapping(value = "/greeting", method = RequestMethod.POST)
    public String greetingSubmit(@ModelAttribute Greeting greeting, Model model) {
        model.addAttribute("greeting", greeting);
        System.out.print("Second Call");
        return "result";
    }


}