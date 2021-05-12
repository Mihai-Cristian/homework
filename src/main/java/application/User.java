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
    private boolean isLoggedIn = false;
    private int usernameCount = 3;
    private int passwordCount = 3;

    @Autowired
    private ShutdownManager shutdownManager;

    public User() {
        logIn();
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

    public void logIn() {
        isLoggedIn = inputUsername() & inputPassword();
        System.out.println("Login Successful!");
    }

    public void logOut() {
        SpringApplication.run(Application.class).close();
    }


    private boolean inputUsername() {
        if (usernameCount == 0) {
            System.out.println("Maximum number of tries reached. You have been logged out.");
            logOut();
        } else {
            for (int i = 0; i < usernameCount; i++) {
                try {
                    Scanner in = new Scanner(System.in);
                    System.out.print("Please enter username: ");
                    String username = in.nextLine();
                    setUsername(username);
                    break;
                } catch (RuntimeException e) {
                    usernameCount--;
                    System.out.println("Invalid username. You have " + usernameCount + " more tries.");
                    inputUsername();
                }
            }
        }

        return true;
    }

    private boolean inputPassword() {
        if (passwordCount == 0) {
            System.out.println("Maximum number of tries reached. You have been logged out.");
            logOut();
        } else {
            for (int i = 0; i < passwordCount; i++) {

                try {
                    Scanner in = new Scanner(System.in);
                    System.out.print("Please enter password: ");
                    String password = in.nextLine();
                    setPassword(password);
                    break;
                } catch (RuntimeException e) {
                    passwordCount--;
                    System.out.println("Invalid password. You have " + passwordCount + " more tries.");
                    inputPassword();
                }
            }
        }

        return true;
    }
}