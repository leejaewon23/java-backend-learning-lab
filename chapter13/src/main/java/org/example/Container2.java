package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter

public class Container2<T, K> {
    private T Key;
    private K Value;

    public Container2() {

    }

    public T getKey() { return this.Key; }
    public K getValue() { return this.Value; }
    public void setKey(T key) { this.Key = key; }
    public void setValue(K value) { this.Value = value; }

    public void set(T 홍길동, K i) {
    }
}
