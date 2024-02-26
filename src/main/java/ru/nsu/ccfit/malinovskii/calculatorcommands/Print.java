package ru.nsu.ccfit.malinovskii.calculatorcommands;

import ru.nsu.ccfit.malinovskii.ExecutionContext;

public class Print implements Command{
    @Override
    public void execute(ExecutionContext context)
    {
        System.out.println(context.stack.getFirst());
    }
}