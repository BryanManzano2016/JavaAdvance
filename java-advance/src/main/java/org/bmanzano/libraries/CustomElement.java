package org.bmanzano.libraries;

public class CustomElement {
    private Integer value;
    public CustomElement(Integer value) {
        this.value = value;
    }
    public Integer getValue() {
        return value;
    }
    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "CustomElement{" +
                "value=" + value +
                '}';
    }
}
