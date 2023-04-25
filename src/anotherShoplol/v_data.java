package anotherShoplol;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class v_data {
    // Custom exception.
    public static class InvalidInputException extends Exception {
        public InvalidInputException(String message) {
            super(message);
        }
    }

    public static final void clearScreen() {
        System.out.print("\r\033[2J\033[H");
    }

    private static final Scanner scanner = new Scanner(System.in);

    static int OBTAIN_EXECUTION;
    static boolean enableFunction;
    static double finalValueFixed = 0.0;

    // Get confirmation map.
    private static final Map<String, Integer> confirmationMap = new HashMap<String, Integer>() {
        {
            put("y", 1);
            put("n", 2);
            put("yes", 1);
            put("no", 2);
        }
    };

    // Fix string input ex: "1,000".
    private static double fixSimpleValue(String string) throws InvalidInputException {
        try {
            String cleanedValue = string.replaceAll("[^\\d.]", "");
            if (!cleanedValue.isEmpty()) {
                finalValueFixed = Double.parseDouble(cleanedValue);
                return finalValueFixed;
            }
        } catch (Exception e) {
            System.err.println(e.toString());
            throw new InvalidInputException("Invalid input.");
        }
        return 0.0;
    }

    // Set string value to local double "finalValueFixed".
    private static double calculatePrice(double limitX, double limitY, double inputPrice) {
        if (inputPrice < limitX) {
            System.out.println("Price is below the range.");
            return -1;
        }
        boolean withinRange = (inputPrice >= limitX && inputPrice <= limitY);
        System.out.println("Price is " + (withinRange ? "" : "not ") + "within the range.");
        return withinRange ? 1 : 0;
    }

    // Confirm transaction.
    private static boolean continueTransaction(String confirmationString) throws InvalidInputException {
        try {
            confirmationString = confirmationString.toLowerCase();
            if (!confirmationMap.containsKey(confirmationString)) {
                System.err.println("Transaction canceled.\n");
                enableFunction = false;
                return false;
            }
            System.out.println("Transaction started.\n");
            enableFunction = true;
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw new InvalidInputException("Invalid input.");
        }
    }

    public static class INITIALIZE_FUNC {
        public static final void GET_FIXED_MENU(final int withinCase)
                throws InvalidInputException, InterruptedException {
            clearScreen();
            switch (withinCase) {
                case 0:
                    System.out.println("Available Cars:\n" + "1. \"Lamborghini Diablo SE30\"\n"
                            + "2. \"Koenigsegg Jesko\"\n" + "3. \"Lamborghini Veneno\"\n" + "* End *\n");
                    OBTAIN_EXECUTION = scanner.nextInt();
                    GET_MAIN_EXECUTION.FROM_CARS();
                    break;
                case 1:
                    System.out.println("Available Motorcycles:\n" + "1. \"Kawasaki ZX-10R\"\n"
                            + "2. \"Yamaha YZF-R1 60th Anniversary\"\n" + "3. \"2022 BMW M1000RR\"\n" + "* End *\n");
                    OBTAIN_EXECUTION = scanner.nextInt();
                    GET_MAIN_EXECUTION.FROM_MOTORCYCLE();
                    break;
                case 2:
                    System.out.println("Available Airplanes:\n" + "1. \"F-22 Raptor\"\n"
                            + "2. \"Air Force One 747-8\"\n" + "3. \"B-2 Spirit\"\n" + "* End *\n");
                    OBTAIN_EXECUTION = scanner.nextInt();
                    GET_MAIN_EXECUTION.FROM_PLANE();
                    break;
            }
        }
    } // INITIALIZE_FUNC

    private static class GET_MAIN_EXECUTION {
        private static String returnConfirmation;
        private static String readFinalPrice;

        private static final String RETURN_MAIN_STRING(int index) {
            String mainString;
            switch (index) {
                case 1:
                    mainString = "- From Wikipedia, the free encyclopedia.\n\n" +
                            "The Lamborghini Diablo is a high-performance mid-engine sports car built by Italian\n" +
                            "automobile manufacturer Lamborghini between 1990 and 2001. It is the first production Lamborghini\n"
                            +
                            "capable of attaining a top speed in excess of 320 kilometres per hour (200 mph).\n\n";
                    return mainString;
                case 2:
                    mainString = "- From Wikipedia, the free encyclopedia.\n\n" +
                            "The Koenigsegg Jesko is a limited production mid-engine sports car produced by Swedish automobile\n"
                            +
                            "manufacturer Koenigsegg. The car was introduced at the 2019 Geneva Motor Show and it completely sold"
                            +
                            "out before the 2019 Geneva Motor Show ended. The car succeeds the Agera. The name Jesko is a tribute to\n"
                            +
                            "the company founder's father, Jesko von Koenigsegg.\n" +
                            "There are two variations of the car \"Absolut\" (top speed) and \"Attack\" (track-focused).\n\n";
                    return mainString;
                case 3:
                    mainString = "- From Wikipedia, the free encyclopedia\n\n" +
                            "The Lamborghini Veneno is a limited production high performance sports car manufactured\n"
                            +
                            "by Italian automobile manufacturer Lamborghini. Based on the Lamborghini Aventador,\n" +
                            "the Veneno was developed to celebrate Lamborghini's 50th anniversary. It was introduced\n"
                            +
                            "at the 2013 Geneva Motor Show. When introduced, it had a price of US$4,000,000, making it one"
                            +
                            "of the most expensive production cars in the world.\n\n";
                    return mainString;
                case 4:
                    mainString = "- From Web Bike World.\n\n" +
                            "BMW fully expects buyers of the M1000RR to be track day enthusiasts and has catered specifically to them.\n"
                            +
                            "You get the first BMW motorcycle to bear the M-Division designation, with fairings made from carbon fiber,\n"
                            +
                            "carbon fiber aerodynamic winglets, M carbon wheels, a milled, lightweight monoblock aluminum swingarm, M carbon brakes,\n"
                            +
                            "100% pure titanium exhaust made in concert with Akrapovic, an M-Division ECU and IMU with multiple ride modes, and\n"
                            +
                            "so much more that it'd take a novel to list them.\n\n";
                    return mainString;
                case 5:
                    mainString = "- From Web Bike World.\n\n" +
                            "As with every other year, Yamaha Motorcycles continues to evolve and perfect the supersport formula, with lessons\n"
                            +
                            "learned from the track in both MotoGP and MotoAmerica Supersport 1000cc racing. 2022's evolution includes a mildly reworked\n"
                            +
                            "clutch with even better slip and assist for launches, as well as 0.1 inches more travel in the front KYB inverted forks,\n"
                            +
                            "up from 4.6 to 4.7 inches to make the front not quite as snappy over bumps and rougher roads.\n\n";
                    return mainString;
                case 6:
                    mainString = "- From Web Bike World.\n\n" +
                            "Introduced in late 2021 as a 2022 model, the BMW M1000RR is one of those examples of the Germans taking something that was already\n"
                            +
                            "superb, the S1000RR, and then making it damned near perfect. While the S1000RR is based on the BMW race bikes in the World SBK\n"
                            +
                            "championship, the M1000RR is an almost 1-to-1 replica of the race bike, with only a few considerations for street legality added in.\n\n";
                    return mainString;
                case 7:
                    mainString = "- From Finances Online.\n" +
                            "Considered one of the world's best fighter planes, the Raptor was built to combat Russia's sophisticated SU Flanker and MIG Fulcrum aircraft.\n"
                            +
                            "Its production was initiated in the 1980s to meet the Russian threat during the cold war. When the danger passed, production was halted and a total\n"
                            +
                            "187 Raptors have been provided to the US military.\n" +
                            "The Raptor is a stealth, all-weather, twin-engine, single-seat, fifth-generation aircraft designed for the US Air Force. It boasts signal intelligence,\n"
                            +
                            "electronic warfare, and ground attack capabilities, and is used mainly as an air superiority fighter. The plane's weapons systems and airframe were built\n"
                            +
                            "by Lockheed Martin, while Boeing supplied the training systems, avionics integration, aft fuselage, and wings.\n\n";
                    return mainString;
                case 8:
                    mainString = "- From Finances Online.\n" +
                            "Air Force One is a triple decker with 4,000 square feet of space. This gives all passengers plenty of leg room to stretch their legs.\n"
                            +
                            "The plane can easily hit a speed of 650 miles per hour. For medical emergencies, there is a mini hospital on board with specialist\n"
                            +
                            "doctors and an operation theater. The aircraft is equipped to survive meteor strikes, earthquake, and nuclear war. In case of an attack,\n"
                            +
                            "it deploy flares to counter heat-seeking missiles, ECM (electronic countermeasures), and radar-jamming technology. The plane has mid-air\n"
                            +
                            "refueling abilities and can be refueled even at 35,000 feet. However, President Donald Trump wishes to get rid of this facility to save money.\n\n";
                    return mainString;
                case 9:
                    mainString = "- From Finances Online.\n" +
                            "The B-2 Spirit was launched in 1989. The program to develop it was initiated during the Carter administration in the late 1970s.\n"
                            +
                            "Northrop was chosen to build this fighter plane. The highlight of its design is a technique called “continuous curvature” which deflects radar.\n"
                            +
                            "In fact, its radar cross-section is just 1.1 square feet - the size of a pigeon. The bomber was first deployed in action in the Kosovo War in\n"
                            +
                            "1989 where it flew 50 sorties.\n\n";
                    return mainString;
                default:
                    return null;
            }
        }

        public static void FROM_CARS() throws InvalidInputException, InterruptedException {
            switch (OBTAIN_EXECUTION) {
                case 1:
                    RETURN_MAIN_STRING(1);
                    System.out.println("Do you want to buy this vehicle? [y/n]\n");
                    returnConfirmation = scanner.next();
                    if (continueTransaction(returnConfirmation) != true) {
                        return;
                    }
                    scanner.nextLine();
                    System.out.println("How much are you willing to pay within the following price range:\n" +
                            "$224,454 - $1,300,000\n");
                    readFinalPrice = scanner.nextLine();
                    fixSimpleValue(readFinalPrice);
                    calculatePrice(224454D, 1300000D, finalValueFixed);
                    break;
                case 2:
                    RETURN_MAIN_STRING(2);
                    System.out.println("Do you want to buy this vehicle? [y/n]\n");
                    returnConfirmation = scanner.next();
                    if (continueTransaction(returnConfirmation) != true) {
                        return;
                    }
                    scanner.nextLine();
                    System.out.println("How much are you willing to pay within the following price range:\n" +
                            "$3,000,000 - $3,400,000\n");
                    readFinalPrice = scanner.nextLine();
                    calculatePrice(3000000D, 3400000D, finalValueFixed);
                    break;
                case 3:
                    RETURN_MAIN_STRING(3);
                    System.out.println("Do you want to buy this vehicle? [y/n]\n");
                    returnConfirmation = scanner.nextLine();
                    if (continueTransaction(returnConfirmation) != true) {
                        return;
                    }
                    scanner.nextLine();
                    System.out.println("How much are you willing to pay within the following price range:\n" +
                            "$3,500,000 - $4,000,000\n");
                    readFinalPrice = scanner.nextLine();
                    calculatePrice(3500000D, 4000000D, finalValueFixed);
                    break;
            }
            Thread.sleep(1000);
            return;
        }

        public static void FROM_MOTORCYCLE() throws InvalidInputException, InterruptedException {
            switch (OBTAIN_EXECUTION) {
                case 1:
                    RETURN_MAIN_STRING(4);
                    System.out.println("Do you want to buy this vehicle? [y/n]\n");
                    returnConfirmation = scanner.nextLine();
                    if (continueTransaction(returnConfirmation) != true) {
                        return;
                    }
                    scanner.nextLine();
                    System.out.println("How much are you willing to pay within the following price range:\n" +
                            "$32,995 - $36,995\n");
                    readFinalPrice = scanner.nextLine();
                    fixSimpleValue(readFinalPrice);
                    calculatePrice(32995D, 36995D, finalValueFixed);
                    break;
                case 2:
                    RETURN_MAIN_STRING(5);
                    System.out.println("Do you want to buy this vehicle? [y/n]\n");
                    returnConfirmation = scanner.nextLine();
                    if (continueTransaction(returnConfirmation) != true) {
                        return;
                    }
                    scanner.nextLine();
                    System.out.println("How much are you willing to pay within the following price range:\n" +
                            "$17,599 - $26,299\n");
                    readFinalPrice = scanner.nextLine();
                    calculatePrice(17599D, 26299D, finalValueFixed);
                    break;
                case 3:
                    RETURN_MAIN_STRING(6);
                    System.out.println("Do you want to buy this vehicle? [y/n]\n");
                    returnConfirmation = scanner.nextLine();
                    if (continueTransaction(returnConfirmation) != true) {
                        return;
                    }
                    scanner.nextLine();
                    System.out.println("How much are you willing to pay within the following price range:\n" +
                            "$16,399 - $17,699\n");
                    readFinalPrice = scanner.nextLine();
                    calculatePrice(16399D, 17699D, finalValueFixed);
                    break;
            }
            Thread.sleep(1000);
            return;
        }

        public static void FROM_PLANE() throws InvalidInputException, InterruptedException {
            switch (OBTAIN_EXECUTION) {
                case 1:
                    RETURN_MAIN_STRING(7);
                    System.out.println("Do you want to buy this vehicle? [y/n]\n");
                    returnConfirmation = scanner.nextLine();
                    if (continueTransaction(returnConfirmation) != true) {
                        return;
                    }
                    scanner.nextLine();
                    System.out.println("How much are you willing to pay within the following price range:\n" +
                            "$143,000,000 - $350,000,000\n");
                    readFinalPrice = scanner.nextLine();
                    fixSimpleValue(readFinalPrice);
                    calculatePrice(143000000D, 350000000D, finalValueFixed);
                    break;
                case 2:
                    RETURN_MAIN_STRING(8);
                    System.out.println("Do you want to buy this vehicle? [y/n]\n");
                    returnConfirmation = scanner.nextLine();
                    if (continueTransaction(returnConfirmation) != true) {
                        return;
                    }
                    scanner.nextLine();
                    System.out.println("How much are you willing to pay within the following price range:\n" +
                            "$3,900,000,000 - $4,000,000,000\n");
                    readFinalPrice = scanner.nextLine();
                    calculatePrice(3900000000D, 4000000000D, finalValueFixed);
                    break;
                case 3:
                    RETURN_MAIN_STRING(9);
                    System.out.println("Do you want to buy this vehicle? [y/n]\n");
                    returnConfirmation = scanner.nextLine();
                    if (continueTransaction(returnConfirmation) != true) {
                        return;
                    }
                    scanner.nextLine();
                    System.out.println("How much are you willing to pay within the following price range:\n" +
                            "$1,173,000,000 - $15,480,000,000\n");
                    readFinalPrice = scanner.nextLine();
                    calculatePrice(1173000000D, 15480000000D, finalValueFixed);
                    break;
            }
            Thread.sleep(1000);
            return;
        }
    }
}