import java.util.Scanner;
import java.io.File;


public class GradeHistogram {

    public static void main(String[] args) throws Exception {
        String filename = " ";
        String r = " ";
        int range;
        System.out.println("Grades loaded!");

        if (args.length == 1) {
            filename = args[0];
            System.out.println("What bucket size would you like?");
            Scanner input = new Scanner(System.in);
            // system.in for console input
            range = input.nextInt();
        } else {

            for (int p = 0; p < args.length; p++) {
                filename = args[0];
                r = args[1];
            } range = Integer.parseInt(r);
        }

        int[] countarray = new int[100 / range + 1];

        Scanner file = new Scanner(new File(filename));

        while (file.hasNext()) {
            String eachLine = file.nextLine();
            String[] parts = eachLine.split(",");
            String names = parts[0].trim();
            String grade = parts[1].trim();

            int grades = Integer.parseInt(grade);
            countarray[((100 - grades) / range) ]++; //counting
        }

        for (int i = 0; i < countarray.length; i++) {
            int end = 101 - i * range - range;
            if (i == 100 / range && end < 0) {
                end = 0;
            }

            System.out.printf("%3d - %2d | ", 100 - i * range , end);

            for (int j = 0; j < countarray[i]; j++) {
                System.out.printf("[]");
            }
            System.out.println();
        }
    }
}









