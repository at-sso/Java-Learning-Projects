package test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Lecar {

    public static void clearScreen() throws IOException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }

    public class MainExecution {
        private int[] ReadSwitchValue = { 0, 0, 0 };
        private boolean enableFunction = false;
        private String finalPriceReadable = "";
        private double finalValueFixed = 0.0;
        private Map<String, Integer> confirmationMap = new HashMap<String, Integer>() {
            {
                put("y", 1);
                put("n", 2);
            }
        };

        private enum menuSwitchEnum {
            CarsMenu,
            MotorcycleMenu,
            PlaneMenu
        }

        private menuSwitchEnum EnumSwitchArray;

        public void clearFinalData() {
            finalPriceReadable = "";
            finalValueFixed = 0.0;
            enableFunction = false;
            for (int i = 0; i < 6; i++) {
                ReadSwitchValue[i] = 0;
            }
        }

        public double fixFinalPrice(String numeralValue) {
            String cleanedValue = numeralValue.replaceAll("\\D", "");
            if (!cleanedValue.isEmpty()) {
                finalValueFixed = Double.parseDouble(cleanedValue);
            }
            return finalValueFixed;
        }

        public boolean continueFunction(String confirmationString) {
            confirmationString = confirmationString.toLowerCase();
            if (!confirmationMap.containsKey(confirmationString) || confirmationMap.get(confirmationString) != 1) {
                System.err.println("Function canceled.\n");
                return enableFunction = false;
            } else {
                System.out.println("Function started.\n");
                return enableFunction = true;
            }
        }

        public void switchErrorMsg() {
            System.err.println("Enum member out of bounds.");
            try {
                System.in.read();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public double CalculatePrice(double LimitX, double LimitY, double inputPrice) {
            if (enableFunction != true) {
                return -1;
            }
            if (inputPrice < LimitX) {
                System.out.println("Price is below the range.");
                try {
                    System.in.read();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return -1;
            }

            boolean withinRange = (inputPrice >= LimitX && inputPrice <= LimitY);
            System.out.println("Price is " + (withinRange ? "" : "not ") + "within the range.");
            try {
                System.in.read();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return withinRange ? 1 : 0;
        }
    }

    enum menuSwitchEnum {
        CarsMenu,
        MotorcycleMenu,
        PlaneMenu
    }

    class MainExecution {
        int[] ReadSwitchValue = { 0, 0, 0 };
        Scanner scanner = new Scanner(System.in);

        void clearScreen() {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }

        void CarMenu() // use array [0]
        {
            clearScreen();
            System.out.println("Avaible Cars:\n" + "1. \"Lamborghini Diablo SE30\"\n"
                    + "2. \"Koenigsegg Jesko\"\n" + "3. \"Lamborghini Veneno\"\n" + "* End *\n");

            ReadSwitchValue[0] = scanner.nextInt();

            EXECUTE_SWITCH(menuSwitchEnum.CarsMenu);
        }

        void MotorcycleMenu() // use array [1]
        {
            clearScreen();
            System.out.println("Avaible Motorcycles:\n" + "1. \"Kawasaki ZX-10R\"\n"
                    + "1. \"Yamaha YZF-R1 60th Anniversary\"\n" + "1. \"2022 BMW M1000RR\"\n" + "* End *\n");

            ReadSwitchValue[1] = scanner.nextInt();

            EXECUTE_SWITCH(menuSwitchEnum.MotorcycleMenu);
        }

        void AirplaneMenu() // use array [2]
        {
            clearScreen();
            System.out.println("Avaible Airplanes:\n" + "1. \"F-22 Raptor\"\n" + "2. \"Air Force One 747-8\"\n"
                    + "3. \"B-2 Spirit\"\n" + "* End *\n");

            ReadSwitchValue[2] = scanner.nextInt();

            EXECUTE_SWITCH(menuSwitchEnum.PlaneMenu);
        }

        void EXECUTE_SWITCH(menuSwitchEnum value) {
            switch (value) {
                case CarsMenu:
                    System.out.println("Selected Car: " + ReadSwitchValue[0]);
                    break;
                case MotorcycleMenu:
                    System.out.println("Selected Motorcycle: " + ReadSwitchValue[1]);
                    break;
                case PlaneMenu:
                    System.out.println("Selected Airplane: " + ReadSwitchValue[2]);
                    break;
            }
            scanner.nextLine(); // Consume newline left-over
            scanner.nextLine(); // Wait for user input before returning to main menu
        }
    }

    public class Main {
        static MainExecution mainExe = new MainExecution();

        public static void main(String[] args) {
            int mainSwitch = 0;
            Scanner scanner = new Scanner(System.in);

            while (true) {
                mainExe.clearScreen();

                System.out.println("Welcome to LeCar Shop.\n" + "Choose a vehicle.\n" + "0. Exit.\n" + "1. Car.\n"
                        + "2. Motorcycle.\n" + "3. Airplane.\n");

                mainSwitch = scanner.nextInt();

                switch (mainSwitch) {
                    case 0:
                        scanner.close();
                        return;
                    case 1: // car
                        mainExe.CarMenu();
                        break;
                    case 2: // motorcycle
                        mainExe.MotorcycleMenu();
                        break;
                    case 3: // air plane
                        mainExe.AirplaneMenu();
                        break;
                    default:
                        break;
                }
            }
        }
    }
}