package com.webapp.pressdistribution.application.controller.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

  @RequestMapping(value = { "/" }, method = RequestMethod.GET)
  public ModelAndView homeRedirect() {
    return new ModelAndView("redirect:/home");
  }

  @RequestMapping(value = { "/home" }, method = RequestMethod.GET)
  public ModelAndView home() {
    return new ModelAndView("pages/home/home");
  }

}