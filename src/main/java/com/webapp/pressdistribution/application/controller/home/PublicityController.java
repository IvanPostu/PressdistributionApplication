package com.webapp.pressdistribution.application.controller.home;

import java.util.List;

import com.webapp.pressdistribution.application.dto.RegisterPublicityDto;
import com.webapp.pressdistribution.application.service.PublicityService;
import com.webapp.pressdistribution.application.service.PublisherService;
import com.webapp.pressdistribution.domain.entity.PublicityEntity;
import com.webapp.pressdistribution.domain.entity.PublisherEntity;
import com.webapp.pressdistribution.domain.entity.UserEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class PublicityController {

  @Autowired
  private PublisherService publisherService;

  @Autowired
  private PublicityService publicityService;

  @RequestMapping(value = { "/home/publicities" }, method = RequestMethod.GET)
  public ModelAndView publicities(ModelMap model) {

    List<PublicityEntity> publicities = publicityService.allPublicities();

    

    model.addAttribute("publicities", publicities);

    return new ModelAndView("pages/home/publicities", model);
  }

  @RequestMapping(value = { "/home/publicities/add" }, method = RequestMethod.GET)
  public ModelAndView publicitiesAddPage(ModelMap model) {
   
    List<PublisherEntity> publisherEntities = publisherService.getPublishersEntities();

    model.addAttribute("publicity", new RegisterPublicityDto());
    model.addAttribute("publishers", publisherEntities);
    return new ModelAndView("pages/home/publicity-add", model);
  }

  @RequestMapping(value = { "/home/publicity/{id}" }, method = RequestMethod.GET)
  public ModelAndView publicityInfo(@PathVariable(name = "id") Long id, ModelMap model) {

    try{
      PublicityEntity publicityEntity = publicityService.getById(id);
      model.addAttribute("publicityId", publicityEntity.getId());
      model.addAttribute("publicityTitle", publicityEntity.getTitle());
      model.addAttribute("publicityContent", publicityEntity.getContent());
      model.addAttribute("publisherName", publicityEntity.getPublisherEntity().getName());
      model.addAttribute("publisherEmail", publicityEntity.getPublisherEntity().getEmail());
      model.addAttribute("authorEmail", publicityEntity.getUserEntity().getEmail());
      model.addAttribute("authorFirstname", publicityEntity.getUserEntity().getFirstName());
      model.addAttribute("authorLastname", publicityEntity.getUserEntity().getLastName());
      
    }catch(Exception e){
      log.error(e);
      return new ModelAndView("redirect:/home/publicities", model);
    }

    return new ModelAndView("pages/home/publicity-info", model);
  }
  
  @RequestMapping(value = { "/home/publicities/add" }, method = RequestMethod.POST)
  public ModelAndView savePublicity( 
    @AuthenticationPrincipal UserEntity user,
    RegisterPublicityDto registerPublicityDto,
    ModelMap model) 
  {

    PublicityEntity publicityEntity = new PublicityEntity();
    publicityEntity.setContent(registerPublicityDto.getContent());
    publicityEntity.setTitle(registerPublicityDto.getTitle());
    publicityEntity.setUserEntity(user);
    
    PublisherEntity publisherEntity = new PublisherEntity();
    publisherEntity.setId(registerPublicityDto.getPublishedId());

    publicityEntity.setPublisherEntity(publisherEntity);

    
    if(!registerPublicityDto.getFile().isEmpty()){
      try{
        byte[] imageFile = registerPublicityDto.getFile().getBytes();
        publicityEntity.setImage(imageFile);
        publicityEntity.setFilename(registerPublicityDto.getFile().getOriginalFilename());
      }catch(Exception e){
        log.warn(e);
      }
    }

    try{
      publicityService.savePublicity(publicityEntity);
      return new ModelAndView("redirect:/home/publicities");
    }catch(Exception e){
      log.warn(e);
      return new ModelAndView("pages/home/publicities");
    }

  }

}