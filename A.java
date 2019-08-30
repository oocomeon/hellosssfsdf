package apackage;

import java.util.List;

public class A {
    private int a = 0;

    public A() {
    }

    public A(int a) {
        this.a = a;
    }

    public String processList(C c) {
        return c.toString() + a;
    }
    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "A{" +
                "a=" + a +
                '}';
    }
}
