package ru.nsu.ccfit.malinovskii.calculatorcommands;

import ru.nsu.ccfit.malinovskii.ExecutionContext;

import static java.lang.Math.sqrt;

public class Sqrt implements Command{
    @Override
    public void execute(ExecutionContext context)
    {
        double a = context.stack.pop();
        context.stack.push(sqrt(a));
    }
}