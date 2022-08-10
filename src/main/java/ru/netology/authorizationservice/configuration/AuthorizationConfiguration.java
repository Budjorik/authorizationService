package ru.netology.authorizationservice.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.netology.authorizationservice.controller.AuthorizationController;
import ru.netology.authorizationservice.repository.UserRepository;
import ru.netology.authorizationservice.service.AuthorizationService;

@Configuration
public class AuthorizationConfiguration {

    @Bean
    public UserRepository userRepository() {
        return new UserRepository();
    }

    @Bean
    public AuthorizationService service(UserRepository userRepository) {
        return new AuthorizationService(userRepository);
    }

    @Bean
    public AuthorizationController authorizationController(AuthorizationService service) {
        return new AuthorizationController(service);
    }

}
