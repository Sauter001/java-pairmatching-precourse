package pairmatching.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class ListUtil {
    @SafeVarargs
    public static <T> List<T> listOf(T... items) {
        return new ArrayList<>(Arrays.asList(items));
    }
}
