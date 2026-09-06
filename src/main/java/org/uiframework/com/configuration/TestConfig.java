package org.uiframework.com.configuration;

import lombok.Data;
import org.uiframework.com.domain.User;
import org.uiframework.com.domain.UserType;
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
            return switch (userType){
                case STANDARD_USER -> standardUser;
                case LOCKED_OUT_USER -> lockedOutUser;
                case PROBLEM_USER -> problemUser;
                case PERFORMANCE_GLITCH_USER -> performanceGlitchUser;
                case ERROR_USER -> errorUser;
                case VISUAL_USER -> visualUser;
            };
        }
    }
}
