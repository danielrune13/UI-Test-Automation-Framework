package org.hashiro.maven.configuration;

import lombok.Data;
import org.hashiro.maven.domain.User;
import org.hashiro.maven.domain.UserType;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties
@Data
public class TestConfig {
    private String url;
    private Users users;

    @Data
    public static class Users {
        private User standardUser;
        private User lockedOutUser;
        private User problemUser;
        private User performanceGlitchUser;
        private User errorUser;
        private User visualUser;

        public User getUserByType(UserType userType){
            switch (userType){
                case LOCKED_OUT_USER:
                    return lockedOutUser;
                case PROBLEM_USER:
                    return problemUser;
                case PERFORMANCE_GLITCH_USER:
                    return performanceGlitchUser;
                case ERROR_USER:
                    return errorUser;
                case VISUAL_USER:
                    return visualUser;
                case STANDARD_USER:
                default:
                    return standardUser;
            }
        }
    }
}
