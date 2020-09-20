package ru.makarovie.config;

import ru.makarovie.argumentsService.ArgObject;
import ru.makarovie.dataSorterStrategy.MergeSort;
import ru.makarovie.dataSorterStrategy.SortInt;
import ru.makarovie.fileWorker.AbstractFileReader;
import ru.makarovie.fileWorker.IntegerFileReader;

import java.util.List;

public class IntegerDataConfig {
    private ArgObject argObject;
    private AbstractFileReader<Integer> fileReader;
    private List<List<Integer>> inputData;
    private SortInt<Integer> sortInt;

    public IntegerDataConfig(ArgObject argObject) {
        this.argObject = argObject;
    }

    public List<Integer> getResult() {
        fileReader = new IntegerFileReader(argObject.getInputFilesList());
        inputData = fileReader.readDataFromFiles();
        sortInt = new MergeSort<>(inputData, argObject.getOrder());
        return sortInt.sort();
    }
}
