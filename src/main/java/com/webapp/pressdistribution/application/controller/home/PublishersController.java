package com.webapp.pressdistribution.application.controller.home;

import java.util.List;

import com.webapp.pressdistribution.application.dto.RegisterPublisherDto;
import com.webapp.pressdistribution.application.service.PublisherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class PublishersController {

  @Autowired
  private PublisherService publisherService;

  @RequestMapping(value = { "/home/publishers" }, method = RequestMethod.GET)
  public ModelAndView publisherGet(ModelMap model) {
    List<RegisterPublisherDto> publishers = publisherService.getPublishers();

    model.addAttribute("registerPublisher", new RegisterPublisherDto());
    model.addAttribute("publishers", publishers);
    
    return new ModelAndView("pages/home/publishers");
  }

  @RequestMapping(value = { "/home/publishers" }, method = RequestMethod.POST)
  public ModelAndView publisherCreate(RegisterPublisherDto registerPublisherDto, ModelMap model) {
    model.addAttribute("registerPublisher", new RegisterPublisherDto());

    try{
      publisherService.savePublisher(registerPublisherDto);
      return new ModelAndView("redirect:/home/publishers");
    }catch(Exception e){
      log.info(e);
      String error = "A aparut eroare in procesul procesarii cererii!!!";
      model.addAttribute("error", error);
      return new ModelAndView("pages/home/publishers");
    }

  }

}