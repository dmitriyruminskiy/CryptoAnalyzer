package ru.javarush.rumynskii.cryptoanalizer.commands;

import ru.javarush.rumynskii.cryptoanalizer.constants.Constants;
import ru.javarush.rumynskii.cryptoanalizer.entity.Result;
import ru.javarush.rumynskii.cryptoanalizer.entity.ResultCode;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Encoder implements Action{

    @Override
    public Result execute(String[] parameters) {
        try
                (FileReader reader = new FileReader(parameters[0]);
                 FileWriter writer = new FileWriter(parameters[1])) {
            char[] buffer = new char[65536];
            while (reader.ready()) {
                int real = reader.read(buffer);
                char[] bufferNew = encodeBuffer(buffer,parameters[2]);
                writer.write(bufferNew, 0, real);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Result("encode all right", ResultCode.OK);
    }
    public char[] encodeBuffer(char[] buffer, String keyInString) {
        int key = Integer.parseInt(keyInString);
        char[] alphabet = Constants.ALPHABET.toCharArray();
        char[] bufferEncode = new char[65536];
        for (int i = 0; i < buffer.length; i++) {
            for (int j = 0; j < alphabet.length; j++) {
                if (buffer[i] == alphabet[j]) {
                    bufferEncode[i] = alphabet[(j + key) % 147];
                    break;
                }
            }
        }
        return bufferEncode;
    }

}
