package ru.javarush.rumynskii.cryptoanalizer.commands;

import ru.javarush.rumynskii.cryptoanalizer.entity.Result;

public interface Action {
    Result execute (String[] parameters);
}
