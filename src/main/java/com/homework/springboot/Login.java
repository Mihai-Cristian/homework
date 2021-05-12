package com.homework.springboot;

import application.BasicFunctions;
import application.User;

import java.util.Scanner;

import static application.BasicFunctions.continueForward;

public class Login {

    public Login() {
        logIn();
    }

    private final User user = new User();
    private int loginAttempts = 3;

    private static final String CORRECT_USERNAME = "Mishu";
    private static final String CORRECT_PASSWORD = "Correct";
    private static final String CORRECT_USERNAME_TWO = "Cristian";
    private static final String CORRECT_PASSWORD_TWO = "Password";

    public void logIn() {
        if (continueForward) {
            inputUsername();
            inputPassword();

            for (int i = 0; i < loginAttempts; i++) {
                try {
                    if (checkUserAndPassCombination()) {
                        break;
                    }
                } catch (RuntimeException e) {
                    loginAttempts--;
                    if (loginAttempts == 0) {
                        System.out.println("Maximum number of tries reached. You have been logged out.");
                        logOut();
                        break;
                    } else {
                        System.out.println("Invalid combination. You have " + loginAttempts + " more tries.");
                        logIn();
                    }
                }
            }
        }
    }

    private boolean checkUserAndPassCombination() {
        if ((user.getUsername().equals(CORRECT_USERNAME) && user.getPassword().equals(CORRECT_PASSWORD))
                || (user.getUsername().equals(CORRECT_USERNAME_TWO) && user.getPassword().equals(CORRECT_PASSWORD_TWO))) {
            System.out.println("Login successful!");
            return true;
        } else {
            throw new RuntimeException();
        }
    }

    public static void logOut() {
        continueForward = false;
        BasicFunctions.showMainFunctions();
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
