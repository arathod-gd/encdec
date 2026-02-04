package org.stage3;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String mode = scanner.nextLine();   // enc or dec
        String text = scanner.nextLine();   // message
        int key = scanner.nextInt();        // key

        if (mode.equals("enc")) {
            System.out.println(encrypt(text, key));
        } else {
            System.out.println(decrypt(text, key));
        }
    }

    public static String encrypt(String text, int key) {
        char[] chars = text.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) (chars[i] + key);
        }

        return new String(chars);
    }

    public static String decrypt(String text, int key) {
        char[] chars = text.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) (chars[i] - key);
        }

        return new String(chars);
    }
}

