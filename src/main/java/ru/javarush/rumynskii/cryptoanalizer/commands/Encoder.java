package ru.javarush.rumynskii.cryptoanalizer.commands;

import ru.javarush.rumynskii.cryptoanalizer.entity.Result;
import ru.javarush.rumynskii.cryptoanalizer.entity.ResultCode;

public class Encoder implements Action{

    @Override
    public Result execute(String[] parameters) {
        return new Result("encode all right", ResultCode.OK);
    }
}
