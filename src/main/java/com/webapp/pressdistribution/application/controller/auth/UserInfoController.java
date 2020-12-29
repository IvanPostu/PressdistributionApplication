package com.webapp.pressdistribution.application.controller.auth;

import com.webapp.pressdistribution.domain.entity.UserEntity;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserInfoController {

  @RequestMapping(value = { "/user/info" }, method = RequestMethod.GET)
  public ModelAndView registerGet(@AuthenticationPrincipal UserEntity user, ModelMap model) {
    model.addAttribute("userInfo", user);

    return new ModelAndView("pages/auth/user-info", model);
  }

}