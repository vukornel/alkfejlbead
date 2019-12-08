package hu.vkzsa.alkfejlbead;

import java.util.Collections;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import hu.vkzsa.alkfejlbead.entity.User;
import hu.vkzsa.alkfejlbead.repository.UserRepository;

@SpringBootApplication
public class AlkfejlbeadApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlkfejlbeadApplication.class, args);
    }

    @Bean
    CommandLineRunner init(UserRepository userRepository) {
        return args -> {
            Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(name -> {
                User user = new User(name, name.toLowerCase() + "@domain.com", "12345", Collections.emptyList());
                userRepository.save(user);
            });
            userRepository.findAll().forEach(System.out::println);
        };
    }

    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
          @Override
          public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/users").allowedOrigins("http://localhost:4200");
          }
        };
      }
}
