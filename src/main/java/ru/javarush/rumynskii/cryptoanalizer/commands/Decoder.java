package ru.javarush.rumynskii.cryptoanalizer.commands;

import ru.javarush.rumynskii.cryptoanalizer.constants.Constants;
import ru.javarush.rumynskii.cryptoanalizer.entity.Result;
import ru.javarush.rumynskii.cryptoanalizer.entity.ResultCode;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Decoder implements Action {
    @Override
    public Result execute(String[] parameters) {
        try
                (FileReader reader = new FileReader(parameters[0]);
                 FileWriter writer = new FileWriter(parameters[1])) {
            char[] buffer = new char[65536];
            while (reader.ready()) {
                int real = reader.read(buffer);
                char[] bufferNew = decodeBuffer(buffer,parameters[2]);
                writer.write(bufferNew, 0, real);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Result("decode all right",ResultCode.OK);
    }

    public char[] decodeBuffer(char[] buffer, String keyInString) {
        int key = 147-Integer.parseInt(keyInString);
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


