package ru.nsu.ccfit.malinovskii.calculatorcommands;

import ru.nsu.ccfit.malinovskii.ExecutionContext;

public class Div implements Command{
    @Override
    public void execute(ExecutionContext context)
    {
        double a = context.stack.pop();
        double b = context.stack.pop();
        context.stack.push(b/a);
    }
}
