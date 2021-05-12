package com.homework.springboot;

import com.homework.application.BasicFunctions;
import com.homework.application.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

import static com.homework.application.BasicFunctions.continueForward;

public class LoggingUtils {

    public LoggingUtils() {
        logIn();
    }

    private static final Logger LOG = LogManager.getLogger(LoggingUtils.class);
    private final User user = new User();
    private int loginAttempts = 3;

    private static final String CORRECT_USERNAME = PropertyReader.getProperty("CORRECT_USERNAME");
    private static final String CORRECT_PASSWORD = PropertyReader.getProperty("CORRECT_PASSWORD");
    private static final String CORRECT_USERNAME_TWO = PropertyReader.getProperty("CORRECT_USERNAME_TWO");
    private static final String CORRECT_PASSWORD_TWO = PropertyReader.getProperty("CORRECT_PASSWORD_TWO");

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
                        LOG.error("Maximum number of tries reached. You have been logged out.");
                        logOut();
                        break;
                    } else {
                        logIn();
                    }
                }
                break;
            }
        }
    }

    private boolean checkUserAndPassCombination() {
        if ((user.getUsername().equals(CORRECT_USERNAME) && user.getPassword().equals(CORRECT_PASSWORD))
                || (user.getUsername().equals(CORRECT_USERNAME_TWO) && user.getPassword().equals(CORRECT_PASSWORD_TWO))) {
            LOG.info("Login successful!");
            return true;
        } else {
            LOG.warn("Invalid combination. You have " + (loginAttempts - 1) + " more tries.");
            throw new RuntimeException();
        }
    }

    public static void logOut() {
        LOG.info("Logging out...");
        continueForward = false;
        BasicFunctions.showMainFunctions();
    }

    private void inputUsername() {
        Scanner in = new Scanner(System.in);
        LOG.info("Please enter username: ");
        String username = in.nextLine();
        user.setUsername(username);
    }

    private void inputPassword() {
        Scanner in = new Scanner(System.in);
        LOG.info("Please enter password: ");
        String password = in.nextLine();
        user.setPassword(password);
    }
}
