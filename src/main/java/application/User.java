package application;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class User {

    public User(String username, String password) {
        setUsername(username);
        setPassword(password);
    }

    public User() {

    }

    @Bean
    public User getUser() {
        return User.this;
    }

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}