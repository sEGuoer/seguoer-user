package com.seguo.config;

import com.seguo.properties.AdminUseProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(AdminUseProperties.class)
public class AdminUsePropertiesConfig {
}
