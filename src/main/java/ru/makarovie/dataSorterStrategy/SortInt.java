package ru.makarovie.dataSorterStrategy;

import java.util.List;

public interface SortInt<T extends Comparable<T>> {
    List<T> sort ();
}
