package ru.makarovie.argumentsService;

import ru.makarovie.argumentsChecker.*;

import java.util.List;

public class StartChecker {
    private List<String> arguments;

    public StartChecker(List<String> arguments) {
        this.arguments = arguments;
    }

    public boolean check (){
        return checkArguments(arguments);
    }

    private boolean checkArguments(List<String> arguments) {
        BaseArgumentsChecker baseArgumentsChecker = new ArgumentsCountChecker();
        baseArgumentsChecker.nextChecker(new DataTypeChecker())
                .nextChecker(new ArgumentsCountChecker())
                .nextChecker(new TwoFilesExistChecker())
                .nextChecker(new SingleDataTypeChecker())
                .nextChecker(new SingleOrderChecker());

        return baseArgumentsChecker.check(arguments);
    }
}
