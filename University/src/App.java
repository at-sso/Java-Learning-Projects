import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int switchst, num1, num2, result;
        boolean whileLoop = true;

        Scanner scan = new Scanner(System.in);
        try {
            while (whileLoop == true) {
                System.out.println("1. Suma");
                System.out.println("2. Resta");
                System.out.println("3. Multiplicacion");
                System.out.println("0. Salir.");
                switchst = scan.nextInt();

                switch (switchst) {
                    case 0: {
                        System.out.println("Saliste.");
                        Thread.sleep(1000);
                        whileLoop = false;
                        break;
                    }
                    case 1: {
                        System.out.println("Suma.\n");
                        System.out.println("Numero 1: ");
                        num1 = scan.nextInt();
                        System.out.println("Numero 2: ");
                        num2 = scan.nextInt();
                        result = num1 + num2;
                        System.out.println("Resultado: " + result);
                        Thread.sleep(2000);
                        break;
                    }
                    case 2: {
                        System.out.println("Resta.\n");
                        System.out.println("Numero 1: ");
                        num1 = scan.nextInt();
                        System.out.println("Numero 2: ");
                        num2 = scan.nextInt();
                        result = num1 - num2;
                        System.out.println("Resultado: " + result);
                        Thread.sleep(2000);
                        break;
                    }
                    case 3: {
                        System.out.println("Multiplicacion.\n");
                        System.out.println("Numero 1: ");
                        num1 = scan.nextInt();
                        System.out.println("Numero 2: ");
                        num2 = scan.nextInt();
                        result = num1 * num2;
                        System.out.println("Resultado: " + result);
                        Thread.sleep(2000);
                        break;
                    }
                    default: {
                        System.out.println("Elija una opcion disponible!");
                        Thread.sleep(500);
                        break;
                    }
                } // switch (switchst) | end
            } // while (whileLoop == true) | end
        } finally {
            scan.close();
        }
    }
}
