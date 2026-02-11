package org.stage3;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {


    //unit testing

    @Test
    void testEnc() {
        String input = "enc\nhello\n5\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Main.main(new String[]{});

        assertEquals("mjqqt", out.toString().trim());
    }


    @Test
    void testDec() {
        String input = "dec\nmjqqt\n5\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Main.main(new String[]{});

        assertEquals("hello", out.toString().trim());
    }



    @Test
    void encrypt() {
        assertEquals("mjqqt", Main.encrypt("hello", 5));
    }

    @Test
    void decrypt() {
        assertEquals("hello", Main.decrypt("mjqqt", 5));
    }

    @Test
    void encryptEmpty() {
        assertEquals("", Main.encrypt("", 5));
    }
}
