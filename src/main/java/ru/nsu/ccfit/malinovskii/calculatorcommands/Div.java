package ru.nsu.ccfit.malinovskii.calculatorcommands;

import ru.nsu.ccfit.malinovskii.ExecutionContext;
import ru.nsu.ccfit.malinovskii.exceptions.DivisionException;

public class Div implements Command{
    @Override
    public void execute(ExecutionContext context) throws DivisionException {
        double a = context.stack.pop();
        double b = context.stack.pop();
        if (a == 0)
        {
            throw new DivisionException();
        }
        context.stack.push(b/a);
    }
}
