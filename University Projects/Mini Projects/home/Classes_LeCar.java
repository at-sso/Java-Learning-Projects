package home;

import java.util.Scanner;

public class Classes_LeCar {
    private static final int CARS_MENU = 0;
    private static final int MOTORCYCLE_MENU = 1;
    private static final int PLANE_MENU = 2;

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int mainSwitch = 0;

        while (true) {
            clearScreen();

            System.out.println("Welcome to LeCar Shop.\n" + "Choose a vehicle.\n" + "0. Exit.\n" + "1. Car.\n"
                    + "2. Motorcycle.\n" + "3. Airplane.\n");

            mainSwitch = scanner.nextInt();

            switch (mainSwitch) {
                case 0:
                    scanner.close();
                    return;
                case 1:
                    CarMenu();
                    break;
                case 2:
                    MotorcycleMenu();
                    break;
                case 3:
                    AirplaneMenu();
                    break;
                default:
                    break;
            }
        }
    }

    private static void clearScreen() {
        System.out.print("\r\033[2J\033[H");
    }

    private static void CarMenu() {
        clearScreen();
        System.out.println("Available Cars:\n" + "1. \"Lamborghini Diablo SE30\"\n"
                + "2. \"Koenigsegg Jesko\"\n" + "3. \"Lamborghini Veneno\"\n" + "* End *\n");

        int readSwitchValue = scanner.nextInt();

        EXECUTE_SWITCH(CARS_MENU, readSwitchValue);
    }

    private static void MotorcycleMenu() {
        clearScreen();
        System.out.println("Available Motorcycles:\n" + "1. \"Kawasaki ZX-10R\"\n"
                + "2. \"Yamaha YZF-R1 60th Anniversary\"\n" + "3. \"2022 BMW M1000RR\"\n" + "* End *\n");

        int readSwitchValue = scanner.nextInt();

        EXECUTE_SWITCH(MOTORCYCLE_MENU, readSwitchValue);
    }

    private static void AirplaneMenu() {
        clearScreen();
        System.out.println("Available Airplanes:\n" + "1. \"F-22 Raptor\"\n" + "2. \"Air Force One 747-8\"\n"
                + "3. \"B-2 Spirit\"\n" + "* End *\n");

        int readSwitchValue = scanner.nextInt();

        EXECUTE_SWITCH(PLANE_MENU, readSwitchValue);
    }

    private static void EXECUTE_SWITCH(int menu, int value) {
        switch (menu) {
            case CARS_MENU:
                System.out.println("Selected Car: " + value);
                break;
            case MOTORCYCLE_MENU:
                System.out.println("Selected Motorcycle: " + value);
                break;
            case PLANE_MENU:
                System.out.println("Selected Airplane: " + value);
                break;
        }
        scanner.nextLine();
        scanner.nextLine();
    }
}