package ru.javarush.rumynskii.cryptoanalizer.controllers;

import ru.javarush.rumynskii.cryptoanalizer.commands.Action;
import ru.javarush.rumynskii.cryptoanalizer.entity.Result;

public class MainController {
    public Result doAction(String actionName,String[] parameters) {
        Action action = Actions.find(actionName);
        return action.execute(parameters);
    }

}
