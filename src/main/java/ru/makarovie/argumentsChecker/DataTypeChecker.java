package ru.makarovie.argumentsChecker;

import java.util.List;

public class DataTypeChecker extends BaseArgumentsChecker {

    @Override
    public boolean check(List<String> arguments) {
        if (arguments.contains("-s") || arguments.contains("-i")) {
            return checkNext(arguments);
        } else {
            System.out.println("Data type argument is absent. Program was close.");
            return false;
        }
    }
}
