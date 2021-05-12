package com.homework.application;

import com.homework.springboot.LoggingUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;
import java.util.Scanner;

public class BasicFunctions {

    public static boolean continueForward = true;
    private static final Logger LOG = LogManager.getLogger(BasicFunctions.class);

    public BasicFunctions() {
    }

    public static void showMainFunctions() {
        if (continueForward) {
            LOG.info("To see user details, type 1.");
            LOG.info("To login with different user, type 2");
            LOG.info("To logout, type 3.");
            LOG.info("Please type number: ");
            selectFunction(1);
        }
    }

    public static void selectFunction(int desiredAction) {
        Scanner in = new Scanner(System.in);
        desiredAction = desiredAction != 0 ? in.nextInt() : 3;

        switch (desiredAction) {
            case 1:
                LOG.info(Objects.requireNonNull(User.getSpecificUserByUsername()));
                showMainFunctions();
            case 2:
                new LoggingUtils();
                showMainFunctions();
            case 3:
                LoggingUtils.logOut();
        }
    }
}
