package com.example.encyption_app;

public class CeasarCipher {

        // Encrypts a given plaintext with a specified shift
        public static String encrypt(String plaintext, int shift) {
            StringBuilder ciphertext = new StringBuilder();

            for (int i = 0; i < plaintext.length(); i++) {
                char ch = plaintext.charAt(i);

                if (Character.isLetter(ch)) {
                    char encryptedChar = (char) ((Character.toUpperCase(ch) - 'A' + shift) % 26 + 'A');
                    ciphertext.append(Character.isLowerCase(ch) ? Character.toLowerCase(encryptedChar) : encryptedChar);
                } else {
                    ciphertext.append(ch);
                }
            }

            return ciphertext.toString();
        }

        // Decrypts a given ciphertext with a specified shift
        public static String decrypt(String ciphertext, int shift) {
            return encrypt(ciphertext, 26 - shift);
        }

    }

