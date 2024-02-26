package ru.nsu.ccfit.malinovskii.stackcalculator;

import ru.nsu.ccfit.malinovskii.ExecutionContext;
import ru.nsu.ccfit.malinovskii.calculatorcommands.Command;
import ru.nsu.ccfit.malinovskii.command.factory.CommandFactory;
import ru.nsu.ccfit.malinovskii.parser.FileParser;
import ru.nsu.ccfit.malinovskii.parser.SystemParser;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Main {
    public static void main(String[] args) {
        int isOnline;
        if (args.length < 1) {
            isOnline = 1;
        } else if (args.length == 1) {
            isOnline = 0;
        } else {
            System.out.println("Too much arguments");
            return;
        }

        System.out.println("Oooooo, my GOD!!! It's a REAL MAN CALCULATOR 3.0!!!!");
        System.out.println("AMUZING!");
        CommandFactory factory = new CommandFactory();
        try {
            factory.loadConfiguration("/commands.properties");
        } catch (IOException e) {
            // Обработка ошибки загрузки конфигурации
            e.printStackTrace();
        }
        ExecutionContext context = new ExecutionContext();

        if (isOnline == 0) {
            try (Reader reader = new InputStreamReader(new FileInputStream(args[0]))) {
                FileParser parser = new FileParser(reader);
                while (!context.isEnd) {
                    parser.NextCommand(context);
                    Command command = factory.createCommand(context.command.element()); //Хорошая ли это идея реализации?
                    command.execute(context);
                }
            } catch (IOException e) {
                System.err.println("Error while reading file: " + e.getLocalizedMessage());
                throw new RuntimeException(e);
            }
        } else {
            SystemParser parser = new SystemParser();
            System.out.print("Input a command: \n");
            try {
                while (!context.isEnd) {
                    parser.NextCommand(context);
                    try {
                        Command command = factory.createCommand(context.command.getFirst()); //Хорошая ли это идея реализации?
                        command.execute(context);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
