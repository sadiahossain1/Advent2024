import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day4 {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/InputFile");
        int rows = fileData.size();
        int columns = fileData.get(0).length();
        String[][] grid = new String[rows][columns];
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                grid[r][c] = fileData.get(r).substring(c, c+1);
            }
        }

        int total = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (checkXMASUp(grid, r, c)) {
                    total++;
                }
                if (checkXMASDown(grid, r, c)) {
                    total++;
                }
                if (checkXMASLeft(grid, r, c)) {
                    total++;
                }
                if (checkXMASRight(grid, r, c)) {
                    total++;
                }
                if (checkXMASUpLeft(grid, r, c)) {
                    total++;
                }
                if (checkXMASUpRight(grid, r, c)) {
                    total++;
                }
                if (checkXMASDownLeft(grid, r, c)) {
                    total++;
                }
                if (checkXMASDownRight(grid, r, c)) {
                    total++;
                }
            }
        }

        System.out.println("Part One: " + total);

    }

    public static boolean checkXMASUp(String[][] grid, int r, int c) {
        try {
            String x = grid[r][c];
            String m = grid[r-1][c];
            String a = grid[r-2][c];
            String s = grid[r-3][c];
            String word = x + m + a + s;
            if (word.equals("XMAS"))
                return true;
            else
                return false;
        }
        catch (Exception e) {
            return false;
        }
    }

    public static boolean checkXMASDown(String[][] grid, int r, int c) {
        try {
            String x = grid[r][c];
            String m = grid[r+1][c];
            String a = grid[r+2][c];
            String s = grid[r+3][c];
            String word = x + m + a + s;
            if (word.equals("XMAS"))
                return true;
            else
                return false;
        }
        catch (Exception e) {
            return false;
        }
    }

    public static boolean checkXMASLeft(String[][] grid, int r, int c) {
        try {
            String x = grid[r][c];
            String m = grid[r][c-1];
            String a = grid[r][c-2];
            String s = grid[r][c-3];
            String word = x + m + a + s;
            if (word.equals("XMAS"))
                return true;
            else
                return false;
        }
        catch (Exception e) {
            return false;
        }
    }

    public static boolean checkXMASRight(String[][] grid, int r, int c) {
        try {
            String x = grid[r][c];
            String m = grid[r][c+1];
            String a = grid[r][c+2];
            String s = grid[r][c+3];
            String word = x + m + a + s;
            if (word.equals("XMAS"))
                return true;
            else
                return false;
        }
        catch (Exception e) {
            return false;
        }
    }

    public static boolean checkXMASUpLeft(String[][] grid, int r, int c) {
        try {
            String x = grid[r][c];
            String m = grid[r-1][c-1];
            String a = grid[r-2][c-2];
            String s = grid[r-3][c-3];
            String word = x + m + a + s;
            if (word.equals("XMAS"))
                return true;
            else
                return false;
        }
        catch (Exception e) {
            return false;
        }
    }

    public static boolean checkXMASUpRight(String[][] grid, int r, int c) {
        try {
            String x = grid[r][c];
            String m = grid[r-1][c+1];
            String a = grid[r-2][c+2];
            String s = grid[r-3][c+3];
            String word = x + m + a + s;
            if (word.equals("XMAS"))
                return true;
            else
                return false;
        }
        catch (Exception e) {
            return false;
        }
    }

    public static boolean checkXMASDownLeft(String[][] grid, int r, int c) {
        try {
            String x = grid[r][c];
            String m = grid[r+1][c-1];
            String a = grid[r+2][c-2];
            String s = grid[r+3][c-3];
            String word = x + m + a + s;
            if (word.equals("XMAS"))
                return true;
            else
                return false;
        }
        catch (Exception e) {
            return false;
        }
    }

    public static boolean checkXMASDownRight(String[][] grid, int r, int c) {
        try {
            String x = grid[r][c];
            String m = grid[r+1][c+1];
            String a = grid[r+2][c+2];
            String s = grid[r+3][c+3];
            String word = x + m + a + s;
            if (word.equals("XMAS"))
                return true;
            else
                return false;
        }
        catch (Exception e) {
            return false;
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
