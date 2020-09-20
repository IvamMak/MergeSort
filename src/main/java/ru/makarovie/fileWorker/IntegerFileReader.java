package ru.makarovie.fileWorker;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class IntegerFileReader extends AbstractFileReader<Integer> {
    private List<Path> inputFilesList;

    public IntegerFileReader(List<Path> inputFilesList) {
        this.inputFilesList = inputFilesList;
    }

    @Override
    public List<List<Integer>> readDataFromFiles() {
        List<List<String>> result = new ArrayList<>();
        if (checkFiles(inputFilesList)) {
            result = readData(inputFilesList);
            checkNumbers(result);
        }
        return convertToInteger(result);
    }

    private void checkNumbers(List<List<String>> listsWithData) {
        listsWithData.forEach(list ->
                list.removeIf(e -> !e.matches("[0-9]+")));

        listsWithData.removeIf(list -> list.size() == 0);
    }

    private List<List<Integer>> convertToInteger(List<List<String>> listsWithData) {
        List<List<Integer>> result = new ArrayList<>();

        for (List<String> list : listsWithData) {
            result.add(list.stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList()));
        }
        return result;
    }
}
