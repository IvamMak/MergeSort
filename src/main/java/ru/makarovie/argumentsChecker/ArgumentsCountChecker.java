package ru.makarovie.argumentsChecker;

import java.util.List;

public class ArgumentsCountChecker extends BaseArgumentsChecker {

    @Override
    public boolean check(List<String> arguments) {
        if (arguments.size() < 3) {
            System.out.println("Arguments array has not enough elements - " + arguments.size() + ". " +
                    "Min count of elements " +
                    "3: dataType, output file, input file. Program was close.");
            return false;
        } else {
            return checkNext(arguments);
        }
    }
}
