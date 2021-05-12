package application;

import com.homework.springboot.Login;

import java.util.Scanner;

public class BasicFunctions {

    public BasicFunctions() {
    }

    public void showMainFunctions() {
        System.out.println();
        System.out.println("To see user details, type 1.");
        System.out.println("To login with different user, type 2");
        System.out.println("To logout, type 3.");
        System.out.println();
        selectFunction();
    }

    public void selectFunction() {
        Scanner in = new Scanner(System.in);
        System.out.print("Please type number: ");
        int desiredAction = in.nextInt();

        switch (desiredAction) {
            case 1:
                System.out.println(User.getUserInformation().toString());
                showMainFunctions();
            case 2:
                new Login();
                showMainFunctions();
            case 3:
                //TODO logout
                break;
        }
    }
}
