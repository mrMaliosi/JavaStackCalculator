package ru.nsu.ccfit.malinovskii.stackcalculator;

import ru.nsu.ccfit.malinovskii.command.factory.CommandFactory;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static final Logger logger = Logger.getLogger(Main.class.getName());
    public static void main(String[] args)  {
        //Парсинг аргументов командной строки
        String fileName;
        if (args.length < 1) {
            fileName = null;
        } else if (args.length == 1) {
            fileName = args[0];
        } else {
            System.out.println("Too much arguments");
            return;
        }

        //Создание калькулятора и подготовка его к работе
        CommandFactory factory = new CommandFactory();
        StackCalculator calculator = new StackCalculator(factory);
        try {
            calculator.Setup(fileName);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Exception: ", e);
        }

        int calculation = 1;
        //Работа калькулятора
        while (calculation == 1)
        {
            try {
                calculation = calculator.calculate();
            } catch (Exception e) {
                logger.log(Level.SEVERE, "Exception: ", e);
            }
        }

    }
}
