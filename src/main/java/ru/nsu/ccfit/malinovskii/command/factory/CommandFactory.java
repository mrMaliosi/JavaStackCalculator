package ru.nsu.ccfit.malinovskii.command.factory;
import ru.nsu.ccfit.malinovskii.calculatorcommands.Command;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class CommandFactory {
    private Map<String, Class<? extends Command>> commandMap;           //Class<? extends Command> означает, что принимаются любые ? (неизвестные типы), extends (ограниченные) классом Command

    public CommandFactory() {
        commandMap = new HashMap<>();
    }

    public void loadConfiguration(String configFile) throws IOException {
        Properties properties = new Properties();                                                   //Хэш-таблица, где объект = объект
        try (InputStream inputStream = CommandFactory.class.getResourceAsStream(configFile)) {
            properties.load(inputStream);
        } catch (IOException e){
            e.printStackTrace();
        }

        for (String commandName : properties.stringPropertyNames()) {
            String className = properties.getProperty(commandName);
            try {
                Class<? extends Command> commandClass = Class.forName(className).asSubclass(Command.class);     //Class.forName(className) - загружает класс с указанным именем className. .asSubclass(Command.class) - проверяет, что загруженный класс является подклассом класса Command. Если это так, возвращается экземпляр типа Class<? extends Command>, который представляет класс commandClass.
                commandMap.put(commandName, commandClass);
            } catch (ClassNotFoundException e) {
                // Обработка ошибки загрузки класса команды
                e.printStackTrace();
            }
        }
    }

    public Command createCommand(String commandName) {
        Class<? extends Command> commandClass = commandMap.get(commandName);
        if (commandClass != null) {
            try {
                return commandClass.getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                // Обработка ошибки создания объекта команды
                e.printStackTrace();
            }
        }
        return null;
    }
}