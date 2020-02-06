import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Goat {
    public static void main(String[] args)throws IOException {
        Scanner scanner = new Scanner(new File("goat.dat"));
        int cases = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < cases; i++) {
            int numGoats = scanner.nextInt();
            scanner.nextLine();
            int[][] goats = new int[numGoats][];

            Scanner lineReader;
            for (int j = 0; j < numGoats; j++) {
                lineReader = new Scanner(scanner.nextLine());
                int cycleLength = lineReader.nextInt();
                goats[j] = new int[cycleLength];
                for (int k = 0; k < cycleLength; k++) {
                    goats[j][k] = lineReader.nextInt();
                }
            }

//            for (int j = 0; j < goats.length; j++) {
//                for (int k = 0; k < goats[j].length; k++) {
//                    System.out.print(goats[j][k]+ " ");
//                }
//                System.out.println();
//            }
            boolean simulationOver = false;
            int day = 0;
            int lastDay = 1;
            int previousLength = goats.length;
            int limit = 99;
            int count = 0;

            while(!simulationOver){

//                for (int j = 0; j < goats.length; j++) {
//                    if(goats[j] != null) {
//                        limit *= goats[j].length;
//                    }
//                }

                day++;
                int lowest = 99;
                int lowestIndex = 0;
                boolean tie = false;
                for (int j = 0; j < goats.length; j++) {
                    if(goats[j] == null){
                        continue;
                    }
                    if(goats[j][day % goats[j].length] < lowest){
                        tie = false;
                        lowest = goats[j][day % goats[j].length];
                        lowestIndex = j;
                    }
                    else if(goats[j][day % goats[j].length] == lowest){
                        tie = true;
                    }
                }
                if(!tie){
                    goats[lowestIndex] = null;
                    lastDay = day + 1;
                }
                int length = 0;
                for (int j = 0; j < goats.length; j++) {
                    if(goats[j] != null){
                        length++;
                    }
                }
                if(length == 0){
                    System.out.println(0 + " " + lastDay);
                    simulationOver = true;
                }
                if (count >= limit){
                    simulationOver = true;
                    System.out.println(length+ " " + (lastDay));
                }
                if(length == previousLength){
                    count++;
                    //System.out.println(count);
                }
                else {
                    count = 0;
                }
                previousLength = length;
            }


        }
    }

}
