package ru.makarovie.argumentsChecker;

import java.util.List;

public class SingleDataTypeChecker extends BaseArgumentsChecker {

    @Override
    public boolean check(List<String> arguments) {
        if (arguments.contains("-i") && arguments.contains("-s")) {
            System.out.println("You have more than one data type in arguments, " +
                    "for next work program will use String type. " +
                    "All -i arguments were delete");

            arguments.removeIf(e -> e.equals("-i"));
        }
        return checkNext(arguments);
    }
}
