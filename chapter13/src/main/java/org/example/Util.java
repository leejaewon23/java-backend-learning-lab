package org.example;

public class Util {
    // 제네릭 메소드: 첫 번째 인자의 key와 두 번째 인자의 key가 일치하면 value 리턴
    public static <K, V> V getValue(Pair<K, V> pair, K key) {
        if (pair.getKey().equals(key)) {
            return pair.getValue();
        } else {
            return null;
        }
    }
}
