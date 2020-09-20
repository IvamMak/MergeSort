package ru.makarovie;

import ru.makarovie.argumentsService.ArgObject;
import ru.makarovie.argumentsService.StartChecker;
import ru.makarovie.config.IntegerDataConfig;
import ru.makarovie.config.StringDataConfig;
import ru.makarovie.fileWorker.ResultFileWriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        List<String> arguments = new ArrayList<>(Arrays.asList(args));

        StartChecker checker = new StartChecker(arguments);

        if (checker.check()) {
            ArgObject argObject = new ArgObject(arguments);

            if (argObject.getDataType().equals("-i")) {
                IntegerDataConfig solution = new IntegerDataConfig(argObject);
                ResultFileWriter<Integer> fileWriter = new ResultFileWriter<>(argObject.getOutputFileList());
                fileWriter.writeResult(solution.getResult());
            }
            else {
                StringDataConfig solution = new StringDataConfig(argObject);
                ResultFileWriter<String> fileWriter = new ResultFileWriter<>(argObject.getOutputFileList());
                fileWriter.writeResult(solution.getResult());
            }
        }
    }
}
