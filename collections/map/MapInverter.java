package collections.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Problem: Invert a Map
 * Invert a Map<K, V> to produce a Map<V, K>. Handle duplicate values by storing
 * them in a list.
 * Example: Input: {A=1, B=2, C=1} -> Output: {1=[A, C], 2=[B]}.
 */
public class MapInverter {

    public static <K, V> Map<V, List<K>> invertMap(Map<K, V> map) {
        Map<V, List<K>> invertedMap = new HashMap<>();

        for (Map.Entry<K, V> entry : map.entrySet()) {
            K key = entry.getKey();
            V value = entry.getValue();

            invertedMap.computeIfAbsent(value, k -> new ArrayList<>()).add(key);
        }
        return invertedMap;
    }

    public static void main(String[] args) {
        Map<String, Integer> input = new HashMap<>();
        input.put("A", 1);
        input.put("B", 2);
        input.put("C", 1);

        System.out.println("Input: " + input);
        System.out.println("Inverted: " + invertMap(input));
    }
}
