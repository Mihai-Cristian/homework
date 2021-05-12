package com.homework.springboot;

import application.BasicFunctions;
import application.User;
import org.springframework.boot.SpringApplication;

import java.util.Scanner;

public class Login {

    public Login() {
        logIn();
    }

    private User user = new User();
    private boolean isLoggedIn = false;
    private int loginAttempts = 3;

    private static final String CORRECT_USERNAME = "Mishu";
    private static final String CORRECT_PASSWORD = "Correct";
    private static final String CORRECT_USERNAME_TWO = "Cristian";
    private static final String CORRECT_PASSWORD_TWO = "Password";

    public void logIn() {
        inputUsername();
        inputPassword();

        if (loginAttempts == 0) {
            System.out.println("Maximum number of tries reached. You have been logged out.");
            logOut();
        } else {
            for (int i = 0; i < loginAttempts; i++) {
                try {
                    if (isLoggedIn = checkUserAndPassCombination()) {
                        break;
                    }
                } catch (RuntimeException e) {
                    loginAttempts--;
                    System.out.println("Invalid combination. You have " + loginAttempts + " more tries.");
                    logIn();
                }
            }
        }
        System.out.println("Login successful!");
        loginAttempts = 3;
        new BasicFunctions().showMainFunctions();
    }

    private boolean checkUserAndPassCombination() {
        if ((user.getUsername().equals(CORRECT_USERNAME) && user.getPassword().equals(CORRECT_PASSWORD))
                || (user.getUsername().equals(CORRECT_USERNAME_TWO) && user.getPassword().equals(CORRECT_PASSWORD_TWO))) {
            return true;
        } else {
            throw new RuntimeException();
        }
    }

    public void logOut() {
        SpringApplication.run(Application.class).close();
    }

    private void inputUsername() {
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter username: ");
        String username = in.nextLine();
        user.setUsername(username);
    }

    private void inputPassword() {
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter password: ");
        String password = in.nextLine();
        user.setPassword(password);
    }
}
