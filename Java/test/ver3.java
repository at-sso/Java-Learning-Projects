package test;

public class ver3 {

import java.util.Scanner;

// Define enum for menu switch
enum MenuSwitch {
    CarsMenu,
    MotorcycleMenu,
    OtherMenu
}

// Define enum for cars submenu
enum CarsSubMenu {
    LamborghiniDiabloSE30,
    KoenigseggJesko,
    LamborghiniVeneno
}

// Define enum for motorcycle submenu
enum MotorcycleSubMenu {
        KawasakiZX10R,
        BMWM1000RR,
        DucatiPanigaleV4
    }

    // Declare variables
    static int[] readSwitchValue = new int[3];
    static double finalPrice;
    static boolean enableFunction;

    // Main method
    public static void main(String[] args) {

        // Print the menu
        printMenu();

        // Read the user input
        Scanner scanner = new Scanner(System.in);
        int userInput = scanner.nextInt();

        // Process the user input
        switch (userInput) {
            case 1:
                readSwitchValue[0] = displaySubMenu(MenuSwitch.CarsMenu);
                EXECUTE_SWITCH(CarsSubMenu.values()[readSwitchValue[0] - 1]);
                break;
            case 2:
                readSwitchValue[1] = displaySubMenu(MenuSwitch.MotorcycleMenu);
                EXECUTE_SWITCH(MotorcycleSubMenu.values()[readSwitchValue[1] - 1]);
                break;
            case 3:
                readSwitchValue[2] = displaySubMenu(MenuSwitch.OtherMenu);
                EXECUTE_SWITCH(readSwitchValue[2]);
                break;
            case 4:
                System.out.println("Goodbye!");
                break;
            default:
                System.out.println("Invalid input!");
                break;
        }

        // Close the scanner
        scanner.close();
    }

    // Print the main menu
    static void printMenu() {
        System.out.println("Welcome to the Vehicle Store!");
        System.out.println("Please select a category:");
        System.out.println("1. Cars");
        System.out.println("2. Motorcycles");
        System.out.println("3. Other");
        System.out.println("4. Exit");
    }

    // Display a submenu and read the user input
    static int displaySubMenu(MenuSwitch menuSwitch) {
        Scanner scanner = new Scanner(System.in);
        int userInput = 0;

        switch (menuSwitch) {
            case CarsMenu:
                System.out.println("Please select a car:");
                System.out.println("1. Lamborghini Diablo SE30");
                System.out.println("2. Koenigsegg Jesko");
                System.out.println("3. Lamborghini Veneno");
                userInput = scanner.nextInt();
                break;
            case MotorcycleMenu:
                System.out.println("Please select a motorcycle:");
                System.out.println("1. Kawasaki ZX-10R");
                System.out.println("2. BMW M1000RR");
                System.out.println("3. Ducati Panigale V4");
                userInput = scanner.nextInt();
                break;
            case OtherMenu:
                System.out.println("Please select an option:");
                System.out.println("1. Boat");
                System.out.println("2. Airplane");
                System.out.println("3. Helicopter");
                userInput = scanner.nextInt();
                break;
        }

        scanner.close();

        return userInput;
    }
}
