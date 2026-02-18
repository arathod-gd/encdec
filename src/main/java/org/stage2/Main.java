package org.stage2;

import java.util.Scanner;

/**
 * Main class for encryption program.
 */
public class Main {

    /**
     * Entry point of the program.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        int key = scanner.nextInt();
        key = key % 26;

        System.out.println(encrypt(text, key));
    }

    /**
     * Encrypts text using Caesar cipher logic.
     */
    public static String encrypt(String text, int key) {
        char[] chars = text.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];

            if (c >= 'a' && c <= 'z') {
                chars[i] = (char) ('a' + (c - 'a' + key) % 26);
            }
        }

        return new String(chars);
    }
}
