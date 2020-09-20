package ru.makarovie.fileWorker;

import ru.makarovie.fileChecker.BaseFileChecker;
import ru.makarovie.fileChecker.ExistOutputFileChecker;
import ru.makarovie.fileChecker.InputFileWritableChecker;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ResultFileWriter<T> {
    private List<Path> outputFileList;

    public ResultFileWriter(List<Path> outputFileList) {
        this.outputFileList = outputFileList;
    }

    public void writeResult(List<T> resultList) {
        if (checkFiles(outputFileList)) {
            Path path = outputFileList.get(0);
            File file = path.toFile();
            try (OutputStreamWriter writer = new OutputStreamWriter(
                    new FileOutputStream(file, true), StandardCharsets.UTF_8)) {
                if (Files.size(path) > 0) {
                    clearFile(file);
                }
                for (T result : resultList) {
                    writer.write(result + "\n");
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }

    private void clearFile(File file) {
        try (FileWriter writer = new FileWriter(file, false)) {
            System.out.println("Output file not empty, file will clear before writing result");
            writer.write("");
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private boolean checkFiles(List<Path> outputFilesList) {
        BaseFileChecker fileChecker = new ExistOutputFileChecker();
        fileChecker.nextChecker(new InputFileWritableChecker());
        return fileChecker.check(outputFilesList);
    }
}
