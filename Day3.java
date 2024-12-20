import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/InputFile");
        int total = 0;
        String fullInput = "";
        for (String line : fileData) {
            fullInput += line;
        }
        ArrayList<String> allMatches = new ArrayList<String>();
        ArrayList<String> allMatches2 = new ArrayList<String>();
        String regex = "mul\\([1-9]{1}[0-9]{0,2},[1-9]{1}[0-9]{0,2}\\)";
        String regex2 = "mul\\([1-9][0-9]{0,2},[1-9][0-9]{0,2}\\)|do\\(\\)|don't\\(\\)";
        Matcher m = Pattern.compile(regex).matcher(fullInput);
        Matcher m2 = Pattern.compile(regex2).matcher(fullInput);
        while (m.find()) {
            allMatches.add(m.group());
        }
        while (m2.find()) {
            allMatches2.add(m2.group());
        }
        for (int i = 0; i < allMatches.size(); i++) {
            String one = allMatches.get(i).substring(4, allMatches.get(i).indexOf(","));
            String two = allMatches.get(i).substring(allMatches.get(i).indexOf(",")+1, allMatches.get(i).indexOf(")"));
            int num1 = Integer.parseInt(one);
            int num2 = Integer.parseInt(two);
            int product = num1 * num2;
            total += product;
        }
        int total2 = 0;
        boolean process = true;
        for (String cuts : allMatches2) {
            if (cuts.equals("don't()")) {
                process = false;
            } else if (cuts.equals("do()")) {
                process = true;
            } else if (cuts.contains("mul") && process) {
                int openParenthesis = cuts.indexOf("(");
                int comma = cuts.indexOf(",");
                int closeParenthesis = cuts.indexOf(")");
                String firstNum = cuts.substring(openParenthesis+1, comma);
                String secondNum = cuts.substring(comma+1, closeParenthesis);
                total2 += Integer.parseInt(firstNum) * Integer.parseInt(secondNum);
            }
        }


        System.out.println("Part one answer: " + total);
        System.out.println("Part two answer: " + total2);

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