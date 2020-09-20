package ru.makarovie.config;

import ru.makarovie.argumentsService.ArgObject;
import ru.makarovie.dataSorterStrategy.MergeSort;
import ru.makarovie.dataSorterStrategy.SortInt;
import ru.makarovie.fileWorker.AbstractFileReader;
import ru.makarovie.fileWorker.StringFileReader;

import java.util.List;

public class StringDataConfig {
    private ArgObject argObject;
    private AbstractFileReader<String> fileReader;
    private List<List<String>> inputData;
    private SortInt<String> sortInt;

    public StringDataConfig(ArgObject argObject) {
        this.argObject = argObject;
    }

    public List<String> getResult() {
        fileReader = new StringFileReader(argObject.getInputFilesList());
        inputData = fileReader.readDataFromFiles();
        sortInt = new MergeSort<>(inputData, argObject.getOrder());
        return sortInt.sort();
    }
}
