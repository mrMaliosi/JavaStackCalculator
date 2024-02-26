package ru.nsu.ccfit.malinovskii.parser;

import ru.nsu.ccfit.malinovskii.ExecutionContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Scanner;

public class SystemParser {
    private final Scanner input = new Scanner(System.in);

    public SystemParser(){}

    public void NextCommand(ExecutionContext context) throws IOException {
        String line = input.nextLine();
        if (line != null) {
            context.command.clear();
            String[] parts = line.split(" ");
            context.command.addAll(Arrays.asList(parts));           //Не, ну это как-то прям да...
        } else {
            context.isEnd = true;
        }
    }
}
