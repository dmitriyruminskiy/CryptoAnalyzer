package ru.javarush.rumynskii.cryptoanalizer.commands;

import ru.javarush.rumynskii.cryptoanalizer.constants.Constants;
import ru.javarush.rumynskii.cryptoanalizer.entity.Result;
import ru.javarush.rumynskii.cryptoanalizer.entity.ResultCode;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BrudeForce implements Action {

    @Override
    public Result execute(String[] parameters) {
        int count3 = 0;
        int newKey = 0;
        for (int key = 0; key < Constants.ALPHABET.length(); key++) {
            try
                    (FileReader reader = new FileReader(parameters[0])) {
                char[] buffer = new char[65536];
                int count2 = 0;
                while (reader.ready()) {
                    int count = 0;
                    int real = reader.read(buffer);
                    char[] bufferNew = decodeBuffer(buffer, key);
                    for (char c : bufferNew) {
                        if (c == ' ') {
                            count++;
                        }
                    }
                    count2 = count2 + count;
                }
                if (count2 > count3) {
                    count3 = count2;
                    newKey = key;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try
                (FileReader reader = new FileReader(parameters[0]);
                 FileWriter writer = new FileWriter(parameters[1])) {
            char[] buffer = new char[65536];
            while (reader.ready()) {

                int real = reader.read(buffer);
                char[] bufferNew = decodeBuffer(buffer, newKey);
                writer.write(bufferNew, 0, real);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Result("BrudeForce complete", ResultCode.OK);
    }

    private static char[] decodeBuffer(char[] buffer, int key) {
        key = 147 - key;
        char[] alphabet = Constants.ALPHABET.toCharArray();
        char[] bufferDecode = new char[65536];
        for (int i = 0; i < buffer.length; i++) {
            for (int j = 0; j < alphabet.length; j++) {
                if (buffer[i] == alphabet[j]) {
                    bufferDecode[i] = alphabet[(j + key) % 147];
                    break;
                }
            }
        }
        return bufferDecode;
    }
}
