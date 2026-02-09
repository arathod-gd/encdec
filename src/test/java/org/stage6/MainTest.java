package org.stage6;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {



    //main method testing
    @Test
    void encTest(){
        String[] args = {"-mode", "enc", "-key", "5", "-data", "hello"};
        org.stage6.Main.main(args);
    }

    @Test
    void decTest(){
        String[] args = {"-mode", "dec", "-key", "5", "-data", "mjqqt"};
        org.stage6.Main.main(args);
    }


    // ---------- UNICODE ----------

    @Test
    void unicodeEncrypt() {
        String input = "abcXYZ123";
        int key = 3;

        String result = Main.unicodeEncrypt(input, key);

        assertEquals("def[\\]456", result);
    }

    @Test
    void unicodeDecrypt() {
        String input = "def[\\]456";
        int key = 3;

        String result = Main.unicodeDecrypt(input, key);

        assertEquals("abcXYZ123", result);
    }

    // ---------- SHIFT (Caesar) ----------

    @Test
    void shiftEncrypt() {
        String input = "abcXYZ";
        int key = 3;

        String result = Main.shiftEncrypt(input, key);

        assertEquals("defABC", result);
    }

    @Test
    void shiftDecrypt() {
        String input = "defABC";
        int key = 3;

        String result = Main.shiftDecrypt(input, key);

        assertEquals("abcXYZ", result);
    }

    // ---------- EXTRA SAFETY TESTS ----------

    @Test
    void shiftEncrypt_wrapAround() {
        String input = "xyzXYZ";
        int key = 4;

        String result = Main.shiftEncrypt(input, key);

        assertEquals("bcdBCD", result);
    }

    @Test
    void shiftEncrypt_nonAlphabeticCharactersUnchanged() {
        String input = "Hello, World! 123";
        int key = 5;

        String result = Main.shiftEncrypt(input, key);

        assertEquals("Mjqqt, Btwqi! 123", result);
    }

    @Test
    void encryptThenDecrypt_returnsOriginal_shift() {
        String input = "AttackAtDawn";
        int key = 10;

        String encrypted = Main.shiftEncrypt(input, key);
        String decrypted = Main.shiftDecrypt(encrypted, key);

        assertEquals(input, decrypted);
    }

    @Test
    void encryptThenDecrypt_returnsOriginal_unicode() {
        String input = "Encryption Test";
        int key = 7;

        String encrypted = Main.unicodeEncrypt(input, key);
        String decrypted = Main.unicodeDecrypt(encrypted, key);

        assertEquals(input, decrypted);
    }
}
