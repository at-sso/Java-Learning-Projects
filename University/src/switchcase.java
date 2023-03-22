import java.util.Scanner;

public class switchcase {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        interface PrintLineTypedef {
            void print(String string);
        }
        PrintLineTypedef sys = (string) -> System.out.println(string);

        boolean whileLoop = true;
        int selectionManager = 0;

        while (whileLoop == true) {
            sys.print("Elija una temporada del *censurado*" + "\n0. Salir" +
                    "\n1. Invierno" + "\n2. Primavera" +
                    "\n3. Verano" + "\n4. Otono");
            selectionManager = scan.nextInt();
            switch (selectionManager) {
                case 0:
                    whileLoop = false;
                    break;
                case 1:
                    sys.print("\nDiciembre, Enero, Febrero.\n");
                    break;
                case 2:
                    sys.print("\nMarzo, Abril, Mayo.\n");
                    break;
                case 3:
                    sys.print("\nJunio, Julio, Agosto.\n");
                    break;
                case 4:
                    sys.print("\nSeptiembre, Octubre, Noviembre.\n");
                default:
                    sys.print("\nElija una opcion valida.\n");
                    break;
            }
        }
        scan.close();
    }
}
