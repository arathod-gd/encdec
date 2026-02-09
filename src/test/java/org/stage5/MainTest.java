package org.stage5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void encrypt() {
        String input = "mjqqt";
        int key = 5;

        assertEquals(input, Main.encrypt("hello",5));
    }

    @Test
    void decrypt() {
        String input = "hello";
        int key = 5;

        assertEquals(input,Main.decrypt("mjqqt", 5));
    }
}