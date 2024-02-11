package org.hashiro.maven.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties
@Data
public class JiraConfig {
    private String jiraUrl;
    private User user;

    @Data
    public static class User {
        private String username;
        private String password;
    }
}
