import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Day1 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/InputFile");

        ArrayList<Integer> firstLocations = new ArrayList<Integer>();
        ArrayList<Integer> secondLocations = new ArrayList<Integer>();

        for (int i = 0; i < fileData.size(); i++) {
            String pair = fileData.get(i);
            String[] splitPair = pair.split("   ");
            firstLocations.add(Integer.parseInt(splitPair[0]));
            secondLocations.add(Integer.parseInt(splitPair[1]));
        }

        Collections.sort(firstLocations);
        Collections.sort(secondLocations);

        System.out.println("Part one: " + totalDistance(firstLocations, secondLocations));
        System.out.println("Part two: " + similarityScore(firstLocations, secondLocations));
    }

    public static int totalDistance(ArrayList<Integer> firstLocations, ArrayList<Integer> secondLocations) {
        int total = 0;
        for (int i = 0; i < firstLocations.size(); i++) {
            total += Math.abs(firstLocations.get(i) - secondLocations.get(i));
        }
        return total;
    }

    public static int similarityScore(ArrayList<Integer> firstLocations, ArrayList<Integer> secondLocations) {
        int totalScore = 0;
        for (int i = 0; i < firstLocations.size(); i++) {
            int firstNum = firstLocations.get(i);
            int appears = 0;
            for (int j = 0; j < secondLocations.size(); j++) {
                int secondNum = secondLocations.get(j);
                if (firstNum == secondNum) {
                    appears++;
                }
            }
            int score = appears * firstNum;
            totalScore += score;
        }
        return totalScore;
    }

    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
}