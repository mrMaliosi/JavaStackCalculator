package ru.nsu.ccfit.malinovskii;
import java.util.HashMap;
import java.util.Map;
import java.util.Locale;
import java.util.LinkedList;

public class ExecutionContext {

    public Map<String, Double> parametrs;
    public LinkedList <Double> stack;
    public LinkedList <String> command;
    public Boolean isEnd;
    public ExecutionContext() {
        this.parametrs = new HashMap<String, Double>();
        this.stack = new LinkedList<Double>();
        this.command = new LinkedList<String>();
        this.isEnd = false;
    }

}