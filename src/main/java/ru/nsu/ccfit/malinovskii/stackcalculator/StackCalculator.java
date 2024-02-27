package ru.nsu.ccfit.malinovskii.stackcalculator;

import ru.nsu.ccfit.malinovskii.ExecutionContext;
import ru.nsu.ccfit.malinovskii.calculatorcommands.Command;
import ru.nsu.ccfit.malinovskii.command.factory.CommandFactory;
import ru.nsu.ccfit.malinovskii.parser.CommandParser;

import static ru.nsu.ccfit.malinovskii.stackcalculator.Main.logger;


public class StackCalculator {
    private CommandFactory factory;
    private String fileName;

    public StackCalculator(CommandFactory factory) {
        this.factory = factory;
    }
    public void Setup(String fileName) throws Exception {
        SystemMessages.greetings();
        factory.loadConfiguration("/commands.properties");
        this.fileName = fileName;
        logger.info("DONE.");
    }

    public void calculate() throws Exception {
        logger.info("Calculator has started his work...");
        ExecutionContext context = new ExecutionContext();
        CommandParser parser = new CommandParser(fileName);
        while (!context.isEnd) {
            parser.NextCommand(context);
            logger.info("Executing command...");
            Command command = factory.createCommand(context.command.element());     //Фабрика без кэширования
            command.execute(context);
            logger.info("The end of command executing.");
        }
        logger.info("Calculator has ended his work.");
    }

}
