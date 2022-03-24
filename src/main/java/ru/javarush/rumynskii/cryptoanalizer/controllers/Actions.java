package ru.javarush.rumynskii.cryptoanalizer.controllers;

import ru.javarush.rumynskii.cryptoanalizer.commands.Action;
import ru.javarush.rumynskii.cryptoanalizer.commands.BrudeForce;
import ru.javarush.rumynskii.cryptoanalizer.commands.Decoder;
import ru.javarush.rumynskii.cryptoanalizer.commands.Encoder;
import ru.javarush.rumynskii.cryptoanalizer.exception.AppException;

import java.util.Locale;

public enum Actions {
    ENCODE(new Encoder()),
    DECODE(new Decoder()),
    BRUDEFORCE(new BrudeForce());

   private final Action action;

    Actions(Action action) {
        this.action = action;
    }
    public static Action find(String actionName){
        try {
            Actions value = Actions.valueOf(actionName.toUpperCase());

            return value.action;
        }catch (IllegalArgumentException e){
            throw new AppException("not found"+actionName,e);
        }
    }
}
