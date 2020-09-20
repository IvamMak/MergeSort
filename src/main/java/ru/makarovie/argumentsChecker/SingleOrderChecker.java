package ru.makarovie.argumentsChecker;

import java.util.List;

public class SingleOrderChecker extends BaseArgumentsChecker {

    @Override
    public boolean check(List<String> arguments) {
        if (arguments.contains("-a") && arguments.contains("-d")) {
            System.out.println("You have more than one order for sorting in arguments, " +
                    "for next work program will use -a order. " +
                    "All -d arguments were delete");

            arguments.removeIf(e -> e.equals("-d"));
        }
        return checkNext(arguments);
    }
}
