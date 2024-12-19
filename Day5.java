import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day5 {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/InputFile.txt");
        ArrayList<Integer> rules = new ArrayList<>();
        ArrayList<int[]> produce = new ArrayList<int[]>();
        for (String line : fileData) {
            if (line.contains("|")) {
                String[] nums = line.split("|");
                int num1 = Integer.parseInt(nums[0]);
                int num2 = Integer.parseInt(nums[1]);
                rules.add(num1);
                rules.add(num2);
            }
        }

        for (String line: fileData) {
            if (line.contains(",")) {
                String[] nums = line.split(",");
                int[] convertedNums = new int[nums.length];
                for (int i = 0; i < nums.length; i++) {
                    convertedNums[i] = Integer.parseInt(nums[i]);
                }
                produce.add(convertedNums);
            }
        }

        for (int i = 0; i < rules.size(); i +=2) {
            int num1 = rules.get(i);
            int num2 = rules.get(i+1);
            for (int j = 0; j < produce.size(); j++) {
                
            }
        }
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
