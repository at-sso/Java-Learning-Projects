package home;

import java.util.Scanner;

// "The local variable may not have been initialized" -🤓
public class LoopHW {
    public static void main(String[] args) throws Exception {
        interface PrintLineTypedef {
            void printl(String string);
        }
        PrintLineTypedef sys = (string) -> {
            System.out.println(string);
        };
        Scanner scan = new Scanner(System.in);

        double examTimes = 2,
                investigationTimes = 5,
                schoolWorkshopTimes = 3,
                homeworkTimes = 5,
                finalProjectTimes = 1;

        double examTotal = 0,
                investigationTotal = 0,
                schoolWorkshopTotal = 0,
                homeworkTotal = 0,
                finalProjectTotal = 0;

        for (int i = 1; i <= examTimes; i++) {
            sys.printl("\nIngrese la nota de el examen numero, #" + i + ": ");
            examTotal += scan.nextDouble();
        }
        for (int j = 1; j <= investigationTimes; j++) {
            sys.printl("\nIngrese la nota de la investigacion numero, #" + j + ": ");
            investigationTotal += scan.nextDouble();
        }
        for (int k = 1; k <= schoolWorkshopTimes; k++) {
            sys.printl("\nIngrese la nota de el taller numero, #" + k + ": ");
            schoolWorkshopTotal += scan.nextDouble();
        }
        for (int l = 1; l <= homeworkTimes; l++) {
            sys.printl("\nIngrese la nota de la tarea numero, #" + l + ": ");
            homeworkTotal += scan.nextDouble();
        }
        for (int m = 1; m <= finalProjectTimes; m++) {
            sys.printl("\nIngrese la nota de el proyecto final: ");
            finalProjectTotal += scan.nextDouble();
        }

        double examAverage = examTotal / examTimes,
                investigationAverage = investigationTotal / investigationTimes,
                workshopAverage = schoolWorkshopTotal / schoolWorkshopTimes,
                homeworkAverage = homeworkTotal / homeworkTimes,
                finalProjectAvarage = finalProjectTotal / finalProjectTimes;

        double finalGrade = examAverage * 0.25
                + investigationAverage * 0.05
                + workshopAverage * 0.2
                + homeworkAverage * 0.2
                + finalProjectAvarage * 0.3;

        double finalGradeRounded = Math.round(finalGrade * 100.0) / 100.0;

        sys.printl("\nNota final: " + finalGradeRounded + "%");
        scan.close();
    }
}
// on some real funny stuff