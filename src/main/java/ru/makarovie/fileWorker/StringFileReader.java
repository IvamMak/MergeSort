package ru.makarovie.fileWorker;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class StringFileReader extends AbstractFileReader<String> {
    private List<Path> inputFilesList;

    public StringFileReader(List<Path> inputFilesList) {
        this.inputFilesList = inputFilesList;
    }

    @Override
    public List<List<String>> readDataFromFiles() {
        List<List<String>> result = new ArrayList<>();
        if (checkFiles(inputFilesList)) {
            result = readData(inputFilesList);
        }
        return result;
    }
}
