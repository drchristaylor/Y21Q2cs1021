package wk6;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileIO {
    public static void main(String[] args) throws FileNotFoundException {
        List<String> lines = new ArrayList<>();
        lines.add("fdghjkdidud");
        lines.add("dghjkdidud");
        lines.add("fghjkdidud");
        lines.add("fdhjkdidud");
        writeTextFile("example.txt", lines);
    }

    public static void writeTextFile(String filename, List<String> lines) throws FileNotFoundException {
        try (PrintWriter out = new PrintWriter(filename)) {
            for(String line : lines) {
                out.println(line);
            }
        }
    }

    public static List<String> readTextFile(String filename) throws IOException {
        List<String> lines = new ArrayList<>();
        try (InputStream istream = Files.newInputStream(Paths.get(filename));
             Scanner in = new Scanner(istream)) {
            while(in.hasNextLine()) {
                lines.add(in.nextLine());
            }
        }
        return lines;
    }
}
