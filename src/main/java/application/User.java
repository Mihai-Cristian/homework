package application;

import com.homework.springboot.Application;
import com.homework.springboot.ShutdownManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class User {

    private static final String CORRECT_USERNAME = "Mishu";
    private static final String CORRECT_PASSWORD = "Correct";

    public User() {

    }

    @Bean
    public User getUser() {
        return User.this;
    }

    private String username;
    private String password;

    public void setUsername(String username) {
        if (!username.equals(CORRECT_USERNAME)) {
            throw new RuntimeException();
        }
        this.username = username;
    }

    public void setPassword(String password) {
        if (!password.equals(CORRECT_PASSWORD)) {
            throw new RuntimeException();
        }
        this.password = password;
    }


}