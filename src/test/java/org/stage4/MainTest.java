package org.stage4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void mainEncrypt() {
        String[] args = {"-mode", "enc", "-key", "5", "-data", "hello"};
        Main.main(args);
    }

    @Test
    void mainDecrypt() {
        String[] args = {"-mode", "dec", "-key", "5", "-data", "mjqqt"};
        Main.main(args);
    }

    @Test
    void encrypt() {
        String input = "mjqqt";
        int key = 5;

        assertEquals(input, Main.encrypt("hello", 5));
    }

    @Test
    void decrypt() {
        String input = "hello";
        int key = 5;
        assertEquals(input, Main.decrypt("mjqqt", 5));
    }
}