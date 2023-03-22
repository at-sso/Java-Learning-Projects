package sso_shop;

import sso_shop.v_data.InvalidInputException;
import java.util.Scanner;

public class sso_menu {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws InvalidInputException, InterruptedException {
        int mainSwitch;
        while (true) {
            v_data.clearScreen();
            System.out.println("Welcome to LeCar Shop.\n" + "Choose a vehicle.\n" + "0. Exit.\n" + "1. Car.\n"
                    + "2. Motorcycle.\n" + "3. Airplane.\n");
            mainSwitch = scanner.nextInt();
            switch (mainSwitch) {
                case 0:
                    scanner.close();
                    return;
                case 1:
                    v_data.INITIALIZE_FUNC.GET_FIXED_MENU(0);
                    break;
                case 2:
                    v_data.INITIALIZE_FUNC.GET_FIXED_MENU(1);
                    break;
                case 3:
                    v_data.INITIALIZE_FUNC.GET_FIXED_MENU(2);
                    break;
                default:
                    break;
            }
        }
    }
}