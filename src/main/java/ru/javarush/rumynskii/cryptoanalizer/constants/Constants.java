package ru.javarush.rumynskii.cryptoanalizer.constants;

public class Constants {
    private static final String rus = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЫЬЪЭЮЯ";
    private static final String eng = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String cypher = "0123456789";
    private static final String z = "!@#$%^&*()[]{}?.,-";
    public static final String ALPHABET = rus + eng + rus.toLowerCase() + eng.toLowerCase() + cypher + z + ' ';

}
