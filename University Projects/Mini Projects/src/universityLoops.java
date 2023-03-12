import java.util.Scanner;

public class universityLoops {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int numValue = 1;
        do {
            System.out.println("Ingresar valor del 0 al 999.");
            numValue = scan.nextInt();

            if (numValue >= 100) {
                System.out.println("El numero tiene 3 digitos.");
            } else {
                if (numValue >= 10) {
                    System.out.println("El numero tiene 2 digitos.");
                } else {
                    System.out.println("El valor tiene un digito.");
                }
            }
        } while (numValue != 0);
        scan.close();
    }
}
