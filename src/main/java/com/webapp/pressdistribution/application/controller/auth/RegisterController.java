package com.webapp.pressdistribution.application.controller.auth;

import java.util.ArrayList;
import java.util.List;

import com.webapp.pressdistribution.application.dto.RegisterUserDTO;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegisterController {

  @RequestMapping(value = { "/auth/register" }, method = RequestMethod.GET)
  public ModelAndView registerGet(ModelMap model) {
    model.addAttribute("registerUser", new RegisterUserDTO());
    return new ModelAndView("pages/auth/register", model);
  }

  @RequestMapping(value = { "/auth/register" }, method = RequestMethod.POST)
  public ModelAndView registerPost(RegisterUserDTO registerUser, ModelMap model) {
    List<String> errors = new ArrayList<>();


    if(registerUser.isReader() == registerUser.isWriter() && registerUser.isWriter()==false){
      errors.add("Este necesar de selectat minimum 1 rola pentru utilizator!!!");
    }

    if (errors.size()>0) {
      model.addAttribute("registerUser", registerUser);
      model.addAttribute("errors", errors);
      return new ModelAndView("pages/auth/register", model);
    }

    return new ModelAndView("redirect:login");
  }

}