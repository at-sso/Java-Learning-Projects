import java.util.Scanner;

public class switchcase {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        interface PrintLineTypedef {
            void printl(String string);
        }
        PrintLineTypedef sys = (string) -> System.out.println(string);

        boolean whileLoop = true;
        int selectionManager = 0;

        while (whileLoop == true) {
            sys.printl("Elija una temporada *censurado*" + "\n0. Salir" +
                    "\n1. Invierno" + "\n2. Primavera" +
                    "\n3. Verano" + "\n4. Otono");
            selectionManager = scan.nextInt();
            switch (selectionManager) {
                case 0:
                    whileLoop = false;
                    break;
                case 1:
                    sys.printl("\nDiciembre, Enero, Febrero.\n");
                    break;
                case 2:
                    sys.printl("\nMarzo, Abril, Mayo.\n");
                    break;
                case 3:
                    sys.printl("\nJunio, Julio, Agosto.\n");
                    break;
                case 4:
                    sys.printl("\nSeptiembre, Octubre, Noviembre.\n");
                default:
                    sys.printl("\nElija una opcion valida.\n");
                    break;
            }
        }
        scan.close();
    }
}
