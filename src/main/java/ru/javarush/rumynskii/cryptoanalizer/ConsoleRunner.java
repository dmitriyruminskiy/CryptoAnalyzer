package ru.javarush.rumynskii.cryptoanalizer;

import ru.javarush.rumynskii.cryptoanalizer.Application;
import ru.javarush.rumynskii.cryptoanalizer.entity.Result;

public class ConsoleRunner {
    public static void main(String[] args) {
        Application application = new Application();
        Result result = application.run(args);
        System.out.println(result);
    }
}

//String key = "123";
//String text = "Привет медвед";
//String result = ".............";