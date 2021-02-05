package wk8;

import wk7.Complex;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Driver {
    public static void main(String[] args) throws IOException {
        System.out.println(Files.lines(Paths.get("complexities.txt"))
                .map(line -> new Complex(line))
                .mapToDouble(comp -> comp.getAngle())
                .average());
    }
}
