package org.stage5;

import org.junit.jupiter.api.Test;
import java.io.*;
import java.nio.file.*;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private String captureOutput(Runnable r) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream old = System.out;
        System.setOut(new PrintStream(out));
        r.run();
        System.setOut(old);
        return out.toString().trim();
    }

    @Test
    void encryptWithData() {
        String[] args = {"-mode","enc","-key","5","-data","hello"};
        assertEquals("mjqqt", captureOutput(() -> Main.main(args)));
    }

    @Test
    void encryptFromFile() throws Exception {
        Path in = Files.createTempFile("in",".txt");
        Path out = Files.createTempFile("out",".txt");

        Files.writeString(in, "hello");

        String[] args = {
                "-mode","enc",
                "-key","5",
                "-in", in.toString(),
                "-out", out.toString()
        };

        Main.main(args);
        assertEquals("mjqqt", Files.readString(out));
    }

    @Test
    void wrongInputFile() {
        String[] args = {"-in","not_exist.txt"};
        String output = captureOutput(() -> Main.main(args));
        assertEquals("Error: input file not found", output);
    }

    @Test
    void wrongArguments() {
        String[] args = {"-key"};
        String output = captureOutput(() -> Main.main(args));
        assertEquals("Error: wrong arguments", output);
    }
}
