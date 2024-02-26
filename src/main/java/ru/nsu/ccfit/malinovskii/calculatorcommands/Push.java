package ru.nsu.ccfit.malinovskii.calculatorcommands;

import ru.nsu.ccfit.malinovskii.ExecutionContext;

public class Push implements Command {
    @Override
    public void execute(ExecutionContext context) {
        if (context.command.size() == 2)        //Добавь при других случаях
        {
            if (context.parametrs.containsKey(context.command.get(1))) {
                context.parametrs.get(context.command.get(1));
            } else {
                context.stack.push(Double.parseDouble(context.command.get(1)));
            }

        }
    }
}