package ru.makarovie.dataSorterStrategy;

import java.util.ArrayList;
import java.util.List;

public class MergeSort<T extends Comparable<T>> implements SortInt<T> {
    private List<List<T>> inputData;
    private List<T> result = new ArrayList<>();
    private int order;

    public MergeSort(List<List<T>> inputData, int order) {
        this.inputData = inputData;
        this.order = order;
    }

    @Override
    public List<T> sort() {
        T zeroElement;
        List<T> zeroElementList;

        while (!inputData.isEmpty()) {
            zeroElementList = inputData.get(0);
            zeroElement = zeroElementList.get(0);

            for (List<T> list : inputData) {
                if (zeroElement.compareTo(list.get(0)) == order) {
                    zeroElement = list.get(0);
                    zeroElementList = list;
                }
            }

            checkListOrder(zeroElement, zeroElementList);

            zeroElementList.remove(0);
            if (zeroElementList.size() == 0) {
                inputData.remove(zeroElementList);
            }
            result.add(zeroElement);
        }
        return result;
    }

    private void checkListOrder(T zeroElement, List<T> zeroElementList) {
        if (zeroElementList.size() > 1
                && zeroElement.compareTo(zeroElementList.get(1)) == order) {
            fixIncorrectList(zeroElementList);
        }
    }

    private void fixIncorrectList(List<T> list) {
        while (list.size() != 1) {
            if (list.get(0).compareTo(list.get(1)) == order) {
                list.remove(1);
            } else {
                break;
            }
        }
    }
}

