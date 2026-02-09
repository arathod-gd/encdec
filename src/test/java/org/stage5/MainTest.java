package org.stage5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void encTest(){
        String[] args = {"-mode", "enc", "-key", "5", "-data", "hello"};
        org.stage4.Main.main(args);
    }

    @Test
    void decTest(){
        String[] args = {"-mode", "dec", "-key", "5", "-data", "mjqqt"};
        org.stage4.Main.main(args);
    }


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