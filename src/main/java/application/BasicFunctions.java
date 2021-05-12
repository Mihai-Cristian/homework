package application;

import com.homework.springboot.Login;

import java.util.Objects;
import java.util.Scanner;

public class BasicFunctions {

    public static boolean continueForward = true;

    public BasicFunctions() {
    }

    public static void showMainFunctions() {
        if (continueForward) {
            System.out.println();
            System.out.println("To see user details, type 1.");
            System.out.println("To login with different user, type 2");
            System.out.println("To logout, type 3.");
            System.out.println();
            System.out.print("Please type number: ");
            selectFunction(1);
        }
    }

    public static void selectFunction(int desiredAction) {
        Scanner in = new Scanner(System.in);
        desiredAction = desiredAction != 0 ? in.nextInt() : 3;

        switch (desiredAction) {
            case 1:
                System.out.println(Objects.requireNonNull(User.getUserInformation()));
                showMainFunctions();
            case 2:
                new Login();
                showMainFunctions();
            case 3:
                Login.logOut();
        }
    }
}
