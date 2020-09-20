package ru.makarovie.fileChecker;

import java.nio.file.Path;
import java.util.List;

public abstract class BaseFileChecker {
    private BaseFileChecker next;

    public BaseFileChecker nextChecker(BaseFileChecker next) {
        this.next = next;
        return next;
    }

    public abstract boolean check(List<Path> pathList);

    protected boolean checkNext(List<Path> pathList) {
        if (next == null) {
            return true;
        } else {
            return next.check(pathList);
        }
    }
}
