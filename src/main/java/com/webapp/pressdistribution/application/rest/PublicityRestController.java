package com.webapp.pressdistribution.application.rest;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.pressdistribution.application.service.PublicityService;
import com.webapp.pressdistribution.domain.entity.PublicityEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/publicityImage")
public class PublicityRestController {
  
  @Autowired
  private PublicityService publicityService;

  @RequestMapping(value = "", method = RequestMethod.GET)
  public void getImage(HttpServletRequest request, HttpServletResponse response,
      @RequestParam(value = "publicityId", required = true) Long publicityId) throws IOException {

    PublicityEntity publicityEntity = publicityService.getById(publicityId);
    byte[] output = publicityEntity.getImage();

    if(output==null) return;

    response.setContentLength(output.length);
    response.setContentType(MediaType.ALL_VALUE);

    String filename = publicityEntity.getFilename() == null ? "aa.jpg" : publicityEntity
      .getFilename();

    String contentDisposition = String
      .format("attachment; filename=%s", filename);
    response.setHeader("Content-Disposition", contentDisposition);

    try {
      response.getOutputStream().write(output);
      response.getOutputStream().flush();
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

}
