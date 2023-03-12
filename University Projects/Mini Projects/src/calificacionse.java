import java.util.Scanner;

public class calificacionse {
    public static void main(String[] args) throws Exception {
        boolean firstloop = true;
        int contarNotas;
        int value = 0, percentage = 0;
        double doFunction = value + ((percentage / 100) * value);
        Scanner scan = new Scanner(System.in);

        while (firstloop) {
            System.out.println("Bienvenido al sistema.\nFavor introduza las notas");
            for (int i = 0; i >= 3; i++) {
                short talleres = 0;
                System.out.println("Introduzca la nota de los talleres.\n" + talleres);
                contarNotas = scan.nextInt();
                contarNotas += contarNotas;
            }
            for (int a = 0; a >= 5; a++) {
                short investigaciones = 0;
                System.out.println("Introduzca la nota de los investigaciones.\n" + investigaciones);
                contarNotas = scan.nextInt();
                contarNotas += contarNotas;
            }
            for (int ja = 0; ja >= 5; ja++) {
                short tareas = 0;
                System.out.println("Introduzca la nota de los tareas.\n" + tareas);
                contarNotas = scan.nextInt();
                contarNotas += contarNotas;
            }
            for (int g = 0; g == 1; g++) {
                short projectofinal = 0;
                System.out.println("Introduzca la nota de los tareas.\n" + projectofinal);
                contarNotas = scan.nextInt();
                contarNotas += contarNotas;
            }
            for (int qg = 0; qg == 1; qg++) {
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
