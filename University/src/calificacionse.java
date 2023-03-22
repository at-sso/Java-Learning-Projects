import java.util.Scanner;

public class calificacionse {
    public static void main(String[] args) throws Exception {
        boolean firstloop = true;
        int contarNotas;
        int value = 0, percentage = 0;
        double doFunction = value + ((percentage / 100) * value);
        Scanner scan = new Scanner(System.in);

        while (firstloop) {
            System.out.println("Bienvenido al sistema de calificaciones.\nFavor introduza las notas");
            for (int i = 0; i >= 3; i++) {
                short talleres = 0;
                System.out.println("Introduzca la nota de los talleres.\n" + talleres);
                contarNotas = scan.nextInt();
                contarNotas += contarNotas;
            }
            for (int j = 0; j >= 5; j++) {
                short investigaciones = 0;
                System.out.println("Introduzca la nota de los investigaciones.\n" + investigaciones);
                contarNotas = scan.nextInt();
                contarNotas += contarNotas;
            }
            for (int k = 0; k >= 5; k++) {
                short tareas = 0;
                System.out.println("Introduzca la nota de los tareas.\n" + tareas);
                contarNotas = scan.nextInt();
                contarNotas += contarNotas;
            }
            for (int l = 0; l == 1; l++) {
                short projectofinal = 0;
                System.out.println("Introduzca la nota de los tareas.\n" + projectofinal);
                contarNotas = scan.nextInt();
                contarNotas += contarNotas;
            }
            for (int m = 0; m == 1; m++) {
                short projectofinal = 0;
                System.out.println("Introduzca la nota de los tareas.\n" + projectofinal);
                contarNotas = scan.nextInt();
                contarNotas += contarNotas;
            }
            System.out.print("nota final: " + doFunction);
            scan.close();
        }
    }
}
