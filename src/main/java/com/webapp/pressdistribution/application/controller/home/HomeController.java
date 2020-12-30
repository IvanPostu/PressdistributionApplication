package com.webapp.pressdistribution.application.controller.home;

import java.util.List;

import com.webapp.pressdistribution.application.service.PublicityService;
import com.webapp.pressdistribution.domain.entity.PublicityEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

  @Autowired
  private PublicityService publicityService;

  @RequestMapping(value = { "/" }, method = RequestMethod.GET)
  public ModelAndView homeRedirect() {
    return new ModelAndView("redirect:/home");
  }

  @RequestMapping(value = { "/home" }, method = RequestMethod.GET)
  public ModelAndView home(ModelMap model) {

    List<PublicityEntity> publicities = publicityService.allPublicities();

    if(publicities != null){
      if(publicities.size()>3){
        publicities = publicities.subList(0, 3);
      }
  
      model.addAttribute("publicities", publicities);
    }
    

    return new ModelAndView("pages/home/home", model);
  }

}