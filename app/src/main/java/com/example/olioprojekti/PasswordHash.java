package com.example.olioprojekti;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;


public class PasswordHash {

    public static String generatePassword(String password, byte[] salt) {
        String generatedPassword = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
            messageDigest.update(salt);
            byte[] hashedPassword = messageDigest.digest(password.getBytes(StandardCharsets.UTF_8));
            System.out.println(hashedPassword);
           StringBuilder sb = new StringBuilder(hashedPassword.length * 2);
           for(byte b: hashedPassword) {
               sb.append(String.format("%02x", b));
           }
           generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }

    public static byte[] getSalt() {
        SecureRandom sRandom = new SecureRandom();
        byte[] salt = new byte[16];
        sRandom.nextBytes(salt);
        return salt;
    }

}