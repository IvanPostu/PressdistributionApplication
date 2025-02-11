package com.webapp.pressdistribution.application.controller.auth;

import java.util.ArrayList;
import java.util.List;

import com.webapp.pressdistribution.application.dto.RegisterUserDTO;
import com.webapp.pressdistribution.application.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegisterController {

  @Autowired
  private UserService userService;

  @RequestMapping(value = { "/auth/register" }, method = RequestMethod.GET)
  public ModelAndView registerGet(ModelMap model) {
    model.addAttribute("registerUser", new RegisterUserDTO());
    return new ModelAndView("pages/auth/register", model);
  }

  @RequestMapping(value = { "/auth/register" }, method = RequestMethod.POST)
  public ModelAndView registerPost(RegisterUserDTO registerUser, ModelMap model) {
    List<String> errors = new ArrayList<>();

    try{
      userService.addUser(registerUser);
    }catch(Exception e){
      errors.add("A apărut eroare!!!");
      model.addAttribute("errors", errors);
      model.addAttribute("registerUser", registerUser);

      return new ModelAndView("pages/auth/register", model);
    }

    return new ModelAndView("redirect:/login");
  }

}