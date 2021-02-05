package wk7;

import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Driver {
    // 1.0 + 0.0i, -2.3 - 5.0i, 0.0 + 3.0i, and 8.0 + 8.0i
    public static void main(String[] args) {
        Complex comp = new Complex(1);
        try (DataOutputStream out = new DataOutputStream(Files.newOutputStream(Paths.get("complex.bin")))) {
            comp.write(out);
            comp = new Complex(-2.3, -5);
            comp.write(out);
            comp = new Complex(0, 3);
            comp.write(out);
            comp = new Complex(8, 8);
            comp.write(out);

        } catch (IOException e) {
            System.out.println("Error writing complex objects.");
        }
    }
}
