package org.stage2;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testMain() {
        String input = "hello\n5\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Main.main(new String[]{});

        assertEquals("mjqqt", out.toString().trim());
    }


    @Test
    void encryptNormal() {
        assertEquals("finydf", Main.encrypt("aditya", 5));
    }

    @Test
    void encryptWrap() {
        assertEquals("abc", Main.encrypt("xyz", 3));
    }

    @Test
    void encryptNonLowercaseIgnored() {
        assertEquals("ABC", Main.encrypt("ABC", 5));
    }
}
