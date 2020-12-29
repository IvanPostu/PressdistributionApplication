package com.webapp.pressdistribution.application.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterPublicityDto {
  private MultipartFile file;
  
  private Long publishedId;

  private String title;

  private String content;

}

