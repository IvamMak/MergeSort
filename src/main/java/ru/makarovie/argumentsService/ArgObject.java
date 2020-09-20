package ru.makarovie.argumentsService;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ArgObject {
    private String dataType;
    private int order;
    private List<Path> outputFileList;
    private List<Path> inputFilesList;
    private List<String> arguments;

    public ArgObject(List<String> arguments) {
        this.arguments = arguments;
        this.outputFileList = getOutputFile();
        this.inputFilesList = getInputFiles();
        this.dataType = getDataTypeFromArguments();
        this.order = getOrderFromArguments();
    }

    private List<Path> getOutputFile() {
        List<Path> result = new ArrayList<>();
        String path = arguments.get(getIndexOfFirstPath());
        Path outputFile = Paths.get(path);
        result.add(outputFile);
        return result;
    }

    private List<Path> getInputFiles() {
        List<Path> result = new ArrayList<>();
        String path;
        Path inputFile;

        for (int i = getIndexOfFirstPath() + 1; i < arguments.size(); i++) {
            path = arguments.get(i);
            inputFile = Paths.get(path);
            result.add(inputFile);
        }
        return result;
    }

    private int getIndexOfFirstPath() {
        int index = 0;
        for (int i = 0; i < arguments.size(); i++) {
            String path = arguments.get(i);
            if (Files.isRegularFile(Paths.get(path))) {
                index = i;
                break;
            }
        }
        return index;
    }

    private String getDataTypeFromArguments() {
        if (arguments.contains("-i")) {
            return "-i";
        } else {
            return "-s";
        }
    }

    private int getOrderFromArguments() {
        if (arguments.contains("-d")) {
            return -1;
        } else {
            return 1;
        }
    }

    public int getOrder() {
        return order;
    }

    public String getDataType() {
        return dataType;
    }

    public List<Path> getOutputFileList() {
        return outputFileList;
    }

    public List<Path> getInputFilesList() {
        return inputFilesList;
    }
}
