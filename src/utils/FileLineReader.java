package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileLineReader {
    private Scanner scanner = null;

    public FileLineReader(String fileName) {
        try {
            scanner = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Read the next non-empty line from the file, one line at a time.
    // If the line is empty, skip it and read the next line.
    // If there are no more lines, return null.
    public String readLine() {
        if (scanner == null) {
            return null;
        }

        String line = null;
        while (true) {
            if (scanner.hasNextLine()) {
                line = scanner.nextLine().trim();
                if (!line.isEmpty()) {
                    break;
                }
            } else {
                scanner.close();
                scanner = null;
                line = null;
                break;
            }
        }

        return line;
    }
}

