package org.stage5;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {

        String mode = "enc";
        int key = 0;
        String data = "";
        String inFile = null;
        String outFile = null;

        // Parse arguments
        try {
            for (int i = 0; i < args.length; i++) {
                switch (args[i]) {
                    case "-mode":
                        mode = args[i + 1];
                        break;
                    case "-key":
                        key = Integer.parseInt(args[i + 1]);
                        break;
                    case "-data":
                        data = args[i + 1];
                        break;
                    case "-in":
                        inFile = args[i + 1];
                        break;
                    case "-out":
                        outFile = args[i + 1];
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("Error: wrong arguments");
            return;
        }

        // Read from file if -data not provided
        if (data.equals("") && inFile != null) {
            try {
                data = Files.readString(Path.of(inFile));
            } catch (IOException e) {
                System.out.println("Error: input file not found");
                return;
            }
        }

        // Encrypt / Decrypt (UNICODE)
        String result;
        if (mode.equals("enc")) {
            result = encrypt(data, key);
        } else {
            result = decrypt(data, key);
        }

        // Output
        if (outFile != null) {
            try (FileWriter writer = new FileWriter(outFile)) {
                writer.write(result);
            } catch (IOException e) {
                System.out.println("Error: cannot write to output file");
            }
        } else {
            System.out.println(result);
        }
    }

    // ---------- UNICODE ----------
    public static String encrypt(String text, int key) {
        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) (chars[i] + key);
        }
        return new String(chars);
    }

    public static String decrypt(String text, int key) {
        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) (chars[i] - key);
        }
        return new String(chars);
    }
}
