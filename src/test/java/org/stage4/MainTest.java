package org.stage4;

import org.junit.jupiter.api.Test;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {


    //unit testing
    private String captureOutput(Runnable r) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream old = System.out;
        System.setOut(new PrintStream(out));
        r.run();
        System.setOut(old);
        return out.toString().trim();
    }

    @Test
    void mainEncrypt() {
        String[] args = {"-mode","enc","-key","5","-data","hello"};
        assertEquals("mjqqt", captureOutput(() -> Main.main(args)));
    }

    @Test
    void mainDecrypt() {
        String[] args = {"-mode","dec","-key","5","-data","mjqqt"};
        assertEquals("hello", captureOutput(() -> Main.main(args)));
    }

    @Test
    void defaultValuesUsed() {
        String[] args = {};
        assertEquals("", captureOutput(() -> Main.main(args)));
    }
}
