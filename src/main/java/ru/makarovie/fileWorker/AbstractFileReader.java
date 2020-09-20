package ru.makarovie.fileWorker;

import ru.makarovie.fileChecker.BaseFileChecker;
import ru.makarovie.fileChecker.EmptyInputFileChecker;
import ru.makarovie.fileChecker.ExistInputFileChecker;
import ru.makarovie.fileChecker.OutputFileReadableChecker;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractFileReader<T extends Comparable<T>> {

    public abstract List<List<T>> readDataFromFiles();

    protected List<List<String>> readData(List<Path> inputFilesList) {
        List<List<String>> result = new ArrayList<>();

        for (Path path : inputFilesList) {
            try {
                result.add(Files.lines(path)
                        .collect(Collectors.toList()));
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return result;
    }

    protected boolean checkFiles(List<Path> inputFilesList) {
        BaseFileChecker fileChecker = new ExistInputFileChecker();
        fileChecker.nextChecker(new OutputFileReadableChecker())
        .nextChecker(new EmptyInputFileChecker());
        return fileChecker.check(inputFilesList);
    }
}
