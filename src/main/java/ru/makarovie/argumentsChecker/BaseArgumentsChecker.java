package ru.makarovie.argumentsChecker;

import java.util.List;

public abstract class BaseArgumentsChecker {
    private BaseArgumentsChecker next;

    public BaseArgumentsChecker nextChecker(BaseArgumentsChecker next) {
        this.next = next;
        return next;
    }

    public abstract boolean check(List<String> arguments);

    protected boolean checkNext(List<String> arguments) {
        if (next == null) {
            return true;
        } else {
            return next.check(arguments);
        }
    }
}
