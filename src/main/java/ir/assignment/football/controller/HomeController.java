package ir.assignment.football.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public ModelAndView mainMenu(){
        return new ModelAndView("home");
    }
    @RequestMapping(value = "/home")
    public ModelAndView home(){
        return new ModelAndView("home");
    }

    @RequestMapping(value = "/mainListMatch")
    public ModelAndView listMatch(){
        return new ModelAndView("redirect:/listMatch");
    }

}
