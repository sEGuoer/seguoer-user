package com.seguo.properties;

import com.seguo.po.AdminPageContent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

@ConfigurationProperties(prefix = "my.admin")
@Data
public class AdminUseProperties {
 private Map<String, AdminPageContent> adminPageContentMap;
 public String getAdminContent(String name){
  return adminPageContentMap.get(name).getName();
 }
}

