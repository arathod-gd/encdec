package org.stage6;

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
    void shiftEncryptMain() {
        String[] args = {"-mode","enc","-key","5","-data","hello"};
        assertEquals("mjqqt", captureOutput(() -> Main.main(args)));
    }

    @Test
    void shiftDecryptMain() {
        String[] args = {"-mode","dec","-key","5","-data","mjqqt"};
        assertEquals("hello", captureOutput(() -> Main.main(args)));
    }

    @Test
    void unicodeEncryptMain() {
        String[] args = {"-alg","unicode","-mode","enc","-key","1","-data","abc"};
        assertEquals("bcd", captureOutput(() -> Main.main(args)));
    }

    @Test
    void unicodeDecryptMain() {
        String[] args = {"-alg","unicode","-mode","dec","-key","1","-data","bcd"};
        assertEquals("abc", captureOutput(() -> Main.main(args)));
    }

    @Test
    void shiftUppercase() {
        assertEquals("DEF", Main.shiftEncrypt("ABC", 3));
    }

    @Test
    void fileUnicode() throws Exception {
        Path in = Files.createTempFile("in",".txt");
        Path out = Files.createTempFile("out",".txt");

        Files.writeString(in, "abc");

        String[] args = {
                "-alg","unicode",
                "-mode","enc",
                "-key","1",
                "-in", in.toString(),
                "-out", out.toString()
        };

        Main.main(args);
        assertEquals("bcd", Files.readString(out));
    }

    @Test
    void wrongArguments() {
        String[] args = {"-key"};
        String output = captureOutput(() -> Main.main(args));
        assertEquals("Error: wrong arguments", output);
    }
}
