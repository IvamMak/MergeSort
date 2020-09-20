package ru.makarovie.fileChecker;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.List;

public class EmptyInputFileChecker extends BaseFileChecker {

    @Override
    public boolean check(List<Path> pathList) {
        Iterator<Path> iterator = pathList.iterator();

        while (iterator.hasNext()) {
            Path path = iterator.next();
            try {
                if (Files.size(path) == 0) {
                    System.out.println("File " + path + " is empty, this parameter was delete");
                    iterator.remove();
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        if (pathList.size() == 0) {
            System.out.println("Input files are absent");
            return false;
        } else {
            return checkNext(pathList);
        }
    }
}

