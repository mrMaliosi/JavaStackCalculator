package ru.nsu.ccfit.malinovskii.parser;

import ru.nsu.ccfit.malinovskii.ExecutionContext;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.BufferedReader;
import java.util.Arrays;

public class FileParser {
    private final BufferedReader reader;

    public FileParser(Reader reader) {
        this.reader = new BufferedReader(reader);
    }

    public void NextCommand(ExecutionContext context) throws IOException {
        String line = reader.readLine();
        if (line != null) {
            context.command.clear();
            String[] parts = line.split(" ");
            context.command.addAll(Arrays.asList(parts));           //Не, ну это как-то прям да...
        } else {
            context.isEnd = true;
        }
    }
}