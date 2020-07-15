package ptd.common.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileUtils {

    public static String readLine(String filePath, int lineIndex) throws Exception {
        File f = new File(filePath);
        Scanner scanner = null;
        try {
            scanner = new Scanner(f);
            if (canRead(f)) {
                int i = 0;
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    if (i == lineIndex) return line;
                    i++;
                }
            }
        } catch (Exception e) {
            throw e;
        } finally {
            scanner.close();
            return null;
        }
    }

    public static String[] readAllLine(String filePath) throws Exception {
        ArrayList<String> arr = new ArrayList<>();
        File f = new File(filePath);
        Scanner scanner = null;
        try {
            if (canRead(f)) {
                scanner = new Scanner(f);
                while (scanner.hasNextLine()) {
                    arr.add(scanner.nextLine());
                }
                scanner.close();
            }
            String[] lines = new String[arr.size()];
            return arr.toArray(lines);
        } catch (Exception e) {
            throw e;
        } finally {
            scanner.close();
            return null;
        }
    }

    public static boolean canRead(File file) {
        return (file.isFile() && file.exists() && file.canRead());
    }
}
