package ru.nsu.ccfit.malinovskii.calculatorcommands;

import ru.nsu.ccfit.malinovskii.ExecutionContext;

public class Exit implements Command{
    @Override
    public void execute(ExecutionContext context)       //Добавь исключенния
    {
        context.isEnd = true;
    }
}
