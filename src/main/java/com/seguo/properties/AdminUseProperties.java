package com.seguo.properties;

import com.seguo.po.AdminPageContent;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties(prefix = "my.admin")
@Data
public class AdminUseProperties {
 private List<AdminPageContent> adminPageContentList;
}

