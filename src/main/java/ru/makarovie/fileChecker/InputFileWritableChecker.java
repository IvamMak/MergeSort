package ru.makarovie.fileChecker;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class InputFileWritableChecker extends BaseFileChecker {

    @Override
    public boolean check(List<Path> pathList) {
        Path path = pathList.get(0);
        if (!Files.isWritable(path)) {
            System.out.println("Output file not writable");
            return false;
        }
        return checkNext(pathList);
    }
}
