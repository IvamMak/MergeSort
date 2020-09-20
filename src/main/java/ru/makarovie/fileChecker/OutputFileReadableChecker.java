package ru.makarovie.fileChecker;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.List;

public class OutputFileReadableChecker extends BaseFileChecker {

    @Override
    public boolean check(List<Path> pathList) {
        Iterator<Path> iterator = pathList.iterator();
        while (iterator.hasNext()) {
            Path path = iterator.next();
            if (!Files.isReadable(path)) {
                System.out.println("File " + path + " isn't readable, it was delete");
                iterator.remove();
            }
        }
        if (pathList.size() == 0) {
            System.out.println("Output files are absent");
            return false;
        } else {
            return checkNext(pathList);
        }
    }
}
