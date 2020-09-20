package ru.makarovie.fileChecker;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ExistOutputFileChecker extends BaseFileChecker {

    @Override
    public boolean check(List<Path> pathList) {
        Path inputPath = pathList.get(0);
        if (!Files.isRegularFile(inputPath)) {
            System.out.println("input file " + inputPath.toString() + " is absent." +
                    " Program was close");
            return false;
        } else {
            return checkNext(pathList);
        }
    }
}
