package com.example.superhero;

public class StringEncryption {
    private static final int SHIFT = 3;

    public static String encrypt(String input) {
        StringBuilder encrypted = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                char shifted = (char) (c + SHIFT);
                if (Character.isLowerCase(c) && shifted > 'z' || Character.isUpperCase(c) && shifted > 'Z') {
                    shifted -= 26;
                }
                encrypted.append(shifted);
            } else {
                encrypted.append(c);
            }
        }
        return encrypted.toString();
    }
}
