package com.example.encyption_app;

import java.util.HashMap;
import java.util.Map;

public class MonoAplhabetic {


//        private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
////        private static final String KEY = "QWERTYUIOPASDFGHJKLZXCVBNM"; // Replace with your own key
//
//        public static String encrypt(String plaintext,String Key) {
//            StringBuilder ciphertext = new StringBuilder();
//
//            for (char ch : plaintext.toUpperCase().toCharArray()) {
//                if (Character.isLetter(ch)) {
//                    int index = ALPHABET.indexOf(ch);
//                    char encryptedChar = (index != -1) ? Key.charAt(index) : ch;
//                    ciphertext.append(Character.isLowerCase(ch) ? Character.toLowerCase(encryptedChar) : encryptedChar);
//                } else {
//                    ciphertext.append(ch);
//                }
//            }
//
//            return ciphertext.toString();
//        }
//
//    public static String decrypt(String ciphertext, String key) {
//        StringBuilder plaintext = new StringBuilder();
//
//        Map<Character, Character> decryptionMap = createDecryptionMap(key);
//
//        for (char c : ciphertext.toCharArray()) {
//            if (Character.isLetter(c)) {
//                char decryptedChar = decryptionMap.get(Character.toUpperCase(c));
//                if (Character.isLowerCase(c)) {
//                    decryptedChar = Character.toLowerCase(decryptedChar);
//                }
//                plaintext.append(decryptedChar);
//            } else {
//                plaintext.append(c);
//            }
//        }
//        return plaintext.toString();
//    }
//
//    public static Map<Character, Character> createDecryptionMap(String key) {
//        Map<Character, Character> decryptionMap = new HashMap<>();
//
//        for (int i = 0; i < ALPHABET.length(); i++) {
//            char originalChar = ALPHABET.charAt(i);
//            char keyChar = key.charAt(i);
//            decryptionMap.put(keyChar, originalChar);
//        }
//
//        return decryptionMap;
//    }


    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String encrypt(String plaintext, String key) {
        StringBuilder ciphertext = new StringBuilder();

        Map<Character, Character> encryptionMap = createEncryptionMap(key);

        for (char c : plaintext.toCharArray()) {
            if (Character.isLetter(c)) {
                char encryptedChar = encryptionMap.get(Character.toUpperCase(c));
                encryptedChar = (Character.isLowerCase(c)) ? Character.toLowerCase(encryptedChar) : encryptedChar;
                ciphertext.append(encryptedChar);
            } else {
                ciphertext.append(c);
            }
        }

        return ciphertext.toString();
    }

    public static String decrypt(String ciphertext, String key) {
        StringBuilder plaintext = new StringBuilder();

        Map<Character, Character> decryptionMap = createDecryptionMap(key);

        for (char c : ciphertext.toCharArray()) {
            if (Character.isLetter(c)) {
                char decryptedChar = decryptionMap.get(Character.toUpperCase(c));
                decryptedChar = (Character.isLowerCase(c)) ? Character.toLowerCase(decryptedChar) : decryptedChar;
                plaintext.append(decryptedChar);
            } else {
                plaintext.append(c);
            }
        }

        return plaintext.toString();
    }

    private static Map<Character, Character> createEncryptionMap(String key) {
        Map<Character, Character> encryptionMap = new HashMap<>();

        for (int i = 0; i < ALPHABET.length(); i++) {
            char originalChar = ALPHABET.charAt(i);
            char keyChar = key.charAt(i);
            encryptionMap.put(originalChar, keyChar);
        }

        return encryptionMap;
    }

    private static Map<Character, Character> createDecryptionMap(String key) {
        Map<Character, Character> decryptionMap = new HashMap<>();

        for (int i = 0; i < ALPHABET.length(); i++) {
            char originalChar = ALPHABET.charAt(i);
            char keyChar = key.charAt(i);
            decryptionMap.put(keyChar, originalChar);
        }

        return decryptionMap;
    }
}
