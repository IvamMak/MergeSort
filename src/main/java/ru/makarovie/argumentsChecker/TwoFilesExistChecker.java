package ru.makarovie.argumentsChecker;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class TwoFilesExistChecker extends BaseArgumentsChecker {

    @Override
    public boolean check(List<String> arguments) {
        long countOfFiles = arguments.stream()
                .filter(e -> Files.exists(Paths.get(e)))
                .count();

        if (countOfFiles < 2) {
            System.out.println("Not enough files in arguments, only " +
                    countOfFiles + " argument(s) defined as file. Min count of files - 2 " +
                    "(input file, output file). Program was close.");
            return false;
        } else {
            return checkNext(arguments);
        }
    }
}
