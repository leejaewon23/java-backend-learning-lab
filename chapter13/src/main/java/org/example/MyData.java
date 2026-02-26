package org.example;

import java.util.ArrayList;
import java.util.List;

public class MyData<K, V> {

    // 키와 값을 한 쌍으로 저장할 내부 클래스
    private class Entry<EK, EV> {
        EK key;
        EV value;

        Entry(EK key, EV value) {
            this.key = key;
            this.value = value;
        }
    }

    private List<Entry<K, V>> dataList = new ArrayList<>();

    // m1. 추가 또는 수정
    public void put(K key, V value) {
        for (Entry<K, V> entry : dataList) {
            if (entry.key.equals(key)) {
                entry.value = value; // 키가 존재하면 값 수정
                return;
            }
        }
        dataList.add(new Entry<>(key, value)); // 존재하지 않으면 새로 추가
    }

    // m2. 값 가져오기
    public V get(K key) {
        for (Entry<K, V> entry : dataList) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null; // 키가 없으면 null 리턴
    }

    // m3. 삭제하기
    public boolean remove(K key) {
        return dataList.removeIf(entry -> entry.key.equals(key));
    }

    // m4. 데이터 개수 리턴
    public int size() {
        return dataList.size();
    }

    // m5. 값 교환 (change)
    public void change(K key1, K key2) {
        int index1 = -1, index2 = -1;

        for (int i = 0; i < dataList.size(); i++) {
            if (dataList.get(i).key.equals(key1)) index1 = i;
            if (dataList.get(i).key.equals(key2)) index2 = i;
        }

        if (index1 != -1 && index2 != -1) {
            V tempValue = dataList.get(index1).value;
            dataList.get(index1).value = dataList.get(index2).value;
            dataList.get(index2).value = tempValue;
        } else {
            System.out.println("존재하지 않는 키가 포함되어 있어 교환이 불가능합니다.");
        }
    }
}
