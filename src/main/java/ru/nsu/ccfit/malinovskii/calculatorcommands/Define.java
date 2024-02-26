package ru.nsu.ccfit.malinovskii.calculatorcommands;

import ru.nsu.ccfit.malinovskii.ExecutionContext;

public class Define implements Command{
    @Override
    public void execute(ExecutionContext context)
    {
        context.parametrs.put(context.command.get(1), Double.parseDouble(context.command.get(2)));
    }
}
