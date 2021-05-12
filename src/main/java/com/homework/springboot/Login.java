package com.homework.springboot;

import application.User;
import org.springframework.boot.SpringApplication;

import java.util.Scanner;

public class Login {

    public Login() {
        logIn();
    }

    private User user = new User();
    private boolean isLoggedIn = false;
    private int usernameCount = 3;
    private int passwordCount = 3;

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
                    user.setUsername(username);
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
                    user.setPassword(password);
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
