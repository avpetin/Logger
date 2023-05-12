package org.example;

import java.util.ArrayList;
import java.util.List;

public class Filter {
    protected int threshold;

    public Filter(int threshold) {
        this.threshold = threshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        Logger logger = Logger.getInstance();
        List<Integer> result = new ArrayList<>();
        int counter = 0;
        for (int n : source) {
            if (n < threshold) {
                result.add(n);
                logger.log("Элемент " + n + " проходит ");
                counter++;
            } else {
                logger.log("Элемент " + n + " не проходит ");
            }
        }
        System.out.println("Прошло фильтр " + counter + " элемента из " + source.size());
        return result;
    }
}
